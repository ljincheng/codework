package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户操作日志
 * @author: sungymf
 * @date: 2017年7月14日 上午6:10:24
 */
@Alias("sysOperateLogDo")
public class SysOperateLogDo implements Serializable{

	private static final long serialVersionUID = -8696016772063028133L;
	private Long id;
	private Integer userId;
	private String url;
	private String ip;
	private String userAgent;
	private Integer status;
	private Date createTime;
	private String userName;
	private String realName;
	private String parentUrlName;
	private String urlName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getParentUrlName() {
		return parentUrlName;
	}
	public void setParentUrlName(String parentUrlName) {
		this.parentUrlName = parentUrlName;
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	@Override
	public String toString() {
		return "SysOperateLogDo [id=" + id + ", userId=" + userId + ", url="
				+ url + ", ip=" + ip + ", userAgent=" + userAgent + ", status="
				+ status + ", createTime=" + createTime + ", userName="
				+ userName + ", realName=" + realName + ", parentUrlName="
				+ parentUrlName + ", urlName=" + urlName + "]";
	}

}
