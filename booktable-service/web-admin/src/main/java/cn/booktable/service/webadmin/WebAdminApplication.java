package cn.booktable.service.webadmin;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * eic-admin
 * @author ljc
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
//@SpringBootApplication(scanBasePackages="com.eic",exclude= {DataSourceAutoConfiguration.class})
//@MapperScan("com.eic.jcptsystem.dao")
//@ComponentScan("com.eic.jcptsystem")
//@ComponentScan("org.codework")
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