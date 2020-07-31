/**
 * Project Name:jcpt-app <br>
 * File Name:ProcessList.java <br>
 * Package Name:com.jcpt.app.model.sys <br>
 * @author anxymf
 * Date:2017年4月20日下午5:42:05 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * ClassName: Process <br>
 * Description: 流程
 * @author anxymf
 * Date:2017年4月20日下午5:42:05 <br>
 * @version
 * @since JDK 1.6
 */
@Alias("processInfoDo")
public class ProcessInfoDo  implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** 流程ID */
	private Long processId;

	/** 流程名称  */
	private String processName;


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

	/**
	 * 获取流程名称
	 * @return processName 流程名称
	 */
	public String getProcessName() {
		return processName;
	}

	/**
	 * 设置流程名称
	 * @param processName 流程名称
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
	}



}

