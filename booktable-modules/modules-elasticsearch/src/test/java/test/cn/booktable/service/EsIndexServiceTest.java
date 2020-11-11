package test.cn.booktable.service;

import cn.booktable.modules.elasticsearch.service.elasticsearch.EsIndexService;
import cn.booktable.util.AssertUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.cn.booktable.BaseTest;

/**
 * @author ljc
 */
public class EsIndexServiceTest extends BaseTest {

    @Autowired
    private EsIndexService esIndexService;

    @Test
    public void exits(){
        boolean result= esIndexService.existIndex("product");
        log.info("exits test:value={}",result);
        AssertUtils.isTrue(result,"验证不通过");
    }
}
