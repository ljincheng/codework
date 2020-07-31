package cn.booktable.modules.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.booktable.modules.component.sys.SysNotificationComponent;
import cn.booktable.modules.entity.sys.SysNotificationDo;
import cn.booktable.modules.service.sys.SysNotificationService;
import cn.booktable.core.page.PageDo;

/**
 * 系统通知.
 * @author ljc
 * @version  v1.0
 */
@Service("sysNotificationService")
public class SysNotificationServiceImpl  implements SysNotificationService{

	private SysNotificationComponent sysNotificationComponent;

	@Autowired
	public void setSysNotificationComponent(SysNotificationComponent sysNotificationComponent)
	{
		this.sysNotificationComponent=sysNotificationComponent;
	}


	@Override
	public Integer insertSysNotification(SysNotificationDo sysNotification)
	{
		return sysNotificationComponent.insertSysNotification(sysNotification);
	}

	@Override
	public List<SysNotificationDo> querySysNotificationList(Map<String,Object> selectItem)
	{
		return sysNotificationComponent.querySysNotificationList(selectItem);
	}

	@Override
	public PageDo<SysNotificationDo> querySysNotificationListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem)
	{
		 return sysNotificationComponent.querySysNotificationListPage(pageIndex,pageSize,selectItem);
	}

	@Override
	public Integer updateSysNotificationById(SysNotificationDo sysNotification)
	{
		return sysNotificationComponent.updateSysNotificationById(sysNotification);
	}

	@Override
	public Integer deleteSysNotificationById(String id)
	{
		return sysNotificationComponent.deleteSysNotificationById(id);
	}

	@Override
	public SysNotificationDo findSysNotificationById(String id)
	{
		return sysNotificationComponent.findSysNotificationById(id);
	}

	public List<SysNotificationDo> queryToBeMailNotificationList(Integer status)
	{
		Map<String, Object> selectItem=new HashMap<String,Object>();
		selectItem.put("status", status);
		List<SysNotificationDo> list=sysNotificationComponent.querySysNotificationList(selectItem);
		return list;
	}
}
