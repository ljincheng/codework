package cn.booktable.modules.dao.mobile;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.mobile.HelloDo;

/**
 * 测试-Hello
 * @author ljc
 */
@Repository("helloDao")
public interface HelloDao {

	/**
	 * @param helloDo
	 * @return
	 */
	public Integer insert(HelloDo helloDo);
	
	/**
	 * 获取列表
	 * @param selectItem
	 * @return
	 */
	public List<HelloDo> queryList(Map<String,Object> selectItem);
	
	/**
	 * 获取分页列表
	 * @param selectItem
	 * @return
	 */
	public List<HelloDo> queryListPage(Map<String,Object> selectItem);
	
	
	/**
	 * 根据id修改
	 * @param helloDo
	 * @return
	 */
	public Integer updateById(HelloDo helloDo);
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public Integer deleteById(Long id);
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public HelloDo findById(Long id);



}