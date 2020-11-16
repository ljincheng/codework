package cn.booktable.modules.elasticsearch.service.elasticsearch;

import cn.booktable.modules.elasticsearch.core.EsEntity;
import cn.booktable.modules.elasticsearch.core.EsIndexMappings;

import java.util.List;

/**
 * 索引服务
 * @author ljc
 */
public interface EsIndexService {

    /**
     * 判断是否存在索引
     * @param index
     * @return
     */
    boolean exist(String index);

    /**
     * 创建索引
     * @param index
     * @param mappings
     * @param shards
     * @param replicas
     * @return
     */
    boolean create(String index, EsIndexMappings mappings, int shards, int replicas);

    boolean insert(String index,EsEntity entity);

    boolean insertOrUpdate(String index, EsEntity entity);

    boolean delete(String index);

    List<String> indexs();
}
