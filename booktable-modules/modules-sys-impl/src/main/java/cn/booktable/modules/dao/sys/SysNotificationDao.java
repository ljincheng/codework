package cn.booktable.modules.dao.sys;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import cn.booktable.modules.entity.sys.SysNotificationDo;

/**
 * 系统通知.
 * @author ljc
 * @version  v1.0
 */
@Mapper
public interface SysNotificationDao{

	/**
	 * 添加系统通知.
	 * @param sysNotification
	 * @return
	 */
	public Integer insert(SysNotificationDo sysNotification);

	/**
	 * 获取系统通知数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysNotificationDo> queryList(Map<String,Object> selectItem);

	/**
	 * 获取系统通知数据分页列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysNotificationDo> queryListPage(Map<String,Object> selectItem);


	/**
	 * 根据Id修改系统通知.
	 * @param sysNotification
	 * @return
	 */
	public Integer updateById(SysNotificationDo sysNotification);

	/**
	 * 根据Id删除系统通知.
	 * @param id
	 * @return
	 */
	public Integer deleteById(String id);

	/**
	 * 根据Id获取系统通知.
	 * @param id
	 * @return
	 */
	public SysNotificationDo findById(String id);


}
