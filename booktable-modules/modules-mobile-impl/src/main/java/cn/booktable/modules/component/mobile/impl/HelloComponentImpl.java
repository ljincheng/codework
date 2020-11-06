package cn.booktable.modules.component.mobile.impl;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.mobile.HelloDo; 
import cn.booktable.modules.component.mobile.HelloComponent;
import cn.booktable.modules.dao.mobile.HelloDao;

/**
 * 测试-Hello
 * @author ljc
 */
@Component("helloComponent")
public class HelloComponentImpl implements HelloComponent {

	@Autowired 
	private HelloDao helloDao;

	@Override
	public Integer insertHello(HelloDo helloDo){
		if(helloDo.getCreateTime() ==null){
	 		helloDo.setCreateTime(new Date());
	 	}if(helloDo.getUpdateTime() ==null){
	 		helloDo.setUpdateTime(new Date());
	 	}
		return helloDao.insert(helloDo);
	}

	@Override
	public List<HelloDo> queryHelloList(Map<String,Object> selectItem){
		return helloDao.queryList(selectItem);
	}

	@Override
	public PageDo<HelloDo> queryHelloListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem){
		if(selectItem==null){
			selectItem=new HashMap<String,Object>();
		}
		PageDo<HelloDo> pageBean=new PageDo<HelloDo>(pageIndex, pageSize);
		selectItem.put("page", pageBean);
		pageBean.setPage(helloDao.queryListPage(selectItem));
	 	return pageBean;
	}


	@Override
	public Integer updateHelloById(HelloDo helloDo){
	if(helloDo.getUpdateTime() ==null){
	 		helloDo.setUpdateTime(new Date());
	 	}
		return helloDao.updateById(helloDo);
	}

	@Override
	public Integer deleteHelloById(Long id){
		return helloDao.deleteById(id);
	}

	@Override
	public HelloDo findHelloById(Long id){
		return helloDao.findById(id);
	}

}