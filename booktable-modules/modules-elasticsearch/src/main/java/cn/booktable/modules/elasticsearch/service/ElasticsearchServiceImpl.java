package cn.booktable.modules.elasticsearch.service;

import cn.booktable.modules.elasticsearch.bean.ElasticsearchBo;
import cn.booktable.modules.elasticsearch.feign.ElasticsearchClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ljc
 */
@Service("elasticsearchService")
public class ElasticsearchServiceImpl implements  ElasticsearchService{

    @Autowired
    private ElasticsearchClient elasticsearchClient;



    @Override
    public ElasticsearchBo info() {
        return elasticsearchClient.info();
    }

}
