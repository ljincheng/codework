package cn.booktable.modules.elasticsearch.config;

import cn.booktable.modules.elasticsearch.factory.FeignClientFactory;
import cn.booktable.modules.elasticsearch.feign.ElasticsearchClient;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author ljc
 */
@Configuration
@EnableConfigurationProperties(ElasticsearchConfig.class)
public class ElasticsearchAutoConfiguration {

    @Resource
    private ElasticsearchConfig elasticsearchConfig;

//    @Bean
//    @ConditionalOnMissingBean(ElasticsearchConfig.class)
//    public ElasticsearchConfig getElasticsearchConfig(){
//        return elasticsearchConfig;
//    }

    @Bean
    @ConditionalOnMissingBean(FeignClientFactory.class)
    public FeignClientFactory feignClientFactory(){
        return new FeignClientFactory();
    }

    @Bean
    public ElasticsearchClient elasticsearchClient(FeignClientFactory feignClientFactory){
       return feignClientFactory.target(ElasticsearchClient.class,elasticsearchConfig.getServicePath());
    }



    @Bean(destroyMethod = "close")
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200)));
        return restHighLevelClient;
    }

}
