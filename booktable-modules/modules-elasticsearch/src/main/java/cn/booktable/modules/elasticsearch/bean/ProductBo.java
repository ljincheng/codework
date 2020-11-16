package cn.booktable.modules.elasticsearch.bean;

import cn.booktable.modules.elasticsearch.core.EsField;
import cn.booktable.modules.elasticsearch.core.EsFieldType;
import lombok.Data;

@Data
public class ProductBo {

    /**
     * 商品id
     */
    @EsField(type = EsFieldType.integer,index = true)
    private String id;

    /**
     * 品牌名称
     */
    @EsField(type =EsFieldType.keyword,index = true)
    private String brandName;

    @EsField(type =EsFieldType.text,index = true)
    private String name;

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

    private String seoModel;
}
