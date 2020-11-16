package cn.booktable.modules.service.kids.impl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.kids.KidsMediaMetadataDo;
import cn.booktable.modules.service.kids.KidsMediaMetadataService;
import cn.booktable.modules.component.kids.KidsMediaMetadataComponent;


/**
 *
 * @author ljc
 */
@Service("kidsMediaMetadataService")
public class KidsMediaMetadataServiceImpl implements KidsMediaMetadataService {

	@Autowired
	private KidsMediaMetadataComponent kidsMediaMetadataComponent;

	@Override
	public Integer insertKidsMediaMetadata(KidsMediaMetadataDo kidsMediaMetadataDo){
		return kidsMediaMetadataComponent.insertKidsMediaMetadata(kidsMediaMetadataDo);
	}

	@Override
	public List<KidsMediaMetadataDo> queryKidsMediaMetadataList(Map<String,Object> selectItem){
		return kidsMediaMetadataComponent.queryKidsMediaMetadataList(selectItem);
	}

	@Override
	public PageDo<KidsMediaMetadataDo> queryKidsMediaMetadataListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem){
		return kidsMediaMetadataComponent.queryKidsMediaMetadataListPage(pageIndex,pageSize,selectItem);
	}

	@Override
	public Integer updateKidsMediaMetadataById(KidsMediaMetadataDo kidsMediaMetadataDo){
		return kidsMediaMetadataComponent.updateKidsMediaMetadataById(kidsMediaMetadataDo);
	}

	@Override
	public Integer deleteKidsMediaMetadataById(Long id){
		return kidsMediaMetadataComponent.deleteKidsMediaMetadataById(id);
	}

	@Override
	public KidsMediaMetadataDo findKidsMediaMetadataById(Long id){
		return kidsMediaMetadataComponent.findKidsMediaMetadataById(id);
	}
}
