package cn.booktable.modules.service.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.SysNotificationDo;
import cn.booktable.core.page.PageDo;

/**
 * 系统通知.
 * @author ljc
 * @version  v1.0
 */
public interface SysNotificationService {

	/**
	 * 添加系统通知.
	 * @param sysNotification
	 * @return
	 */
	public Integer insertSysNotification(SysNotificationDo sysNotification);

	/**
	 * 获取系统通知数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysNotificationDo> querySysNotificationList(Map<String,Object> selectItem);

	/**
	 * 获取系统通知数据集
	 * @param pageIndex
	 * 起始页
	 * @param pageSize
	 * 每页记录数
	 * @param selectItem
	 * 过滤条件
	 * @return
	 */
	public PageDo<SysNotificationDo> querySysNotificationListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem);

	/**
	 * 根据Id修改系统通知.
	 * @param sysNotification
	 * @return
	 */
	public Integer updateSysNotificationById(SysNotificationDo sysNotification);

	/**
	 * 根据Id删除系统通知.
	 * @param id
	 * @return
	 */
	public Integer deleteSysNotificationById(String id);

	/**
	 * 根据Id获取系统通知.
	 * @param id
	 * @return
	 */
	public SysNotificationDo findSysNotificationById(String id);

	/**
	 *  查询邮件通知列表
	 * @param status 状态
	 * @return
	 */
	public List<SysNotificationDo> queryToBeMailNotificationList(Integer status);
}
