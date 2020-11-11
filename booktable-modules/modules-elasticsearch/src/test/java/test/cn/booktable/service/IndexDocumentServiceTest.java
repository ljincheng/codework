package test.cn.booktable.service;


import cn.booktable.modules.elasticsearch.config.ElasticsearchConfig;
import cn.booktable.modules.elasticsearch.core.EsEntity;
import cn.booktable.modules.elasticsearch.core.EsIndexMappings;
import cn.booktable.modules.elasticsearch.service.elasticsearch.IndexDocumentService;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import test.cn.booktable.BaseTest;
import test.cn.booktable.entity.ProductTest;


import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author ljc
 */
public class IndexDocumentServiceTest extends BaseTest {

    private static Logger log= LoggerFactory.getLogger(IndexDocumentServiceTest.class);
    @Autowired
    private ElasticsearchConfig elasticsearchConfig;

    @Autowired
    private IndexDocumentService indexDocumentService;

    @Test
    public void configTest(){
        try{
            log.info("elasticsearch service url={}",elasticsearchConfig.getServicePath());
        }catch (Exception e)
        {
            log.error("测试获取配置项内容异常",e);
        }
    }


    @Test
    public void createIndexTest(){
        indexDocumentService.createIndex("product", EsIndexMappings.byType(false, ProductTest.class), 1, 1);
    }

    @Test
    public void search(){
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.matchAllQuery());
      List<ProductTest> data= indexDocumentService.search("product",builder,ProductTest.class);
      log.info("search data="+ JSON.toJSONString(data));
    }

    @Test
    public void delete(){
       boolean result= indexDocumentService.deleteIndex("product","100003999895");
        log.info("delete data="+ result);
    }

    @Test
    public void insert(){
        ProductTest product=new ProductTest();
        product.setBrandName("Huawei Matebook pro 2020");
        product.setSku("20201111-1740002");
        product.setCategory("办工用品");
        product.setWeight("20kg");
        product.setId(product.getSku());
        product.setSaleUnit("205");
        indexDocumentService.insertOrUpdate("product", EsEntity.objToElasticEntity(product.getId(),product));
    }

    @Test
    public void update(){
        ProductTest product=new ProductTest();
        product.setBrandName("Macbook book pro 2020");
        product.setSku("20201111-1420001");
        product.setCategory("办工用品 电脑2");
        product.setWeight("209kg");
        product.setId(product.getSku());
        product.setSaleUnit("205");
        indexDocumentService.updateIndex("product", EsEntity.objToElasticEntity(product.getId(),product));
    }

    @Test
    public void indexSyncTest() {

        Map<String,Object> mapObj=new HashMap<>();
        mapObj.put("timestamp", Instant.now());
        mapObj.put("uuid", UUID.randomUUID().toString());
        IndexResponse response = indexDocumentService.indexSync(
                "my-index-000001",
                mapObj
        );

        log.info("Index: {}", response.getIndex());
        log.info("Id: {}", response.getId());

        final DocWriteResponse.Result result = response.getResult();
        if (result == DocWriteResponse.Result.CREATED) {
            log.info("The document was created.");
        } else if (result == DocWriteResponse.Result.UPDATED) {
            log.info("The document was updated.");
        }
    }
}