package cn.booktable.modules.elasticsearch.service.elasticsearch.impl;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.elasticsearch.core.ElasticsearchException;
import cn.booktable.modules.elasticsearch.service.elasticsearch.EsSearchService;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author ljc
 */
@Service("esSearchService")
public class EsSearchServiceImpl implements EsSearchService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public <T> PageDo<T> matchQuery(Class<T> t, int pageIndex, int pageSize, String index, Map<String, Object> selected) {

        PageDo<T> pageResult=new PageDo<T>(Long.valueOf(String.valueOf(pageIndex)), pageSize);

        try {
            SearchSourceBuilder builder = new SearchSourceBuilder();
            if (selected == null || selected.isEmpty()) {
                builder.query(QueryBuilders.matchAllQuery());
            }else{
                for(String key:selected.keySet()) {
                    QueryBuilder matchQueryBuilder =QueryBuilders.matchQuery(key,selected.get(key));
                    builder.query(matchQueryBuilder);
                }
            }
            int startIndex= pageSize * (pageIndex-1);
            builder.from(startIndex);
            builder.size(pageSize);
            builder.timeout(new TimeValue(60, TimeUnit.SECONDS));



            SearchRequest searchRequest = new SearchRequest(index);
            searchRequest.source(builder);
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            if(searchResponse.status()== RestStatus.OK) {
                List<T> result=new ArrayList<>();
                long total=  searchResponse.getHits().getTotalHits().value;
                pageResult.setTotalNum(total);
                if(total>0){
                    searchResponse.getHits().forEach(item->{
                        result.add(JSON.parseObject(item.getSourceAsString(),t));
                    });
                }
                pageResult.setPage(result);
            }
        }catch (IOException ex){
            throw new ElasticsearchException(ex);
        }
        return pageResult;
    }
}
