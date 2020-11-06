package cn.booktable.modules.service.kids;
import java.util.List;
import java.util.Map;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.kids.KidsCopyDataDo; 

/**
 * 
 * @author ljc
 */
public interface KidsCopyDataService {

	/**
	 * 添加
	 * @param kidsCopyDataDo
	 * @return
	 */
	public Integer insertKidsCopyData(KidsCopyDataDo kidsCopyDataDo);

	/**
	 * 获取列表
	 * @param selectItem
	 * @return
	 */
	public List<KidsCopyDataDo> queryKidsCopyDataList(Map<String,Object> selectItem);

	/**
	 * 获取分页列表
	 * @param pageIndex 起始页
	 * @param pageSize 每页记录数
	 * @param selectItem 过滤条件
	 * @return
	 */
	public PageDo<KidsCopyDataDo> queryKidsCopyDataListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem);

	/**
	 * 根据id修改
	 * @param kidsCopyDataDo
	 * @return
	 */
	public Integer updateKidsCopyDataById(KidsCopyDataDo kidsCopyDataDo);

	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public Integer deleteKidsCopyDataById(Long id);

	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public KidsCopyDataDo findKidsCopyDataById(Long id);
}