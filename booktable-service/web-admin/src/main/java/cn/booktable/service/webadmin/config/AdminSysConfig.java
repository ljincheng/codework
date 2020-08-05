package cn.booktable.service.webadmin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ljc
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "booktable.sys")
@Data
public class AdminSysConfig {

    /**
     * 密码KEY
     *
     */
    private String passwordKey;
}
