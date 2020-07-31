package cn.booktable.modules.component.sys.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.modules.component.sys.SysNotificationComponent;
import cn.booktable.modules.dao.sys.SysNotificationDao;
import cn.booktable.modules.entity.sys.SysNotificationDo;
import cn.booktable.core.page.PageDo;

/**
 * 系统通知.
 * @author ljc
 * @version  v1.0
 */
@Component("sysNotificationComponent")
public class SysNotificationComponentImpl  implements SysNotificationComponent{

	private SysNotificationDao sysNotificationDao;

	@Autowired
	public void setSysNotificationDao(SysNotificationDao sysNotificationDao)
	{
		this.sysNotificationDao=sysNotificationDao;
	}


	@Override
	public Integer insertSysNotification(SysNotificationDo sysNotification)
	{
		return sysNotificationDao.insert(sysNotification);
	}

	@Override
	public List<SysNotificationDo> querySysNotificationList(Map<String,Object> selectItem)
	{
		return sysNotificationDao.queryList(selectItem);
	}

	@Override
	public PageDo<SysNotificationDo> querySysNotificationListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem)
	{
		 if(selectItem==null)
		 {
			 selectItem=new HashMap<String,Object>();
		 }
		 PageDo<SysNotificationDo> pageBean=new PageDo<SysNotificationDo>(pageIndex, pageSize);
		 selectItem.put("page", pageBean);
		 pageBean.setPage(sysNotificationDao.queryListPage(selectItem));
		return pageBean;
	}


	@Override
	public Integer updateSysNotificationById(SysNotificationDo sysNotification)
	{
		return sysNotificationDao.updateById(sysNotification);
	}

	@Override
	public Integer deleteSysNotificationById(String id)
	{
		return sysNotificationDao.deleteById(id);
	}

	@Override
	public SysNotificationDo findSysNotificationById(String id)
	{
		return sysNotificationDao.findById(id);
	}
}
