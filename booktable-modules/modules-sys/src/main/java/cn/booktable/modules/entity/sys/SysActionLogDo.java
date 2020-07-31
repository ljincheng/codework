package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户活动日志.
 * @author ljc
 * @version  v1.0
 */
@Alias("sysActionLogDo")
public class SysActionLogDo implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public static String LEVEL_GENERAL="一般";
	public static String LEVEL_DANGER="危险";
	public static String LEVEL_IMPORTANT="重要";

	/** ID. */
	private Long id;

	/** level. */
	private String level;

	/** mode. */
	private String mode;

	/** detail. */
	private String detail;

	/** content. */
	private String content;

	/** 用户ID. */
	private Integer userId;

	/** actionUrl. */
	private String actionUrl;

	/** 创建时间. */
	private Date createTime;

	/** 操作用户名**/
	private String realName;

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
	 * level.
	 * @param level
	 * level
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * level.
	 * @return level
	 */
	public String getLevel() {
		return this.level;
	}

	/**
	 * mode.
	 * @param mode
	 * mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * mode.
	 * @return mode
	 */
	public String getMode() {
		return this.mode;
	}

	/**
	 * detail.
	 * @param detail
	 * detail
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * detail.
	 * @return detail
	 */
	public String getDetail() {
		return this.detail;
	}

	/**
	 * content.
	 * @param content
	 * content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * content.
	 * @return content
	 */
	public String getContent() {
		return this.content;
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
	 * actionUrl.
	 * @param actionUrl
	 * actionUrl
	 */
	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	/**
	 * actionUrl.
	 * @return actionUrl
	 */
	public String getActionUrl() {
		return this.actionUrl;
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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Override
	public String toString()
	{
		return "SysActionLogDo ["+",id="+id
+",level="+level
+",mode="+mode
+",detail="+detail
+",content="+content
+",userId="+userId
+",actionUrl="+actionUrl
+",createTime="+createTime
+"]";
	}

}
