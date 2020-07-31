package cn.booktable.modules.component.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.SysLoginHistoryDo;
import cn.booktable.core.page.PageDo;

/**
 * 登录历史.
 * @author ljc
 * @version  v1.0
 */
public interface SysLoginHistoryComponent {

	/**
	 * 添加登录历史.
	 * @param sysLoginHistory
	 * @return
	 */
	public Integer insertSysLoginHistory(SysLoginHistoryDo sysLoginHistory);

	/**
	 * 获取登录历史数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysLoginHistoryDo> querySysLoginHistoryList(Map<String,Object> selectItem);

	/**
	 * 获取登录历史数据集
	 * @param pageIndex
	 * 起始页
	 * @param pageSize
	 * 每页记录数
	 * @param selectItem
	 * 过滤条件
	 * @return
	 */
	public PageDo<SysLoginHistoryDo> querySysLoginHistoryListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem);

	/**
	 * 根据Id修改登录历史.
	 * @param sysLoginHistory
	 * @return
	 */
	public Integer updateSysLoginHistoryById(SysLoginHistoryDo sysLoginHistory);

	/**
	 * 根据Id删除登录历史.
	 * @param id
	 * @return
	 */
	public Integer deleteSysLoginHistoryById(Long id);

	/**
	 * 根据Id获取登录历史.
	 * @param id
	 * @return
	 */
	public SysLoginHistoryDo findSysLoginHistoryById(Long id);

	/**
	 * 更新登录状态
	 * @param sysLoginHistory
	 * @return
	 */
	public Integer updateStatusById(SysLoginHistoryDo sysLoginHistory);
}
