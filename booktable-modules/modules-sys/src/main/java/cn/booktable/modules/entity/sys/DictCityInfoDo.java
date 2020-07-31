/**
 * Project Name:jcpt-common <br>
 * File Name:CityInfoDo.java <br>
 * Package Name:com.hehenian.jcpt.model.system <br>
 * @author anxymf
 * Date:2017年1月5日上午9:23:47 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * ClassName: DictCityInfoDo <br>
 * Description: 城市信息
 * @author anxymf
 * Date:2017年1月5日上午9:23:47 <br>
 * @version
 * @since JDK 1.6
 */
@Alias("dictCityInfoDo")
public class DictCityInfoDo  implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** 城市ID */
	private Integer id;

	/** 父节点ID */
	private Integer parentId;

	/** 城市名称 */
	private String cityName;

	/** 城市编码 */
	private String cityCode;

	/** 贷款端编码 */
	private String loanCode;

	/**
	 * 获取城市ID
	 * @return id 城市ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置城市ID
	 * @param id 城市ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取父节点ID
	 * @return parentId 父节点ID
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * 设置父节点ID
	 * @param parentId 父节点ID
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取城市名称
	 * @return cityName 城市名称
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * 设置城市名称
	 * @param cityName 城市名称
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * 获取城市编码
	 * @return cityCode 城市编码
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * 设置城市编码
	 * @param cityCode 城市编码
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * 贷款端编码
	 * @return
	 */
	public String getLoanCode() {
		return loanCode;
	}

	/**
	 * 贷款端编码
	 * @param loanCode 贷款端编码
	 */
	public void setLoanCode(String loanCode) {
		this.loanCode = loanCode;
	}


}

