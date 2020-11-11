package cn.booktable.modules.elasticsearch.service.elasticsearch;

import cn.booktable.modules.elasticsearch.core.EsEntity;
import cn.booktable.modules.elasticsearch.core.EsIndexMappings;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.List;
import java.util.Map;

/**
 * @author ljc
 */
public interface IndexDocumentService {

     boolean existIndex(String index);
     /**
      * 创建索引
      * @param index
      * @param mappings
      * @param shards
      * @param replicas
      */
     void createIndex(String index, EsIndexMappings mappings, int shards, int replicas);


     void insertOrUpdate(String index, EsEntity entity);

     IndexResponse indexSync(final String index,final Map<String, Object> document);

     /**
      * 搜索
      * @param index
      * @param builder 查询参数
      * @param c 结果对象类型
      * @param <T>
      * @return
      */
     <T> List<T> search(String index, SearchSourceBuilder builder, Class<T> c);

     /**
      * 删除索引
      * @param index
      * @return
      */
     boolean deleteIndex(String index,String id);

     void updateIndex(String index, EsEntity entity);


}
