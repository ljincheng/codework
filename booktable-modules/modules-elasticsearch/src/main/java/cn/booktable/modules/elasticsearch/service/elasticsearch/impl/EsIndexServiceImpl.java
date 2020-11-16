package cn.booktable.modules.elasticsearch.service.elasticsearch.impl;

import cn.booktable.modules.elasticsearch.core.ElasticsearchException;
import cn.booktable.modules.elasticsearch.core.EsEntity;
import cn.booktable.modules.elasticsearch.core.EsIndexMappings;
import cn.booktable.modules.elasticsearch.feign.ElasticsearchClient;
import cn.booktable.modules.elasticsearch.service.elasticsearch.EsIndexService;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ljc
 */
@Service("esIndexService")
public class EsIndexServiceImpl implements EsIndexService {

    private static Logger logger= LoggerFactory.getLogger(EsIndexServiceImpl.class);

    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Override
    public boolean exist(String index) {
        try {
            GetIndexRequest getRequest = new GetIndexRequest(index);
            return restHighLevelClient.indices().exists(getRequest,RequestOptions.DEFAULT);
        }catch (IOException ex){
            throw new ElasticsearchException(ex);
        }
    }

    @Override
    public boolean create(String index, EsIndexMappings mappings, int shards, int replicas) {
        if (this.exist(index)) {
            return false;
        }
        try {
            CreateIndexRequest request = new CreateIndexRequest(index);
            request.settings(Settings.builder()
                    // 分片数
                    .put("index.number_of_shards", shards)
                    // 副本数
                    .put("index.number_of_replicas", replicas));
            // 指定mappings
            request.mapping(JSON.toJSONString(mappings), XContentType.JSON);
            CreateIndexResponse res = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
            if (!res.isAcknowledged()) {
                throw new RuntimeException("所以创建失败！");
            }
        }catch (IOException ex){
            throw new ElasticsearchException("请求索引异常",ex);
        }
        return true;
    }

    @Override
    public boolean insert(String index, EsEntity entity) {
        String result=elasticsearchClient.insert(index,entity.getJsonData());
        logger.info("Insert Elasticsearch result="+result);
        return false;
    }

    @Override
    public boolean insertOrUpdate(String index, EsEntity entity) {
        try {
            IndexRequest request = new IndexRequest(index);
            request.id(entity.getId());
            request.source(entity.getJsonData(), XContentType.JSON);
            IndexResponse indexResponse = null;

            try {
                indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);
            } catch (org.elasticsearch.ElasticsearchException e) {
                // 捕获，并处理异常
                //判断是否版本冲突、create但文档已存在冲突
                if (e.status() == RestStatus.CONFLICT) {
                    throw new cn.booktable.modules.elasticsearch.core.ElasticsearchException("版本冲突", e);
                }
            }

            //5、处理响应
            if (indexResponse != null) {
                String index1 = indexResponse.getIndex();
                String type1 = indexResponse.getType();
                String id1 = indexResponse.getId();
                long version1 = indexResponse.getVersion();
                if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
                    System.out.println("新增文档成功! index=" + index1 + ",type=" + type1 + ",id=" + id1 + ",version=" + version1);
                } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
                    System.out.println("修改文档成功!");
                }
                // 分片处理信息
                ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
                if (shardInfo.getTotal() != shardInfo.getSuccessful()) {
                    System.out.println("分片处理信息.....");
                }
                // 如果有分片副本失败，可以获得失败原因信息
                if (shardInfo.getFailed() > 0) {
                    for (ReplicationResponse.ShardInfo.Failure failure : shardInfo.getFailures()) {
                        String reason = failure.reason();
                        System.out.println("副本失败原因：" + reason);
                    }
                }
            }
        }catch (IOException e){
            throw new ElasticsearchException(e);
        }
        return true;
    }

    @Override
    public boolean delete(String index) {
        try {
            DeleteIndexRequest request = new DeleteIndexRequest(index);
              restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);

        }catch (org.elasticsearch.ElasticsearchException e){
            throw new ElasticsearchException(e);
        }catch (IOException ex)
        {
            throw new ElasticsearchException(ex);
        }
        return true;
    }


    @Override
    public List<String> indexs() {
        List<String> result=new ArrayList<>();
        try {
            GetIndexRequest request = new GetIndexRequest("*");
            GetIndexResponse response = restHighLevelClient.indices().get(request, RequestOptions.DEFAULT);
            String[] indices = response.getIndices();
            if (indices != null) {
                for(int i=0,k=indices.length;i<k;i++){
                    result.add(indices[i]);
                }
            }
        }catch (IOException e){
            throw new ElasticsearchException(e);
        }

        return result;
    }
}
