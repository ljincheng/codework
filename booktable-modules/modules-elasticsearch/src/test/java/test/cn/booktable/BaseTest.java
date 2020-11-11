package test.cn.booktable;

/**
 * @author ljc
 */

import cn.booktable.modules.elasticsearch.config.ElasticsearchAutoConfiguration;
import cn.booktable.modules.elasticsearch.config.ElasticsearchConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import test.cn.booktable.service.IndexDocumentServiceTest;

/**
 * @author ljc
 */
//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@ComponentScan("cn.booktable")
@ContextConfiguration(classes = ElasticsearchAutoConfiguration.class)
@EnableConfigurationProperties(value = ElasticsearchConfig.class)
@TestPropertySource("classpath:config-test.properties")
public class BaseTest {

    protected static Logger log= LoggerFactory.getLogger(IndexDocumentServiceTest.class);

}
