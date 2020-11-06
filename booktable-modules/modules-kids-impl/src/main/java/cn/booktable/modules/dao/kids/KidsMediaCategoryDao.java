package cn.booktable.modules.dao.kids;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.kids.KidsMediaCategoryDo;

/**
 * 
 * @author ljc
 */
@Repository("kidsMediaCategoryDao")
public interface KidsMediaCategoryDao {

	/**
	 * @param kidsMediaCategoryDo
	 * @return
	 */
	public Integer insert(KidsMediaCategoryDo kidsMediaCategoryDo);
	
	/**
	 * 获取列表
	 * @param selectItem
	 * @return
	 */
	public List<KidsMediaCategoryDo> queryList(Map<String,Object> selectItem);
	
	/**
	 * 获取分页列表
	 * @param selectItem
	 * @return
	 */
	public List<KidsMediaCategoryDo> queryListPage(Map<String,Object> selectItem);
	
		/**
	 * 根据id修改
	 * @param kidsMediaCategoryDo
	 * @return
	 */
	public Integer updateById(KidsMediaCategoryDo kidsMediaCategoryDo);
	
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
	public KidsMediaCategoryDo findById(Long id);
}