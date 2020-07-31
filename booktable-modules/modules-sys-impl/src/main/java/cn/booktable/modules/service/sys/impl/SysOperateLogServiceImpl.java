package cn.booktable.modules.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.booktable.modules.component.sys.SysOperateLogComponent;
import cn.booktable.modules.entity.sys.SysOperateLogDo;
import cn.booktable.modules.service.sys.SysOperateLogService;
import cn.booktable.core.page.PageDo;

/**
 * 用户操作日志
 * @author: sungymf
 * @date: 2017年7月14日 上午6:35:59
 */
@Service("sysOperateLogService")
public class SysOperateLogServiceImpl implements SysOperateLogService {

	@Autowired
	private SysOperateLogComponent sysOperateLogComponent;

	@Override
	public Integer insertSysOperateLog(SysOperateLogDo sysOperateLogDo) {
		return sysOperateLogComponent.insertSysOperateLog(sysOperateLogDo);
	}

	@Override
	public List<SysOperateLogDo> querySysOperateLogList(Map<String, Object> selectItem) {
		return sysOperateLogComponent.querySysOperateLogList(selectItem);
	}

	@Override
	public PageDo<SysOperateLogDo> querySysOperateLogListPage(Long pageIndex,
			Integer pageSize, Map<String, Object> selectItem) {
		return sysOperateLogComponent.querySysOperateLogListPage(pageIndex, pageSize, selectItem);
	}

	@Override
	public Integer updateSysOperateLogById(SysOperateLogDo sysOperateLogDo) {
		return sysOperateLogComponent.updateSysOperateLogById(sysOperateLogDo);
	}

	@Override
	public Integer deleteSysOperateLogById(Long id) {
		return sysOperateLogComponent.deleteSysOperateLogById(id);
	}

	@Override
	public SysOperateLogDo findSysOperateLogById(Long id) {
		return sysOperateLogComponent.findSysOperateLogById(id);
	}

}
