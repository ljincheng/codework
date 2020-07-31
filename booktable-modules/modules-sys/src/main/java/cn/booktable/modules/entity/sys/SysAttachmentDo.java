package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * 附件.
 * @author ljc
 * @version  v1.0
 */
@Alias("sysAttachmentDo")
public class SysAttachmentDo implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public static final int CHECKEDSTATUS_INIT=1;
	public static final int CHECKEDSTATUS_PASS=2;

	/** ID. */
	private Long id;

	/** 文件路径. */
	private String filePath;

	/** 文件类型. */
	private String fileType;

	/** 文件名称. */
	private String fileName;

	/** 分组. */
	private String groupType;

	/** 核对状态. */
	private Integer checkedStatus;

	/** 创建者用户ID. */
	private Integer createUserId;

	/** 修改用户ID. */
	private Integer updateUserId;

	/** 创建时间. */
	private Date createTime;

	/** 修改时间. */
	private Date updateTime;


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
	 * 分组.
	 * @param groupType
	 * 分组
	 */
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	/**
	 * 分组.
	 * @return 分组
	 */
	public String getGroupType() {
		return this.groupType;
	}

	/**
	 * 核对状态.
	 * @param checkedStatus
	 * 核对状态
	 */
	public void setCheckedStatus(Integer checkedStatus) {
		this.checkedStatus = checkedStatus;
	}

	/**
	 * 核对状态.
	 * @return 核对状态
	 */
	public Integer getCheckedStatus() {
		return this.checkedStatus;
	}

	/**
	 * 创建者用户ID.
	 * @param createUserId
	 * 创建者用户ID
	 */
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 创建者用户ID.
	 * @return 创建者用户ID
	 */
	public Integer getCreateUserId() {
		return this.createUserId;
	}

	/**
	 * 修改用户ID.
	 * @param updateUserId
	 * 修改用户ID
	 */
	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * 修改用户ID.
	 * @return 修改用户ID
	 */
	public Integer getUpdateUserId() {
		return this.updateUserId;
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


	@Override
	public String toString()
	{
		return "SysAttachmentDo ["+",id="+id
+",filePath="+filePath
+",fileType="+fileType
+",fileName="+fileName
+",groupType="+groupType
+",checkedStatus="+checkedStatus
+",createUserId="+createUserId
+",updateUserId="+updateUserId
+",createTime="+createTime
+",updateTime="+updateTime
+"]";
	}

}
