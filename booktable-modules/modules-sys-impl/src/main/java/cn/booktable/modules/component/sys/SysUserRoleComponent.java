package cn.booktable.modules.component.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.SysUserDo;
import cn.booktable.modules.entity.sys.SysUserRoleDo;
import cn.booktable.core.page.PageDo;

/**
 * 用户与角色关系.
 * @author ljc
 * @version  v1.0
 */
public interface SysUserRoleComponent {

	/**
	 * 添加用户与角色关系.
	 * @param sysUserRole
	 * @return
	 */
	public Integer insertSysUserRole(SysUserRoleDo sysUserRole);

	/**
	 * 获取用户与角色关系数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysUserRoleDo> querySysUserRoleList(Map<String,Object> selectItem);


	/**
	 * 根据Id修改用户与角色关系.
	 * @param sysUserRole
	 * @return
	 */
	public Integer updateSysUserRoleById(SysUserRoleDo sysUserRole);

	/**
	 * 根据Id删除用户与角色关系.
	 * @param id
	 * @return
	 */
	public Integer deleteSysUserRoleById(String id);

	/**
	 * 根据Id获取用户与角色关系.
	 * @param id
	 * @return
	 */
	public SysUserRoleDo findSysUserRoleById(String id);


	/**
	 * 根据角色ID获取用户集
	 * @param roleId 角色ID
	 * @param pageIndex 起始页
	 * @param pageSize 每页记录数
	 * @param selectItem 过滤条件
	 * @return
	 */
	public PageDo<SysUserDo> queryByRoleIdListPage(String roleId,Long pageIndex,Integer pageSize,Map<String, Object> selectItem);

	/**
	 * 获取不包含角色ID列表的用户集
	 * @param roleIdList 角色ID列表
	 * @param pageIndex
	 * @param pageSize
	 * @param selectItem
	 * @return
	 */
	public PageDo<SysUserDo> queryUserNoInRoleIdListPage(String[] roleIdList,Long pageIndex,Integer pageSize,Map<String, Object> selectItem);

}
