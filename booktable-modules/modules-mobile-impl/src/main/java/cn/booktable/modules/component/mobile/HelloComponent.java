package cn.booktable.modules.component.mobile;
import java.util.List;
import java.util.Map;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.mobile.HelloDo; 

/**
 * 测试-Hello
 * @author ljc
 */
public interface HelloComponent {

	/**
	 * 添加
	 * @param helloDo
	 * @return
	 */
	public Integer insertHello(HelloDo helloDo);

	/**
	 * 获取列表
	 * @param selectItem
	 * @return
	 */
	public List<HelloDo> queryHelloList(Map<String,Object> selectItem);

	/**
	 * 获取分页列表
	 * @param pageIndex 起始页
	 * @param pageSize 每页记录数
	 * @param selectItem 过滤条件
	 * @return
	 */
	public PageDo<HelloDo> queryHelloListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem);


	/**
	 * 根据id修改
	 * @param helloDo
	 * @return
	 */
	public Integer updateHelloById(HelloDo helloDo);

	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public Integer deleteHelloById(Long id);

	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public HelloDo findHelloById(Long id);

}