package cn.booktable.modules.elasticsearch.feign;

import cn.booktable.modules.elasticsearch.bean.ElasticsearchBo;
import feign.RequestLine;

/**
 * @author ljc
 */
public interface ElasticsearchClient {

    @RequestLine("GET /")
    ElasticsearchBo info();
}
