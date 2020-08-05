package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;


/**
 * ClassName: SysDictDo <br>
 * Description: 数据字典
 * @version
 * @since JDK 1.6
 */
@Alias("sysDictDo")
public class SysDictDo implements Serializable{

	public static final String ISVALID_T="T";
	public static final String ISVALID_F="F";

	/** 字典ID */
	private String codeId;

	/** 字典类型 */
	private String codeType;

	/** 字典值 */
	private String codeValue;

	/** 字典名称 */
	private String codeName;

	/** 是否有效(T为有效，F为无效)  */
	private String isValid;

	/** 英文名称 */
	private String codeNameEn;

	/**
	 * 中文名称
	 */
	private String codeNameCn;

	/** 排序权重 */
	private Integer indexs;

	/** 创建日期  */
	private Date createTime;

	/**
	 * 获取字典ID
	 * @return codeId 字典ID
	 */
	public String getCodeId() {
		return codeId;
	}

	/**
	 * 设置字典ID
	 * @param codeId 字典ID
	 */
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	/**
	 * 获取字典类型
	 * @return codeType 字典类型
	 */
	public String getCodeType() {
		return codeType;
	}

	/**
	 * 设置字典类型
	 * @param codeType 字典类型
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	/**
	 * 获取字典值
	 * @return codeValue 字典值
	 */
	public String getCodeValue() {
		return codeValue;
	}

	/**
	 * 设置字典值
	 * @param codeValue 字典值
	 */
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	/**
	 * 获取字典名称
	 * @return codeName 字典名称
	 */
	public String getCodeName() {
		return codeName;
	}

	/**
	 * 设置字典名称
	 * @param codeName 字典名称
	 */
	public void setCodeName(String codeName) {
		this.codeName = codeName;
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
	 * 获取创建日期
	 * @return createTime 创建日期
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建日期
	 * @param createTime 创建日期
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	/**
	 * 英文名称
	 * @return
	 */
	public String getCodeNameEn() {
		return codeNameEn;
	}

	/**
	 * 英文名称
	 * @param codeNameEn
	 */
	public void setCodeNameEn(String codeNameEn) {
		this.codeNameEn = codeNameEn;
	}

	/**
	 * 中文名称
	 * @return
	 */
	public String getCodeNameCn() {
		return codeNameCn;
	}

	/**
	 * 中文名称
	 * @param codeNameCn
	 */
	public void setCodeNameCn(String codeNameCn) {
		this.codeNameCn = codeNameCn;
	}

	/**
	 * 排序权重
	 * @return
	 */
	public Integer getIndexs() {
		return indexs;
	}

	/**
	 * 排序权重
	 * @param indexs
	 */
	public void setIndexs(Integer indexs) {
		this.indexs = indexs;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 */
	@Override
	public String toString() {
		return "SysDictDo [codeValue=" + codeValue + ", codeName="
				+ codeName + "]";
	}



}

