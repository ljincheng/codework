/**
 * Project Name:jcpt-common <br>
 * File Name:AppProcessComponentImpl.java <br>
 * Package Name:com.eic.jcpt.component.system.impl <br>
 * @author anxymf
 * Date:2017年8月7日下午5:04:29 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.component.sys.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.booktable.modules.component.sys.AppProcessComponent;
import cn.booktable.modules.dao.sys.AppProcessDao;
import cn.booktable.modules.entity.sys.AppRoleDo;
import cn.booktable.modules.entity.sys.ProcessInfoDo;
import cn.booktable.modules.entity.sys.SysUserDo;
import cn.booktable.core.page.PageDo;
import cn.booktable.util.StringUtils;

/**
 * ClassName: AppProcessComponentImpl <br>
 * Description: TODO
 * @author anxymf
 * Date:2017年8月7日下午5:04:29 <br>
 * @version
 * @since JDK 1.6
 */
@Component
public class AppProcessComponentImpl implements AppProcessComponent {

	@Resource
	private AppProcessDao appProcessDao;

	@Override
	public PageDo<SysUserDo> queryAdminListPage(Map<String, Object> selectItem) {
		String pageIndex = (String)selectItem.get("pageIndex");
		String pageSize = (String)selectItem.get("pageSize");
		PageDo<SysUserDo> page = new PageDo<SysUserDo>(Long.valueOf(pageIndex),
				Integer.valueOf(pageSize));
		selectItem.put("page", page);
		page.setPage(appProcessDao.queryListPage(selectItem));
		return page;
	}

	@Override
	public List<ProcessInfoDo> queryList() {
		return appProcessDao.queryList();
	}

	@Override
	public List<String> queryProcessIdsByUserId(Long userId) {
		return appProcessDao.queryProcessIdsByUserId(userId);
	}

	@Override
	public void update(String[] processIds, Long userId) {
		appProcessDao.delete(userId);
		for(String processId : processIds){
			AppRoleDo appRole = new AppRoleDo();
			appRole.setAppRoleId(StringUtils.getUUID32());
			appRole.setProcessId(Long.parseLong(processId));
			appRole.setUserId(userId);
			appProcessDao.insert(appRole);
		}
	}

}

