package cn.booktable.modules.elasticsearch.bean;

import lombok.Data;

@Data
public class EsSearchItemBo {
    private String id;
    private String title;
    private String desc;
    private String url;
    private String index;
    private String imageUrl;
    private String updateTime;
}
