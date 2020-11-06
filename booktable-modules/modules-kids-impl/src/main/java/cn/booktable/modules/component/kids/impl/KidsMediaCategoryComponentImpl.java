package cn.booktable.modules.component.kids.impl;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.kids.KidsMediaCategoryDo; 
import cn.booktable.modules.component.kids.KidsMediaCategoryComponent;
import cn.booktable.modules.dao.kids.KidsMediaCategoryDao;

/**
 * 
 * @author ljc
 */
@Component("kidsMediaCategoryComponent")
public class KidsMediaCategoryComponentImpl implements KidsMediaCategoryComponent {

	@Autowired 
	private KidsMediaCategoryDao kidsMediaCategoryDao;

	@Override
	public Integer insertKidsMediaCategory(KidsMediaCategoryDo kidsMediaCategoryDo){
		if(kidsMediaCategoryDo.getCreateTime() ==null){
	 		kidsMediaCategoryDo.setCreateTime(new Date());
	 	}if(kidsMediaCategoryDo.getUpdateTime() ==null){
	 		kidsMediaCategoryDo.setUpdateTime(new Date());
	 	}
		return kidsMediaCategoryDao.insert(kidsMediaCategoryDo);
	}

	@Override
	public List<KidsMediaCategoryDo> queryKidsMediaCategoryList(Map<String,Object> selectItem){
		return kidsMediaCategoryDao.queryList(selectItem);
	}

	@Override
	public PageDo<KidsMediaCategoryDo> queryKidsMediaCategoryListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem){
		if(selectItem==null){
			selectItem=new HashMap<String,Object>();
		}
		PageDo<KidsMediaCategoryDo> pageBean=new PageDo<KidsMediaCategoryDo>(pageIndex, pageSize);
		selectItem.put("page", pageBean);
		pageBean.setPage(kidsMediaCategoryDao.queryListPage(selectItem));
	 	return pageBean;
	}

	@Override
	public Integer updateKidsMediaCategoryById(KidsMediaCategoryDo kidsMediaCategoryDo){
	if(kidsMediaCategoryDo.getUpdateTime() ==null){
	 		kidsMediaCategoryDo.setUpdateTime(new Date());
	 	}
		return kidsMediaCategoryDao.updateById(kidsMediaCategoryDo);
	}

	@Override
	public Integer deleteKidsMediaCategoryById(Long id){
		return kidsMediaCategoryDao.deleteById(id);
	}

	@Override
	public KidsMediaCategoryDo findKidsMediaCategoryById(Long id){
		return kidsMediaCategoryDao.findById(id);
	}
}