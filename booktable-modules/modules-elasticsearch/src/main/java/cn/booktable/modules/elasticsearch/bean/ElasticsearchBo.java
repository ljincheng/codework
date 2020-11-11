package cn.booktable.modules.elasticsearch.bean;

import lombok.Data;

/**
 * @author ljc
 */
@Data
public class ElasticsearchBo {

    private String name;
    private String clusterName;
    private String clusterUuid;
    private String tagline;
    private ElasticsearchVersionBo version;
}
