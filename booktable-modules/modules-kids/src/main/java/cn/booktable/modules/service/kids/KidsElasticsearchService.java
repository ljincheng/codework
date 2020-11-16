package cn.booktable.modules.service.kids;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.kids.EsKidsMediaMetadataBo;
import cn.booktable.modules.entity.kids.KidsMediaMetadataDo;

import java.util.List;
import java.util.Map;

public interface KidsElasticsearchService {

    public List<EsKidsMediaMetadataBo> queryEsKidsMetaList(Map<String,Object> selectItem);

    long indexInit();

    void createIndex();

    PageDo<KidsMediaMetadataDo> query(String key,int pageIndex,int pageSize);
}
