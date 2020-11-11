package cn.booktable.modules.elasticsearch.service.elasticsearch.impl;

import cn.booktable.modules.elasticsearch.core.ElasticsearchException;
import cn.booktable.modules.elasticsearch.core.EsIndexMappings;
import cn.booktable.modules.elasticsearch.service.elasticsearch.EsIndexService;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author ljc
 */
@Service("esIndexService")
public class EsIndexServiceImpl implements EsIndexService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

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
}
