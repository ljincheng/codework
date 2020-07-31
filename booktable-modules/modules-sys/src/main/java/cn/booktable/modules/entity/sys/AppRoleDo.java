/**
 * Project Name:jcpt-common <br>
 * File Name:AppRoleDo.java <br>
 * Package Name:com.hehenian.jcpt.model.system <br>
 * @author anxymf
 * Date:2017年8月7日下午5:27:26 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * ClassName: AppRoleDo <br>
 * Description: TODO
 * @author anxymf
 * Date:2017年8月7日下午5:27:26 <br>
 * @version
 * @since JDK 1.6
 */
@Alias("appRoleDo")
public class AppRoleDo  implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** 权限ID */
	private String appRoleId;

	/** 用户ID */
	private Long userId;

	/** 流程ID */
	private Long processId;

	/**
	 * 获取权限ID
	 * @return appRoleId 权限ID
	 */
	public String getAppRoleId() {
		return appRoleId;
	}

	/**
	 * 设置权限ID
	 * @param appRoleId 权限ID
	 */
	public void setAppRoleId(String appRoleId) {
		this.appRoleId = appRoleId;
	}

	/**
	 * 获取用户ID
	 * @return userId 用户ID
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 设置用户ID
	 * @param userId 用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 获取流程ID
	 * @return processId 流程ID
	 */
	public Long getProcessId() {
		return processId;
	}

	/**
	 * 设置流程ID
	 * @param processId 流程ID
	 */
	public void setProcessId(Long processId) {
		this.processId = processId;
	}



}

