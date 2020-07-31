package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 角色权限关系表.
 * @author ljc
 * @version  v1.0
 */
@Alias("sysRolePermissionDo")
public class SysRolePermissionDo implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 主键. */
	private String id;

	/** 角色ID. */
	private String roleId;

	/** 权限ID. */
	private Long permissionId;


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
	 * 权限ID.
	 * @param permissionId
	 * 权限ID
	 */
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	/**
	 * 权限ID.
	 * @return 权限ID
	 */
	public Long getPermissionId() {
		return this.permissionId;
	}


	@Override
	public String toString()
	{
		return "SysRolePermissionDo ["+",id="+id
+",roleId="+roleId
+",permissionId="+permissionId
+"]";
	}

}
