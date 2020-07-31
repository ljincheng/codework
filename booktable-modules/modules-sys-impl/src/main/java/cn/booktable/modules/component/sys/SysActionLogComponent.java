package cn.booktable.modules.component.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.sys.SysActionLogDo;

/**
 * 用户活动日志.
 * @author ljc
 * @version  v1.0
 */
public interface SysActionLogComponent {

	/**
	 * 添加用户活动日志.
	 * @param sysActionLog
	 * @return
	 */
	public Integer insertSysActionLog(SysActionLogDo sysActionLog);

	/**
	 * 获取用户活动日志数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysActionLogDo> querySysActionLogList(Map<String, Object> selectItem);

	/**
	 * 获取用户活动日志数据集
	 * @param pageIndex
	 * 起始页
	 * @param pageSize
	 * 每页记录数
	 * @param selectItem
	 * 过滤条件
	 * @return
	 */
	public PageDo<SysActionLogDo> querySysActionLogListPage(Long pageIndex, Integer pageSize, Map<String, Object> selectItem);

	/**
	 * 根据Id修改用户活动日志.
	 * @param sysActionLog
	 * @return
	 */
	public Integer updateSysActionLogById(SysActionLogDo sysActionLog);

	/**
	 * 根据Id删除用户活动日志.
	 * @param id
	 * @return
	 */
	public Integer deleteSysActionLogById(Long id);

	/**
	 * 根据Id获取用户活动日志.
	 * @param id
	 * @return
	 */
	public SysActionLogDo findSysActionLogById(Long id);
}
