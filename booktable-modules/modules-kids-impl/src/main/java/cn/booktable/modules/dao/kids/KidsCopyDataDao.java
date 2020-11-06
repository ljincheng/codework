package cn.booktable.modules.dao.kids;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.kids.KidsCopyDataDo;

/**
 * 
 * @author ljc
 */
@Repository("kidsCopyDataDao")
public interface KidsCopyDataDao {

	/**
	 * @param kidsCopyDataDo
	 * @return
	 */
	public Integer insert(KidsCopyDataDo kidsCopyDataDo);
	
	/**
	 * 获取列表
	 * @param selectItem
	 * @return
	 */
	public List<KidsCopyDataDo> queryList(Map<String,Object> selectItem);
	
	/**
	 * 获取分页列表
	 * @param selectItem
	 * @return
	 */
	public List<KidsCopyDataDo> queryListPage(Map<String,Object> selectItem);
	
		/**
	 * 根据id修改
	 * @param kidsCopyDataDo
	 * @return
	 */
	public Integer updateById(KidsCopyDataDo kidsCopyDataDo);
	
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
	public KidsCopyDataDo findById(Long id);

	public Integer insertTableData(KidsCopyDataDo copyData);
}