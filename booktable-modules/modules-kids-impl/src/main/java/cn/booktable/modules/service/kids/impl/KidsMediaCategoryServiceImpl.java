package cn.booktable.modules.service.kids.impl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.kids.KidsMediaCategoryDo; 
import cn.booktable.modules.service.kids.KidsMediaCategoryService;
import cn.booktable.modules.component.kids.KidsMediaCategoryComponent;


/**
 * 
 * @author ljc
 */
@Service("kidsMediaCategoryService")
public class KidsMediaCategoryServiceImpl implements KidsMediaCategoryService {

	@Autowired 
	private KidsMediaCategoryComponent kidsMediaCategoryComponent;

	@Override
	public Integer insertKidsMediaCategory(KidsMediaCategoryDo kidsMediaCategoryDo){
		return kidsMediaCategoryComponent.insertKidsMediaCategory(kidsMediaCategoryDo);
	}

	@Override
	public List<KidsMediaCategoryDo> queryKidsMediaCategoryList(Map<String,Object> selectItem){
		return kidsMediaCategoryComponent.queryKidsMediaCategoryList(selectItem);
	}

	@Override
	public PageDo<KidsMediaCategoryDo> queryKidsMediaCategoryListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem){
		return kidsMediaCategoryComponent.queryKidsMediaCategoryListPage(pageIndex,pageSize,selectItem);
	}

	@Override
	public Integer updateKidsMediaCategoryById(KidsMediaCategoryDo kidsMediaCategoryDo){
		return kidsMediaCategoryComponent.updateKidsMediaCategoryById(kidsMediaCategoryDo);
	}

	@Override
	public Integer deleteKidsMediaCategoryById(Long id){
		return kidsMediaCategoryComponent.deleteKidsMediaCategoryById(id);
	}

	@Override
	public KidsMediaCategoryDo findKidsMediaCategoryById(Long id){
		return kidsMediaCategoryComponent.findKidsMediaCategoryById(id);
	}
}