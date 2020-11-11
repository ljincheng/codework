package cn.booktable.modules.elasticsearch.core;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author ljc
 */
@Data
public class EsEntity {

    /**
     * 索引的_id，不指定则使用es自动生成的
     */
    private String id;

    /**
     * 不转中间对象，直接转为json字符串,避免批量插入浪费内存资源
     */
    private String jsonData;

    /**
     * 将任意类型对象转为EsEntity
     * 不指定_id
     *
     * @param obj 一个文档（记录）
     * @param <T>
     * @return
     */
    public static <T> EsEntity objToElasticEntity(T obj) {
        return objToElasticEntity(null, obj);
    }

    /**
     * 将任意类型对象转为EsEntity
     *
     * @param id  null:不指定_id，非null：指定_id
     * @param obj 一个文档（记录）
     * @param <T>
     * @return
     */
    public static <T> EsEntity objToElasticEntity(String id, T obj) {
        EsEntity elasticEntity = new EsEntity();
        String data = JSON.toJSONString(obj);
        elasticEntity.setId(id == null ? null : String.valueOf(id));
        elasticEntity.setJsonData(data);
        return elasticEntity;
    }

}
