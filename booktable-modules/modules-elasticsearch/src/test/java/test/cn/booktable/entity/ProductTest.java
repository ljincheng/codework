package test.cn.booktable.entity;

import cn.booktable.modules.elasticsearch.core.EsField;
import lombok.Data;

/**
 * @author ljc
 */
@Data
public class ProductTest {
    /**
     * 商品id
     */
    @EsField(type = "text",index = true)
    private String id;
    /**
     * 品牌id
     */
    @EsField(type = "text")
    private Integer brandId;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 日期
     */
    private String date;
    private String saleUnit;
    private String weight;
    private String wserve;
    private String wareQD;
    private String  productArea;
    private String imagePath;
    private String sku;
    private String upc;
    private String category;
    private String isJDLogistics;
    private String paramJson;
    private String name;
    private String seoModel;
}
