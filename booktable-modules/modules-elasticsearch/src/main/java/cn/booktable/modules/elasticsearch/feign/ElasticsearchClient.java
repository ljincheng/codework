package cn.booktable.modules.elasticsearch.feign;

import cn.booktable.modules.elasticsearch.bean.ElasticsearchBo;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author ljc
 */
public interface ElasticsearchClient {

    @RequestLine("GET /")
    ElasticsearchBo info();

    @RequestLine("POST /{index}/_doc?pretty")
    @Headers({"Content-Type: application/json; charset=utf8"})
    String insert( @Param("index") String index,@RequestBody String raw);
}
