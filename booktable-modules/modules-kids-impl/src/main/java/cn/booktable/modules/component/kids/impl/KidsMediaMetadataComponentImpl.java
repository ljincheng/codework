package cn.booktable.modules.component.kids.impl;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import cn.booktable.modules.entity.kids.EsKidsMediaMetadataBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.kids.KidsMediaMetadataDo;
import cn.booktable.modules.component.kids.KidsMediaMetadataComponent;
import cn.booktable.modules.dao.kids.KidsMediaMetadataDao;

/**
 *
 * @author ljc
 */
@Component("kidsMediaMetadataComponent")
public class KidsMediaMetadataComponentImpl implements KidsMediaMetadataComponent {

	@Autowired
	private KidsMediaMetadataDao kidsMediaMetadataDao;

	@Override
	public Integer insertKidsMediaMetadata(KidsMediaMetadataDo kidsMediaMetadataDo){
		if(kidsMediaMetadataDo.getCreateTime() ==null){
	 		kidsMediaMetadataDo.setCreateTime(new Date());
	 	}if(kidsMediaMetadataDo.getUpdateTime() ==null){
	 		kidsMediaMetadataDo.setUpdateTime(new Date());
	 	}
		return kidsMediaMetadataDao.insert(kidsMediaMetadataDo);
	}

	@Override
	public List<KidsMediaMetadataDo> queryKidsMediaMetadataList(Map<String,Object> selectItem){
		return kidsMediaMetadataDao.queryList(selectItem);
	}

	@Override
	public PageDo<KidsMediaMetadataDo> queryKidsMediaMetadataListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem){
		if(selectItem==null){
			selectItem=new HashMap<String,Object>();
		}
		PageDo<KidsMediaMetadataDo> pageBean=new PageDo<KidsMediaMetadataDo>(pageIndex, pageSize);
		selectItem.put("page", pageBean);
		pageBean.setPage(kidsMediaMetadataDao.queryListPage(selectItem));
	 	return pageBean;
	}

	@Override
	public Integer updateKidsMediaMetadataById(KidsMediaMetadataDo kidsMediaMetadataDo){
	if(kidsMediaMetadataDo.getUpdateTime() ==null){
	 		kidsMediaMetadataDo.setUpdateTime(new Date());
	 	}
		return kidsMediaMetadataDao.updateById(kidsMediaMetadataDo);
	}

	@Override
	public Integer deleteKidsMediaMetadataById(Long id){
		return kidsMediaMetadataDao.deleteById(id);
	}

	@Override
	public KidsMediaMetadataDo findKidsMediaMetadataById(Long id){
		return kidsMediaMetadataDao.findById(id);
	}

	@Override
	public List<EsKidsMediaMetadataBo> queryEsKidsMetaList(Map<String, Object> selectItem) {
		return kidsMediaMetadataDao.queryEsKidsMetaList(selectItem);
	}

	@Override
	public List<KidsMediaMetadataDo> matchEsKidsMetaList(List<EsKidsMediaMetadataBo> data) {
		return kidsMediaMetadataDao.matchEsKidsMetaList(data);
	}
}
