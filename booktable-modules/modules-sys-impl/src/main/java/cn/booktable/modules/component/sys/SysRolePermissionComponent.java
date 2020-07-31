package cn.booktable.modules.component.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.SysRolePermissionDo;

/**
 * 角色权限关系表.
 * @author ljc
 * @version  v1.0
 */
public interface SysRolePermissionComponent {

	/**
	 * 添加角色权限关系表.
	 * @param sysRolePermission
	 * @return
	 */
	public Integer insertSysRolePermission(SysRolePermissionDo sysRolePermission);

	/**
	 * 获取角色权限关系表数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysRolePermissionDo> querySysRolePermissionList(Map<String,Object> selectItem);


	/**
	 * 根据Id修改角色权限关系表.
	 * @param sysRolePermission
	 * @return
	 */
	public Integer updateSysRolePermissionById(SysRolePermissionDo sysRolePermission);

	/**
	 * 根据Id删除角色权限关系表.
	 * @param id
	 * @return
	 */
	public Integer deleteSysRolePermissionById(String id);

	/**
	 * 根据Id获取角色权限关系表.
	 * @param id
	 * @return
	 */
	public SysRolePermissionDo findSysRolePermissionById(String id);
}
