package cn.booktable.modules.component.sys.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.modules.component.sys.SysRolePermissionComponent;
import cn.booktable.modules.dao.sys.SysRolePermissionDao;
import cn.booktable.modules.entity.sys.SysRolePermissionDo;

/**
 * 角色权限关系表.
 * @author ljc
 * @version  v1.0
 */
@Component("sysRolePermissionComponent")
public class SysRolePermissionComponentImpl  implements SysRolePermissionComponent{

	@Autowired
	private SysRolePermissionDao sysRolePermissionDao;

	/**
	 * 添加角色权限关系表.
	 * @param sysRolePermission
	 * @return
	 */
	public Integer insertSysRolePermission(SysRolePermissionDo sysRolePermission)
	{
		return sysRolePermissionDao.insert(sysRolePermission);
	}

	/**
	 * 获取角色权限关系表数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysRolePermissionDo> querySysRolePermissionList(Map<String,Object> selectItem)
	{
		return sysRolePermissionDao.queryList(selectItem);
	}


	/**
	 * 根据Id修改角色权限关系表.
	 * @param sysRolePermission
	 * @return
	 */
	public Integer updateSysRolePermissionById(SysRolePermissionDo sysRolePermission)
	{
		return sysRolePermissionDao.updateById(sysRolePermission);
	}

	/**
	 * 根据Id删除角色权限关系表.
	 * @param id
	 * @return
	 */
	public Integer deleteSysRolePermissionById(String id)
	{
		return sysRolePermissionDao.deleteById(id);
	}

	/**
	 * 根据Id获取角色权限关系表.
	 * @param id
	 * @return
	 */
	public SysRolePermissionDo findSysRolePermissionById(String id)
	{
		return sysRolePermissionDao.findById(id);
	}
}
