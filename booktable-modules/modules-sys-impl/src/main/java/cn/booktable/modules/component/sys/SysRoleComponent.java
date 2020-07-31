package cn.booktable.modules.component.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.SysPermissionDo;
import cn.booktable.modules.entity.sys.SysRoleDo;
import cn.booktable.core.page.PageDo;

/**
 * 角色.
 * @author ljc
 * @version  v1.0
 */
public interface SysRoleComponent {

	/**
	 * 添加角色.
	 * @param sysRole
	 * @return
	 */
	public Integer insertSysRole(SysRoleDo sysRole);

	/**
	 * 获取角色数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysRoleDo> querySysRoleList(Map<String,Object> selectItem);

	/**
	 * 获取角色数据集
	 * @param pageIndex
	 * 起始页
	 * @param pageSize
	 * 每页记录数
	 * @param selectItem
	 * 过滤条件
	 * @return
	 */
	public PageDo<SysRoleDo> querySysRoleListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem);

	/**
	 * 根据Id修改角色.
	 * @param sysRole
	 * @return
	 */
	public Integer updateSysRoleById(SysRoleDo sysRole);

	/**
	 * 根据Id删除角色.
	 * @param id
	 * @return
	 */
	public Integer deleteSysRoleById(String id);

	/**
	 * 根据Id获取角色.
	 * @param id
	 * @return
	 */
	public SysRoleDo findSysRoleById(String id);

	/**
	 * 根据用户ID获取角色字符串。
	 * @param userid
	 * 用户ID
	 * @return
	 */
	public List<String> getRoleStrListByUserId(Integer userId);

	/**
	 * 获取角色列表（包含用户已有角色信息）
	 * @param userId
	 * 用户ID
	 * @return
	 */
	public List<SysRoleDo> getRoleListWithUserId(Integer userId);


	/**
	 * 保存角色权限
	 * @param roleId 角色ID
	 * @param permissionIds 权限Id
	 * @return
	 */
	public Integer saveRolePermissions(String roleId,Long[] permissionIds);

	/**
	 * 根据角色ID获取权限集
	 * @param roleId 角色ID
	 * @return
	 */
	public List<SysPermissionDo> queryPermissionByRoleId(String roleId);

	/**
	 * 根据平台ID，角色ＩＤ获取权限集
	 * @param roleId　角色ＩＤ
	 * @param platformId　平台ＩＤ
	 * @return
	 */
	public List<SysPermissionDo> queryPermissionByRoleIdAndPlatformId(String roleId,Integer platformId);
}
