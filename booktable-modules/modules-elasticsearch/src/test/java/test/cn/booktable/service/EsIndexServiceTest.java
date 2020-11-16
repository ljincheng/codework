package test.cn.booktable.service;

import cn.booktable.modules.elasticsearch.bean.ProductBo;
import cn.booktable.modules.elasticsearch.core.EsEntity;
import cn.booktable.modules.elasticsearch.core.EsIndexMappings;
import cn.booktable.modules.elasticsearch.indexs.KidsMedia;
import cn.booktable.modules.elasticsearch.service.elasticsearch.EsIndexService;
import cn.booktable.util.AssertUtils;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.cn.booktable.BaseTest;

import java.util.List;

/**
 * @author ljc
 */
public class EsIndexServiceTest extends BaseTest {


    @Autowired
    private EsIndexService esIndexService;


    @Test
    public void exits(){
        boolean result= esIndexService.exist("kidsMedia");
        log.info("exits test:value={}",result);
        AssertUtils.isTrue(result,"验证不通过");
    }

    @Test
    public void create(){
        esIndexService.create("kids_media", EsIndexMappings.byType(false, KidsMedia.class), 1, 1);
    }

    @Test
    public void insert(){


        KidsMedia kidsMedia=new KidsMedia();
        kidsMedia.setId(2020111600002L);
//        kidsMedia.setName("Preschool Reading Lessons- Letter Blending | Sight Words | ABC Phonics | LOTTY LEARNS");
        kidsMedia.setTitle("THE LAZY GIRL STORY | KIDS STORIES - ANIMATED STORIES FOR KIDS | TIA AND TOFU STORYTELLING");
        kidsMedia.setCategory("英文");
        esIndexService.insert("kidsMedia",EsEntity.objToElasticEntity(String.valueOf(kidsMedia.getId()),kidsMedia));

//        ProductBo product=new ProductBo();
//        product.setBrandName("apple");
//        product.setName("MacOS Big Sur review");
//        product.setId("2020111600001");
//        product.setImagePath("https://i.ytimg.com/vi/orKd7GVtAB0/hq720.jpg?sqp=-oaymwEZCOgCEMoBSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLCH8_zuN4M57iz7UAShRVAw1BGppA");
//        product.setCategory("软体");
//        product.setWeight("20kg");
//        product.setId(product.getSku());
//        product.setSaleUnit("205");
//        esIndexService.insertOrUpdate("product", EsEntity.objToElasticEntity(product.getId(),product));
    }

    @Test
    public void delete(){
        esIndexService.delete("kids_media");
    }


    @Test
    public void indexList(){
        List<String> indexs=esIndexService.indexs();
        log.info("indexs={}"+JSON.toJSONString(indexs));
    }
}
