package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;
import java.io.Serializable;

/**
 * 用户与角色关系.
 * @author ljc
 * @version  v1.0
 */
@Alias("sysUserRoleDo")
public class SysUserRoleDo implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 主键. */
	private String id;

	/** 角色ID. */
	private String roleId;

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
	 * 角色ID.
	 * @param roleId
	 * 角色ID
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * 角色ID.
	 * @return 角色ID
	 */
	public String getRoleId() {
		return this.roleId;
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


	@Override
	public String toString()
	{
		return "SysUserRoleDo ["+",id="+id
+",roleId="+roleId
+",userId="+userId
+"]";
	}

}
