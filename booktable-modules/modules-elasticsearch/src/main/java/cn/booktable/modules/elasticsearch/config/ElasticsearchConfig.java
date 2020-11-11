package cn.booktable.modules.elasticsearch.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ljc
 */
// @Configuration
@ConfigurationProperties(prefix = "elasticsearch")
@Data
public class ElasticsearchConfig {

    private String servicePath;

}
