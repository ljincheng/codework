package cn.booktable.modules.elasticsearch.service.elasticsearch;

import cn.booktable.core.page.PageDo;

import java.util.Map;

/**
 * @author ljc
 */
public interface EsSearchService {

   <T> PageDo<T> matchQuery(Class<T> t,int pageIndex, int pageSize, String index, Map<String,Object> selected);
}
