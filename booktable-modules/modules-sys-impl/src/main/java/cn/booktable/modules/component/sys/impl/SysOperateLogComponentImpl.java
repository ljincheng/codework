package cn.booktable.modules.component.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.modules.component.sys.SysOperateLogComponent;
import cn.booktable.modules.dao.sys.SysOperateLogDao;
import cn.booktable.modules.entity.sys.SysOperateLogDo;
import cn.booktable.modules.entity.sys.SysUserDo;
import cn.booktable.core.page.PageDo;

/**
 * 用户操作日志
 * @author: sungymf
 * @date: 2017年7月14日 上午6:40:21
 */
@Component
public class SysOperateLogComponentImpl implements SysOperateLogComponent {

	@Autowired
	private SysOperateLogDao sysOperateLogDao;


	@Override
	public Integer insertSysOperateLog(SysOperateLogDo sysOperateLogDo) {
		return sysOperateLogDao.insert(sysOperateLogDo);
	}

	@Override
	public List<SysOperateLogDo> querySysOperateLogList(Map<String, Object> selectItem) {
		return sysOperateLogDao.queryList(selectItem);
	}

	@Override
	public PageDo<SysOperateLogDo> querySysOperateLogListPage(Long pageIndex,
			Integer pageSize, Map<String, Object> selectItem) {
		 if(selectItem==null)
		 {
			 selectItem=new HashMap<String,Object>();
		 }
		 PageDo<SysOperateLogDo> pageBean=new PageDo<SysOperateLogDo>(pageIndex, pageSize);
		 selectItem.put("page", pageBean);
		 pageBean.setPage(sysOperateLogDao.queryListPage(selectItem));
		return pageBean;
	}

	@Override
	public Integer updateSysOperateLogById(SysOperateLogDo sysOperateLogDo) {
		return sysOperateLogDao.updateById(sysOperateLogDo);
	}

	@Override
	public Integer deleteSysOperateLogById(Long id) {
		return sysOperateLogDao.deleteById(id);
	}

	@Override
	public SysOperateLogDo findSysOperateLogById(Long id) {
		return sysOperateLogDao.findById(id);
	}

}
