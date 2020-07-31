package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * 模板文件.
 * @author ljc
 * @version  v1.0
 */
@Alias("sysTemplateFileDo")
public class SysTemplateFileDo implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** ID. */
	private Long id;

	/** 文件路径. */
	private String filePath;

	/** 文件类型. */
	private String fileType;

	/** 文件名称. */
	private String fileName;

	/** 图标. */
	private String icon;

	/** 用户ID. */
	private Integer userId;

	/** 创建时间. */
	private Date createTime;

	/** 修改时间. */
	private Date updateTime;

	/** 备注. */
	private String remark;

	/** 锁定(0没锁，1锁定）. */
	private Integer locked;

	/** 固定ID. */
	private Integer fixedId;


	/**
	 * ID.
	 * @param id
	 * ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * ID.
	 * @return ID
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * 文件路径.
	 * @param filePath
	 * 文件路径
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * 文件路径.
	 * @return 文件路径
	 */
	public String getFilePath() {
		return this.filePath;
	}

	/**
	 * 文件类型.
	 * @param fileType
	 * 文件类型
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * 文件类型.
	 * @return 文件类型
	 */
	public String getFileType() {
		return this.fileType;
	}

	/**
	 * 文件名称.
	 * @param fileName
	 * 文件名称
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 文件名称.
	 * @return 文件名称
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * 图标.
	 * @param icon
	 * 图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 图标.
	 * @return 图标
	 */
	public String getIcon() {
		return this.icon;
	}

	/**
	 * 用户ID.
	 * @param userId
	 * 用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 用户ID.
	 * @return 用户ID
	 */
	public Integer getUserId() {
		return this.userId;
	}

	/**
	 * 创建时间.
	 * @param createTime
	 * 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 创建时间.
	 * @return 创建时间
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * 修改时间.
	 * @param updateTime
	 * 修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 修改时间.
	 * @return 修改时间
	 */
	public Date getUpdateTime() {
		return this.updateTime;
	}

	/**
	 * 备注.
	 * @param remark
	 * 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 备注.
	 * @return 备注
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 锁定(0没锁，1锁定）.
	 * @param locked
	 * 锁定(0没锁，1锁定）
	 */
	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	/**
	 * 锁定(0没锁，1锁定）.
	 * @return 锁定(0没锁，1锁定）
	 */
	public Integer getLocked() {
		return this.locked;
	}

	/**
	 * 固定ID.
	 * @param fixedId
	 * 固定ID
	 */
	public void setFixedId(Integer fixedId) {
		this.fixedId = fixedId;
	}

	/**
	 * 固定ID.
	 * @return 固定ID
	 */
	public Integer getFixedId() {
		return this.fixedId;
	}


	@Override
	public String toString()
	{
		return "SysTemplateFileDo ["+",id="+id
+",filePath="+filePath
+",fileType="+fileType
+",fileName="+fileName
+",icon="+icon
+",userId="+userId
+",createTime="+createTime
+",updateTime="+updateTime
+",remark="+remark
+",locked="+locked
+",fixedId="+fixedId
+"]";
	}

}
