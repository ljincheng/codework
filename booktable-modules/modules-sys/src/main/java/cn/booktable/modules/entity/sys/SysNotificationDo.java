package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统通知.
 * @author ljc
 * @version  v1.0
 */
@Alias("sysNotificationDo")
public class SysNotificationDo implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 0未通知 */
	public static int STATUS_INIT=0;
	/** 1通知成功 */
	public static int STATUS_SUCCESS=1;
	/** 2通知失败 */
	public static int STATUS_FAIL=2;
	/** 邮件通知 */
	public static int NOTICETYPE_MAIL=1;
	/** 短信通知 */
	public static int NOTICETYPE_SMS=2;

	/** 主健ID. */
	private String id;

	/** 标题. */
	private String title;

	/** 内容. */
	private String content;

	/** 通知方式. */
	private Integer noticeType;

	/** 接收邮件地址. */
	private String receives;

	/** 通知状态. */
	private Integer status;

	/** 通知时间. */
	private Date noticeTime;

	/** 创建时间. */
	private Date createTime;

	/** 更新时间. */
	private Date updateTime;


	/**
	 * 主健ID.
	 * @param id
	 * 主健ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 主健ID.
	 * @return 主健ID
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 标题.
	 * @param title
	 * 标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 标题.
	 * @return 标题
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * 内容.
	 * @param content
	 * 内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 内容.
	 * @return 内容
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * 通知方式.
	 * @param noticeType
	 * 通知方式
	 */
	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}

	/**
	 * 通知方式.
	 * @return 通知方式
	 */
	public Integer getNoticeType() {
		return this.noticeType;
	}

	/**
	 * 接收邮件地址.
	 * @param receives
	 * 接收邮件地址
	 */
	public void setReceives(String receives) {
		this.receives = receives;
	}

	/**
	 * 接收邮件地址.
	 * @return 接收邮件地址
	 */
	public String getReceives() {
		return this.receives;
	}

	/**
	 * 通知状态.
	 * @param status
	 * 通知状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 通知状态.
	 * @return 通知状态
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * 通知时间.
	 * @param noticeTime
	 * 通知时间
	 */
	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}

	/**
	 * 通知时间.
	 * @return 通知时间
	 */
	public Date getNoticeTime() {
		return this.noticeTime;
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
	 * 更新时间.
	 * @param updateTime
	 * 更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 更新时间.
	 * @return 更新时间
	 */
	public Date getUpdateTime() {
		return this.updateTime;
	}


	@Override
	public String toString()
	{
		return "SysNotificationDo ["+",id="+id
+",title="+title
+",content="+content
+",noticeType="+noticeType
+",receives="+receives
+",status="+status
+",noticeTime="+noticeTime
+",createTime="+createTime
+",updateTime="+updateTime
+"]";
	}

}
