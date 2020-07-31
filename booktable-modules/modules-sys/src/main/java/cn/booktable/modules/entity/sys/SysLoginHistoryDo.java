package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录历史.
 * @author ljc
 * @version  v1.0
 */
@Alias("sysLoginHistoryDo")
public class SysLoginHistoryDo implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 主键. */
	private Long id;

	/** IP地址. */
	private String ip;

	/** 用户名. */
	private String userName;

	/** 创建时间. */
	private Date createTime;

	/** 浏览器信息. */
	private String userAgent;

	/** 状态. */
	private Integer status;


	/**
	 * 主键.
	 * @param id
	 * 主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 主键.
	 * @return 主键
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * IP地址.
	 * @param ip
	 * IP地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * IP地址.
	 * @return IP地址
	 */
	public String getIp() {
		return this.ip;
	}

	/**
	 * 用户名.
	 * @param userName
	 * 用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 用户名.
	 * @return 用户名
	 */
	public String getUserName() {
		return this.userName;
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
	 * 浏览器信息.
	 * @param userAgent
	 * 浏览器信息
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	/**
	 * 浏览器信息.
	 * @return 浏览器信息
	 */
	public String getUserAgent() {
		return this.userAgent;
	}

	/**
	 * 状态.
	 * @param status
	 * 状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 状态.
	 * @return 状态
	 */
	public Integer getStatus() {
		return this.status;
	}


	@Override
	public String toString()
	{
		return "SysLoginHistoryDo ["+",id="+id
+",ip="+ip
+",userName="+userName
+",createTime="+createTime
+",userAgent="+userAgent
+",status="+status
+"]";
	}

}
