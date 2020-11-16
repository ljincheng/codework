package cn.booktable.modules.elasticsearch.indexs;

import cn.booktable.modules.elasticsearch.core.EsField;
import cn.booktable.modules.elasticsearch.core.EsFieldType;
import lombok.Data;

@Data
public class KidsMedia {

    @EsField(type = EsFieldType.integer,index = true)
    private Long id;
    @EsField(type = EsFieldType.text,index = true)
    private String title;
    @EsField(type = EsFieldType.keyword,index = false)
    private String category;

}
