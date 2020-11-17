package cn.booktable.service.webadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * eic-admin
 * @author ljc
 */
@SpringBootApplication
@MapperScan("cn.booktable.modules.dao")
@ComponentScan("cn.booktable")
@EnableFeignClients
@EnableAutoConfiguration
public class WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAdminApplication.class, args);
    }


}
