/**
 * Project Name:jcpt-common <br>
 * File Name:ParamComponentImpl.java <br>
 * Package Name:com.eic.jcpt.component.system.impl <br>
 * @author anxymf
 * Date:2017年1月11日上午11:15:58 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.component.sys.impl;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import cn.booktable.modules.entity.sys.SysParamDo;
import org.springframework.stereotype.Component;

import cn.booktable.modules.component.sys.SysParamComponent;
import cn.booktable.modules.dao.sys.SysParamDao;
import cn.booktable.core.page.PageDo;

@Component
public class SysParamComponentImpl implements SysParamComponent {

	@Resource
	private SysParamDao sysParamDao;


	@Override
	public Integer insert(SysParamDo sysParamDo) {
		sysParamDo.setCreateTime(new Date());
		return sysParamDao.insert(sysParamDo) ;
	}

	@Override
	public Integer update(SysParamDo sysParamDo) {
		return sysParamDao.update(sysParamDo);
	}

	@Override
	public Integer delete(String paramId) {
		return sysParamDao.delete(paramId);
	}

	@Override
	public SysParamDo queryById(String paramId) {
		return sysParamDao.queryById(paramId);
	}

	@Override
	public SysParamDo queryByCode(String paramCode) {
		return sysParamDao.queryByCode(paramCode);
	}

	@Override
	public PageDo<SysParamDo> queryListPage(Map<String, Object> selectItem) {
		String pageIndex = (String)selectItem.get("pageIndex");
		String pageSize = (String)selectItem.get("pageSize");
		PageDo<SysParamDo> page = new PageDo<SysParamDo>(Long.valueOf(pageIndex),
				Integer.valueOf(pageSize));
		selectItem.put("page", page);
		page.setPage(sysParamDao.queryListPage(selectItem));
		return page;
	}

	@Override
	public String queryValueByCode(String paramCode) {
		return sysParamDao.queryValueByCode(paramCode);
	}
}

