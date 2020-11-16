package test.cn.booktable.service;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.elasticsearch.service.elasticsearch.EsSearchService;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.cn.booktable.BaseTest;
import test.cn.booktable.entity.ProductTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ljc
 */
public class EsSearchServiceTest extends BaseTest {
    @Autowired
    private EsSearchService esSearchService;

    @Test
    public void matchQuery(){
        Map<String,Object> selected=new HashMap<>();
//        selected.put("brandName","huawei");
        PageDo<ProductTest> page= esSearchService.matchQuery(ProductTest.class,1,20,"kids_media",selected);
        log.info("matchQuery Test:{}", JSON.toJSON(page));
    }
}
