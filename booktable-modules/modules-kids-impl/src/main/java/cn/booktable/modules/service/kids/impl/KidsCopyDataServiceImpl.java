package cn.booktable.modules.service.kids.impl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.kids.KidsCopyDataDo; 
import cn.booktable.modules.service.kids.KidsCopyDataService;
import cn.booktable.modules.component.kids.KidsCopyDataComponent;


/**
 * 
 * @author ljc
 */
@Service("kidsCopyDataService")
public class KidsCopyDataServiceImpl implements KidsCopyDataService {

	@Autowired 
	private KidsCopyDataComponent kidsCopyDataComponent;

	@Override
	public Integer insertKidsCopyData(KidsCopyDataDo kidsCopyDataDo){
		return kidsCopyDataComponent.insertKidsCopyData(kidsCopyDataDo);
	}

	@Override
	public List<KidsCopyDataDo> queryKidsCopyDataList(Map<String,Object> selectItem){
		return kidsCopyDataComponent.queryKidsCopyDataList(selectItem);
	}

	@Override
	public PageDo<KidsCopyDataDo> queryKidsCopyDataListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem){
		return kidsCopyDataComponent.queryKidsCopyDataListPage(pageIndex,pageSize,selectItem);
	}

	@Override
	public Integer updateKidsCopyDataById(KidsCopyDataDo kidsCopyDataDo){
		return kidsCopyDataComponent.updateKidsCopyDataById(kidsCopyDataDo);
	}

	@Override
	public Integer deleteKidsCopyDataById(Long id){
		return kidsCopyDataComponent.deleteKidsCopyDataById(id);
	}

	@Override
	public KidsCopyDataDo findKidsCopyDataById(Long id){
		return kidsCopyDataComponent.findKidsCopyDataById(id);
	}
}