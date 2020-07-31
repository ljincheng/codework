package cn.booktable.modules.component.sys.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.component.sys.SysActionLogComponent;
import cn.booktable.modules.dao.sys.SysActionLogDao;
import cn.booktable.modules.entity.sys.SysActionLogDo;

/**
 * 用户活动日志.
 * @author ljc
 * @version  v1.0
 */
@Component("sysActionLogComponent")
public class SysActionLogComponentImpl  implements SysActionLogComponent{

	private SysActionLogDao sysActionLogDao;

	@Autowired
	public void setSysActionLogDao(SysActionLogDao sysActionLogDao)
	{
		this.sysActionLogDao=sysActionLogDao;
	}


	@Override
	public Integer insertSysActionLog(SysActionLogDo sysActionLog)
	{
		Date now=new Date();
		sysActionLog.setCreateTime(now);
		return sysActionLogDao.insert(sysActionLog);
	}

	@Override
	public List<SysActionLogDo> querySysActionLogList(Map<String,Object> selectItem)
	{
		return sysActionLogDao.queryList(selectItem);
	}

	@Override
	public PageDo<SysActionLogDo> querySysActionLogListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem)
	{
		 if(selectItem==null)
		 {
			 selectItem=new HashMap<String,Object>();
		 }
		 PageDo<SysActionLogDo> pageBean=new PageDo<SysActionLogDo>(pageIndex, pageSize);
		 selectItem.put("page", pageBean);
		 pageBean.setPage(sysActionLogDao.queryListPage(selectItem));
		return pageBean;
	}


	@Override
	public Integer updateSysActionLogById(SysActionLogDo sysActionLog)
	{
		return sysActionLogDao.updateById(sysActionLog);
	}

	@Override
	public Integer deleteSysActionLogById(Long id)
	{
		return sysActionLogDao.deleteById(id);
	}

	@Override
	public SysActionLogDo findSysActionLogById(Long id)
	{
		return sysActionLogDao.findById(id);
	}
}
