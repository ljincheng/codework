package cn.booktable.modules.elasticsearch.bean;

import lombok.Data;

/**
 * @author ljc
 */
@Data
public class ElasticsearchVersionBo {
    private String number;
    private String buildFlavor;
    private String buildType;
    private String buildHash;
    private String buildDate;
    private Boolean buildSnapshot;
    private String luceneVersion;
    private String minimumWireCompatibilityVersion;
    private String minimumIndexCompatibilityVersion;

}
