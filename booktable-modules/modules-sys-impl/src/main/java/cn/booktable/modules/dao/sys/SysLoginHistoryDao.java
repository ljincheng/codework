package cn.booktable.modules.dao.sys;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import cn.booktable.modules.entity.sys.SysLoginHistoryDo;

/**
 * 登录历史.
 * @author ljc
 * @version  v1.0
 */
@Mapper
public interface SysLoginHistoryDao{

	/**
	 * 添加登录历史.
	 * @param sysLoginHistory
	 * @return
	 */
	public Integer insert(SysLoginHistoryDo sysLoginHistory);

	/**
	 * 获取登录历史数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysLoginHistoryDo> queryList(Map<String,Object> selectItem);

	/**
	 * 获取登录历史数据分页列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysLoginHistoryDo> queryListPage(Map<String,Object> selectItem);


	/**
	 * 根据Id修改登录历史.
	 * @param sysLoginHistory
	 * @return
	 */
	public Integer updateById(SysLoginHistoryDo sysLoginHistory);

	/**
	 * 根据Id删除登录历史.
	 * @param id
	 * @return
	 */
	public Integer deleteById(Long id);

	/**
	 * 根据Id获取登录历史.
	 * @param id
	 * @return
	 */
	public SysLoginHistoryDo findById(Long id);

	/**
	 * 更新登录状态
	 * @param sysLoginHistory
	 * @return
	 */
	public Integer updateStatusById(SysLoginHistoryDo sysLoginHistory);


}
