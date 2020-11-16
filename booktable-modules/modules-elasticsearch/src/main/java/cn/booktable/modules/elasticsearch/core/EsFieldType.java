package cn.booktable.modules.elasticsearch.core;

public enum EsFieldType {
    integer("integer"),
    keyword("keyword"),
    text("text");

    private String value;

    EsFieldType(String type)
    {
        this.value=type;
    }
    public String getValue()
    {
        return this.value;
    }
}
