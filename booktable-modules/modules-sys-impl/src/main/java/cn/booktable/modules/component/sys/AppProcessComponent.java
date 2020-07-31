/**
 * Project Name:jcpt-common <br>
 * File Name:AppProcessComponent.java <br>
 * Package Name:com.eic.jcpt.component.system <br>
 * @author anxymf
 * Date:2017年8月7日下午4:33:09 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.component.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.ProcessInfoDo;
import cn.booktable.modules.entity.sys.SysUserDo;
import cn.booktable.core.page.PageDo;

/**
 * ClassName: AppProcessComponent <br>
 * Description: TODO
 * @author anxymf
 * Date:2017年8月7日下午4:33:09 <br>
 * @version
 * @since JDK 1.6
 */
public interface AppProcessComponent {

	public PageDo<SysUserDo> queryAdminListPage(Map<String, Object> selectItem);

	public List<ProcessInfoDo> queryList();

	public List<String> queryProcessIdsByUserId(Long userId);

	public void update(String[] processIds,Long userId);

}

