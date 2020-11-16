package cn.booktable.modules.service.kids.impl;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.component.kids.KidsMediaMetadataComponent;
import cn.booktable.modules.elasticsearch.core.EsEntity;
import cn.booktable.modules.elasticsearch.core.EsIndexMappings;
import cn.booktable.modules.elasticsearch.indexs.KidsMedia;
import cn.booktable.modules.elasticsearch.service.elasticsearch.EsIndexService;
import cn.booktable.modules.elasticsearch.service.elasticsearch.EsSearchService;
import cn.booktable.modules.entity.kids.EsKidsMediaMetadataBo;
import cn.booktable.modules.entity.kids.KidsMediaMetadataDo;
import cn.booktable.modules.service.kids.KidsElasticsearchService;
import cn.booktable.modules.service.kids.KidsMediaMetadataService;
import cn.booktable.util.StringUtils;
import cn.hutool.db.Page;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("kidsElasticsearchService")
public class KidsElasticsearchServiceImpl implements KidsElasticsearchService {
    private static Logger logger= LoggerFactory.getLogger(KidsElasticsearchServiceImpl.class);

    @Autowired
    private KidsMediaMetadataService kidsMediaMetadataService;

    @Autowired
    private EsIndexService esIndexService;
    @Autowired
    private EsSearchService esSearchService;
    @Autowired
    private KidsMediaMetadataComponent kidsMediaMetadataComponent;

    @Override
    public List<EsKidsMediaMetadataBo> queryEsKidsMetaList(Map<String, Object> selectItem) {
        return kidsMediaMetadataComponent.queryEsKidsMetaList(selectItem);
    }

    @Override
    public void createIndex() {
        esIndexService.create("kids_media", EsIndexMappings.byType(false, KidsMedia.class), 1, 1);
    }

    @Override
    public long indexInit() {

        long result=0;
        List<EsKidsMediaMetadataBo> list= queryEsKidsMetaList(null);
        if(list!=null ){
            for(int i=0,k=list.size();i<k;i++){
                EsKidsMediaMetadataBo media= list.get(i);
                esIndexService.delete(String.valueOf(media.getId()));
                esIndexService.insert("kids_media", EsEntity.objToElasticEntity(media.getId().toString(),media));
                result++;
            }
        }
        return result;
    }

    @Override
    public PageDo<KidsMediaMetadataDo> query(String key, int pageIndex, int pageSize) {
        PageDo<KidsMediaMetadataDo> result=new PageDo<>(Long.valueOf(pageIndex),pageSize);
        Map<String,Object> selected=new HashMap<>();
        if(StringUtils.isNotBlank(key)) {
            selected.put("title", key);
        }
        PageDo<EsKidsMediaMetadataBo> page= esSearchService.matchQuery(EsKidsMediaMetadataBo.class,pageIndex,pageSize,"kids_media",selected);
        if(page!=null && page.getPage()!=null && page.getPage().size()>0){
            List<KidsMediaMetadataDo> data= kidsMediaMetadataComponent.matchEsKidsMetaList(page.getPage());
            result.setPage(data);

        }
        result.setTotalNum(page.getTotalNum());
        result.setTotalPage(page.getTotalPage());
        logger.info("matchQuery Test:{}", JSON.toJSON(page));
        return result;
    }
}
