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
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.booktable.modules.component.sys.ParamComponent;
import cn.booktable.modules.dao.sys.ParamDao;
import cn.booktable.modules.entity.sys.ParamDo;
import cn.booktable.core.page.PageDo;

/**
 * ClassName: ParamComponentImpl <br>
 * Description: TODO
 * @author anxymf
 * Date:2017年1月11日上午11:15:58 <br>
 * @version
 * @since JDK 1.6
 */
@Component
public class ParamComponentImpl implements ParamComponent {

	@Resource
	private ParamDao paramDao;


	@Override
	public Integer insert(ParamDo paramDo) {
		paramDo.setCreateTime(new Date());
		return paramDao.insert(paramDo) ;
	}

	@Override
	public Integer update(ParamDo paramDo) {
		return paramDao.update(paramDo);
	}

	@Override
	public Integer delete(String paramId) {
		return paramDao.delete(paramId);
	}

	@Override
	public ParamDo queryById(String paramId) {
		return paramDao.queryById(paramId);
	}

	@Override
	public ParamDo queryByCode(String paramCode) {
		return paramDao.queryByCode(paramCode);
	}

	@Override
	public PageDo<ParamDo> queryListPage(Map<String, Object> selectItem) {
		String pageIndex = (String)selectItem.get("pageIndex");
		String pageSize = (String)selectItem.get("pageSize");
		PageDo<ParamDo> page = new PageDo<ParamDo>(Long.valueOf(pageIndex),
				Integer.valueOf(pageSize));
		selectItem.put("page", page);
		page.setPage(paramDao.queryListPage(selectItem));
		return page;
	}

	@Override
	public String queryValueByCode(String paramCode) {
		return paramDao.queryValueByCode(paramCode);
	}
}

