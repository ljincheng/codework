package cn.booktable.modules.service.kids;
import java.util.List;
import java.util.Map;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.kids.KidsMediaCategoryDo; 

/**
 * 
 * @author ljc
 */
public interface KidsMediaCategoryService {

	/**
	 * 添加
	 * @param kidsMediaCategoryDo
	 * @return
	 */
	public Integer insertKidsMediaCategory(KidsMediaCategoryDo kidsMediaCategoryDo);

	/**
	 * 获取列表
	 * @param selectItem
	 * @return
	 */
	public List<KidsMediaCategoryDo> queryKidsMediaCategoryList(Map<String,Object> selectItem);

	/**
	 * 获取分页列表
	 * @param pageIndex 起始页
	 * @param pageSize 每页记录数
	 * @param selectItem 过滤条件
	 * @return
	 */
	public PageDo<KidsMediaCategoryDo> queryKidsMediaCategoryListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem);

	/**
	 * 根据id修改
	 * @param kidsMediaCategoryDo
	 * @return
	 */
	public Integer updateKidsMediaCategoryById(KidsMediaCategoryDo kidsMediaCategoryDo);

	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public Integer deleteKidsMediaCategoryById(Long id);

	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public KidsMediaCategoryDo findKidsMediaCategoryById(Long id);
}