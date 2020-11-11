package cn.booktable.modules.elasticsearch.service.elasticsearch.impl;

import cn.booktable.modules.elasticsearch.core.EsEntity;
import cn.booktable.modules.elasticsearch.core.EsIndexMappings;
import cn.booktable.modules.elasticsearch.service.elasticsearch.IndexDocumentService;
import com.alibaba.fastjson.JSON;
import io.micrometer.core.instrument.search.Search;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ljc
 */
@Service("indexDocumentService")
public class IndexDocumentServiceImpl implements IndexDocumentService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public boolean existIndex(String index) {
        try {
            GetRequest getRequest = new GetRequest(
                    index,
                    "1");
            getRequest.fetchSourceContext(new FetchSourceContext(false));
            getRequest.storedFields("_none_");
            return restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void createIndex(String index, EsIndexMappings mappings, int shards, int replicas) {
        if (this.existIndex(index)) {
            return;
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
            throw new RuntimeException("请求Elasticsearch服务失败");
        }
    }

    @Override
    public void insertOrUpdate(String index, EsEntity entity) {
        try {
            IndexRequest request = new IndexRequest(index);
            request.id(entity.getId());
            request.source(entity.getJsonData(), XContentType.JSON);
            IndexResponse indexResponse=null;

            try {
                indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);
            }catch (ElasticsearchException e){
                // 捕获，并处理异常
                //判断是否版本冲突、create但文档已存在冲突
                if (e.status() == RestStatus.CONFLICT) {
                    throw new cn.booktable.modules.elasticsearch.core.ElasticsearchException("版本冲突",e);
                }
            }

            //5、处理响应
            if (indexResponse != null) {
                String index1 = indexResponse.getIndex();
                String type1 = indexResponse.getType();
                String id1 = indexResponse.getId();
                long version1 = indexResponse.getVersion();
                if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
                    System.out.println("新增文档成功! index=" + index1+",type=" + type1 +",id="+ id1 +",version="+ version1);
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


        }catch (IOException ex){
            throw new RuntimeException("插入索引失败",ex);
        }
    }

    @Override
    public void updateIndex(String index, EsEntity entity) {
        try {

            UpdateRequest request = new UpdateRequest(index,entity.getId());
            request.doc(entity.getJsonData(), XContentType.JSON);
            UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);

        }catch (IOException ex){
            throw new RuntimeException("更新索引失败",ex);
        }
    }

    @Override
    public <T> List<T> search(String index, SearchSourceBuilder builder, Class<T> c) {
        List<T> result=new ArrayList<>();
        try {

            SearchRequest searchRequest = new SearchRequest(index);
            searchRequest.source(builder);
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            if(searchResponse.status()==RestStatus.OK) {
                long total=  searchResponse.getHits().getTotalHits().value;
                if(total>0){
                    searchResponse.getHits().forEach(item->{
                        result.add(JSON.parseObject(item.getSourceAsString(),c));
                    });
                }
            }
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
        return result;
    }

    @Override
    public boolean deleteIndex(String index,String id) {
        try {
            DeleteRequest request = new DeleteRequest(index,id);
            DeleteResponse deleteResponse = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
            if(deleteResponse.status()==RestStatus.OK){
                return true;
            }
            return false;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public IndexResponse indexSync(String index, Map<String, Object> document) {
        try {
            final IndexRequest request = new IndexRequest(index)
                    .source(document);
            return restHighLevelClient.index(request, RequestOptions.DEFAULT);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }


}
