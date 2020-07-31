package cn.booktable.modules.entity.sys;

import cn.booktable.core.shiro.SysUserPrimaryPrincipal;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户.
 * @author ljc
 * @version  v1.0
 */
@Alias("sysUserDo")
public class SysUserDo implements SysUserPrimaryPrincipal,Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id. */
	private Integer id;

	/** 用户名. */
	private String userName;

	/** 密码. */
	private String password;

	/** 账号是否锁定. */
	private Integer locked;

	/** 头像. */
	private String img;

	/** 真实姓名. */
	private String realName;

	/** 手机号. */
	private String telphone;

	/** 邮箱. */
	private String email;

	/** IP地址. */
	private String ip;

	/** 创建时间. */
	private Date createTime;

	/** 密码错误次数. */
	private Integer incorrectTime;

	/** 最后一次登录时间. */
	private Date lastTime;

	/** 更新时间. */
	private Date updateTime;

	/** 状态. */
	private Integer status;

	/** 最后一次修改密码时间. */
	private Date modifyPwdTime;

	/** 平台ID */
	private Integer platformId;

	/** 性别. */
	private Integer sex;

	/** 老师类型 */
	private Integer teacherType;

	/** 兼职 */
	private Integer partTimeJob;

	/** 生日 */
	private Date birthday;

	/** 英文名字 */
	private String englishName;

	/** 地址 */
	private String address;
	/** 备注 */
	private String remark;

	/** 背景图 */
	private String bgImg;

	/** 座右铭 */
	private String motto;

	/** 关注数 */
	private Integer concernCnt;

	/** 被关注数 */
	private Integer beConcernCnt;

	/** 收藏资讯数 */
	private Integer collectCnt;



	/**
	 * id.
	 * @param id
	 * id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * id.
	 * @return id
	 */
	public Integer getId() {
		return this.id;
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
	 * 密码.
	 * @param password
	 * 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 密码.
	 * @return 密码
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * 账号是否锁定.
	 * @param locked
	 * 账号是否锁定
	 */
	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	/**
	 * 账号是否锁定.
	 * @return 账号是否锁定
	 */
	public Integer getLocked() {
		return this.locked;
	}

	/**
	 * 头像.
	 * @param img
	 * 头像
	 */
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * 头像.
	 * @return 头像
	 */
	public String getImg() {
		return this.img;
	}

	/**
	 * 真实姓名.
	 * @param realName
	 * 真实姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * 真实姓名.
	 * @return 真实姓名
	 */
	public String getRealName() {
		return this.realName;
	}

	/**
	 * 手机号.
	 * @param telphone
	 * 手机号
	 */
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	/**
	 * 手机号.
	 * @return 手机号
	 */
	public String getTelphone() {
		return this.telphone;
	}

	/**
	 * 邮箱.
	 * @param email
	 * 邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 邮箱.
	 * @return 邮箱
	 */
	public String getEmail() {
		return this.email;
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
	 * 密码错误次数.
	 * @param incorrectTime
	 * 密码错误次数
	 */
	public void setIncorrectTime(Integer incorrectTime) {
		this.incorrectTime = incorrectTime;
	}

	/**
	 * 密码错误次数.
	 * @return 密码错误次数
	 */
	public Integer getIncorrectTime() {
		return this.incorrectTime;
	}

	/**
	 * 最后一次登录时间.
	 * @param lastTime
	 * 最后一次登录时间
	 */
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	/**
	 * 最后一次登录时间.
	 * @return 最后一次登录时间
	 */
	public Date getLastTime() {
		return this.lastTime;
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


	public Date getModifyPwdTime() {
		return modifyPwdTime;
	}

	public void setModifyPwdTime(Date modifyPwdTime) {
		this.modifyPwdTime = modifyPwdTime;
	}

	/**
	 * 平台ID
	 * @return
	 */
	public Integer getPlatformId() {
		return platformId;
	}


	/**
	 * 平台ID
	 * @param platformId
	 */
	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}

	/**
	 * 性别.
	 * @return
	 */
	public Integer getSex() {
		return sex;
	}


	/**
	 * 性别.
	 * @param sex
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}



	/**
	 * 老师类型
	 * @return
	 */
	public Integer getTeacherType() {
		return teacherType;
	}


	/**
	 * 老师类型
	 * @param teacherType
	 */
	public void setTeacherType(Integer teacherType) {
		this.teacherType = teacherType;
	}



	/**
	 * 兼职
	 * @return
	 */
	public Integer getPartTimeJob() {
		return partTimeJob;
	}


	/**
	 * 兼职
	 * @param partTimeJob
	 */
	public void setPartTimeJob(Integer partTimeJob) {
		this.partTimeJob = partTimeJob;
	}



	/**
	 * 生日
	 * @return
	 */
	public Date getBirthday() {
		return birthday;
	}


	/**
	 * 生日
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	/**
	 * 英文名字
	 * @return
	 */
	public String getEnglishName() {
		return englishName;
	}


	/**
	 * 英文名字
	 * @param englishName
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBgImg() {
		return bgImg;
	}

	public void setBgImg(String bgImg) {
		this.bgImg = bgImg;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public Integer getConcernCnt() {
		return concernCnt;
	}

	public void setConcernCnt(Integer concernCnt) {
		this.concernCnt = concernCnt;
	}

	public Integer getBeConcernCnt() {
		return beConcernCnt;
	}

	public void setBeConcernCnt(Integer beConcernCnt) {
		this.beConcernCnt = beConcernCnt;
	}

	public Integer getCollectCnt() {
		return collectCnt;
	}

	public void setCollectCnt(Integer collectCnt) {
		this.collectCnt = collectCnt;
	}

	@Override
	public String toString() {
		return "SysUserDo{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", locked=" + locked +
				", img='" + img + '\'' +
				", realName='" + realName + '\'' +
				", telphone='" + telphone + '\'' +
				", email='" + email + '\'' +
				", ip='" + ip + '\'' +
				", createTime=" + createTime +
				", incorrectTime=" + incorrectTime +
				", lastTime=" + lastTime +
				", updateTime=" + updateTime +
				", status=" + status +
				", modifyPwdTime=" + modifyPwdTime +
				", platformId=" + platformId +
				", sex=" + sex +
				", teacherType=" + teacherType +
				", partTimeJob=" + partTimeJob +
				", birthday=" + birthday +
				", englishName='" + englishName + '\'' +
				", address='" + address + '\'' +
				", remark='" + remark + '\'' +
				", bgImg='" + bgImg + '\'' +
				", motto='" + motto + '\'' +
				", concernCnt=" + concernCnt +
				", beConcernCnt=" + beConcernCnt +
				", collectCnt=" + collectCnt +
				'}';
	}
}
