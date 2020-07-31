package cn.booktable.modules.service.sys.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.booktable.modules.component.sys.SysRoleComponent;
import cn.booktable.modules.entity.sys.SysPermissionDo;
import cn.booktable.modules.entity.sys.SysRoleDo;
import cn.booktable.modules.service.sys.SysRoleService;
import cn.booktable.core.page.PageDo;

/**
 * 角色.
 * @author ljc
 * @version  v1.0
 */
@Service("sysRoleService")
public class SysRoleServiceImpl  implements SysRoleService{

	@Autowired
	private SysRoleComponent sysRoleComponent;

	/**
	 * 添加角色.
	 * @param sysRole
	 * @return
	 */
	public Integer insertSysRole(SysRoleDo sysRole)
	{
		return sysRoleComponent.insertSysRole(sysRole);
	}

	/**
	 * 获取角色数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysRoleDo> querySysRoleList(Map<String,Object> selectItem)
	{
		return sysRoleComponent.querySysRoleList(selectItem);
	}

	@Override
	public PageDo<SysRoleDo> querySysRoleListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem)
	{
		 return sysRoleComponent.querySysRoleListPage(pageIndex,pageSize,selectItem);
	}

	/**
	 * 根据Id修改角色.
	 * @param sysRole
	 * @return
	 */
	public Integer updateSysRoleById(SysRoleDo sysRole)
	{
		return sysRoleComponent.updateSysRoleById(sysRole);
	}

	/**
	 * 根据Id删除角色.
	 * @param id
	 * @return
	 */
	public Integer deleteSysRoleById(String id)
	{
		return sysRoleComponent.deleteSysRoleById(id);
	}

	/**
	 * 根据Id获取角色.
	 * @param id
	 * @return
	 */
	public SysRoleDo findSysRoleById(String id)
	{
		return sysRoleComponent.findSysRoleById(id);
	}

	@Override
	public List<SysRoleDo> getRoleListWithUserId(Integer userId) {
		return sysRoleComponent.getRoleListWithUserId(userId);
	}


	@Override
	public Integer saveRolePermissions(String roleId, Long[] permissionIds) {
		return sysRoleComponent.saveRolePermissions(roleId, permissionIds);
	}

	@Override
	public List<SysPermissionDo> queryPermissionByRoleId(String roleId) {
		return sysRoleComponent.queryPermissionByRoleId(roleId);
	}

	@Override
	public List<SysPermissionDo> queryPermissionByRoleIdAndPlatformId(String roleId, Integer platformId) {
		return sysRoleComponent.queryPermissionByRoleIdAndPlatformId(roleId, platformId);
	}
}
