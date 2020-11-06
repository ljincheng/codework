package cn.booktable.modules.service.mobile.impl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.mobile.HelloDo; 
import cn.booktable.modules.service.mobile.HelloService;
import cn.booktable.modules.component.mobile.HelloComponent;


/**
 * 测试-Hello
 * @author ljc
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {

	@Autowired 
	private HelloComponent helloComponent;

	@Override
	public Integer insertHello(HelloDo helloDo){
		return helloComponent.insertHello(helloDo);
	}

	@Override
	public List<HelloDo> queryHelloList(Map<String,Object> selectItem){
		return helloComponent.queryHelloList(selectItem);
	}

	@Override
	public PageDo<HelloDo> queryHelloListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem){
		return helloComponent.queryHelloListPage(pageIndex,pageSize,selectItem);
	}


	@Override
	public Integer updateHelloById(HelloDo helloDo){
		return helloComponent.updateHelloById(helloDo);
	}

	@Override
	public Integer deleteHelloById(Long id){
		return helloComponent.deleteHelloById(id);
	}

	@Override
	public HelloDo findHelloById(Long id){
		return helloComponent.findHelloById(id);
	}

}