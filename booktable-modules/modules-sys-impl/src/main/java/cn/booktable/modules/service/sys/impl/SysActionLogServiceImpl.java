package cn.booktable.modules.service.sys.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.booktable.core.page.PageDo;
import cn.booktable.modules.component.sys.SysActionLogComponent;
import cn.booktable.modules.entity.sys.SysActionLogDo;
import cn.booktable.modules.service.sys.SysActionLogService;

/**
 * 用户活动日志.
 * @author ljc
 * @version  v1.0
 */
@Service("sysActionLogService")
public class SysActionLogServiceImpl  implements SysActionLogService{

	private SysActionLogComponent sysActionLogComponent;

	@Autowired
	public void setSysActionLogComponent(SysActionLogComponent sysActionLogComponent)
	{
		this.sysActionLogComponent=sysActionLogComponent;
	}


	@Override
	public Integer insertSysActionLog(SysActionLogDo sysActionLog)
	{
		return sysActionLogComponent.insertSysActionLog(sysActionLog);
	}

	@Override
	public List<SysActionLogDo> querySysActionLogList(Map<String,Object> selectItem)
	{
		return sysActionLogComponent.querySysActionLogList(selectItem);
	}

	@Override
	public PageDo<SysActionLogDo> querySysActionLogListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem)
	{
		 return sysActionLogComponent.querySysActionLogListPage(pageIndex,pageSize,selectItem);
	}


	@Override
	public Integer updateSysActionLogById(SysActionLogDo sysActionLog)
	{
		return sysActionLogComponent.updateSysActionLogById(sysActionLog);
	}

	@Override
	public Integer deleteSysActionLogById(Long id)
	{
		return sysActionLogComponent.deleteSysActionLogById(id);
	}

	@Override
	public SysActionLogDo findSysActionLogById(Long id)
	{
		return sysActionLogComponent.findSysActionLogById(id);
	}
}
