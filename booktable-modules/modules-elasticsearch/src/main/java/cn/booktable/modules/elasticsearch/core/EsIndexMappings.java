package cn.booktable.modules.elasticsearch.core;

import cn.booktable.util.StringUtils;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于代码创建索引
 * @author ljc
 */
@Data
public class EsIndexMappings {
    private boolean dynamic = false;
    private Map<String, Map<String, Object>> properties;

    /**
     * 生成索引字段映射信息
     * @param dynamic
     * @param type
     * @return
     */
    public static EsIndexMappings byType(boolean dynamic, Class<?> type) {
        EsIndexMappings esIndexMappings = new EsIndexMappings();
        esIndexMappings.setDynamic(dynamic);
        esIndexMappings.setProperties(new HashMap<>());
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            Map<String, Object> value = new HashMap<>();
            EsField esField = field.getAnnotation(EsField.class);
            if (esField != null) {

                if(esField.type()!=null){
                    value.put("type", esField.type().getValue());
                    value.put("index", esField.index());
                    esIndexMappings.getProperties().put(field.getName(), value);
                }
            }

        }
        return esIndexMappings;
    }

}
