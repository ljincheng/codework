package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统参数
 * @author ljc
 *
 */
@Alias("sysParamDo")
public class SysParamDo implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static final String ISVALID_T="T";
	public static final String ISVALID_F="F";

	/** 参数ID */
	private String paramId;

	/** 参数名称 */
	private String paramName;

	/** 参数编码 */
	private String paramCode;

	/** 参数值 */
	private String paramValue;

	/** 是否有效(T为有效，F为无效) */
	private String isValid;

	/** 创建时间 */
	private Date createTime;

	/**
	 * 获取参数ID
	 * @return paramId 参数ID
	 */
	public String getParamId() {
		return paramId;
	}

	/**
	 * 设置参数ID
	 * @param paramId 参数ID
	 */
	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	/**
	 * 获取参数名称
	 * @return paramName 参数名称
	 */
	public String getParamName() {
		return paramName;
	}

	/**
	 * 设置参数名称
	 * @param paramName 参数名称
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	/**
	 * 获取参数编码
	 * @return paramCode 参数编码
	 */
	public String getParamCode() {
		return paramCode;
	}

	/**
	 * 设置参数编码
	 * @param paramCode 参数编码
	 */
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	/**
	 * 获取参数值
	 * @return paramValue 参数值
	 */
	public String getParamValue() {
		return paramValue;
	}

	/**
	 * 设置参数值
	 * @param paramValue 参数值
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	/**
	 * 获取是否有效(T为有效，F为无效)
	 * @return isValid 是否有效(T为有效，F为无效)
	 */
	public String getIsValid() {
		return isValid;
	}

	/**
	 * 设置是否有效(T为有效，F为无效)
	 * @param isValid 是否有效(T为有效，F为无效)
	 */
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	/**
	 * 获取创建时间
	 * @return createTime 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



}

