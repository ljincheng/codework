package cn.booktable.service.webadmin;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * eic-admin
 * @author ljc
 */
@SpringBootApplication //(exclude= {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
//@SpringBootApplication(scanBasePackages="com.eic",exclude= {DataSourceAutoConfiguration.class})
//@MapperScan("com.eic.jcptsystem.dao")
@MapperScan("cn.booktable.modules.dao")
@ComponentScan("cn.booktable")
public class WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAdminApplication.class, args);
    }


}

//public class EicAdminApplication extends SpringBootServletInitializer {
//
//    public static void main(String[] args) {
//        SpringApplication.run(EicAdminApplication.class, args);
//    }
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(EicAdminApplication.class);
//    }
//}