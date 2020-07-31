package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色.
 * @author ljc
 * @version  v1.0
 */
@Alias("sysRoleDo")
public class SysRoleDo implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 主键. */
	private String id;

	/** 名称. */
	private String name;

	/** 是否可用. */
	private Integer available;

	/** 创建时间. */
	private Date createTime;

	/** 修改时间. */
	private Date updateTime;

	/** 用户ID. */
	private Integer userId;


	/**
	 * 主键.
	 * @param id
	 * 主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 主键.
	 * @return 主键
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 名称.
	 * @param name
	 * 名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 名称.
	 * @return 名称
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 是否可用.
	 * @param available
	 * 是否可用
	 */
	public void setAvailable(Integer available) {
		this.available = available;
	}

	/**
	 * 是否可用.
	 * @return 是否可用
	 */
	public Integer getAvailable() {
		return this.available;
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
	 * @return
	 */
	public Date getUpdateTime() {
		return updateTime;
	}


	/**
	 * 修改时间.
	 * @param updateTime 修改时间.
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	/**
	 * 用户ID.
	 * @return
	 */
	public Integer getUserId()
	{
		return this.userId;
	}

	/**
	 * 用户ID.
	 * @param userId
	 */
	public void setUserId(Integer userId)
	{
		this.userId=userId;
	}

	@Override
	public String toString()
	{
		return "SysRoleDo ["+",id="+id
+",name="+name
+",available="+available
+",createTime="+createTime
+"]";
	}

}
