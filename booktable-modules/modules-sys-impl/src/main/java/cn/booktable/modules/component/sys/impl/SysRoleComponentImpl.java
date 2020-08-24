package cn.booktable.modules.component.sys.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.booktable.toolkit.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.modules.component.sys.SysRoleComponent;
import cn.booktable.modules.dao.sys.SysRoleDao;
import cn.booktable.modules.dao.sys.SysRolePermissionDao;
import cn.booktable.modules.entity.sys.SysPermissionDo;
import cn.booktable.modules.entity.sys.SysRoleDo;
import cn.booktable.modules.entity.sys.SysRolePermissionDo;
import cn.booktable.core.page.PageDo;
import cn.booktable.util.AssertUtils;
import cn.booktable.util.StringUtils;

/**
 * 角色.
 * @author ljc
 * @version  v1.0
 */
@Component("sysRoleComponent")
public class SysRoleComponentImpl  implements SysRoleComponent{

	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRolePermissionDao sysRolePermissionDao;

	/**
	 * 添加角色.
	 * @param sysRole
	 * @return
	 */
	public Integer insertSysRole(SysRoleDo sysRole)
	{
		sysRole.setId(IdWorker.getIdStr());
		sysRole.setCreateTime(new Date());
		if(sysRole.getAvailable()==null)
		{
			sysRole.setAvailable(0);
		}
		SysRoleDo  dbRole=sysRoleDao.findByName(sysRole.getName());
		AssertUtils.isNull(dbRole, "角色名称重复");
		return sysRoleDao.insert(sysRole);
	}

	/**
	 * 获取角色数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysRoleDo> querySysRoleList(Map<String,Object> selectItem)
	{
		return sysRoleDao.queryList(selectItem);
	}

	@Override
	public PageDo<SysRoleDo> querySysRoleListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem)
	{
		 if(selectItem==null)
		 {
			 selectItem=new HashMap<String,Object>();
		 }
		 PageDo<SysRoleDo> pageBean=new PageDo<SysRoleDo>(pageIndex, pageSize);
		 selectItem.put("page", pageBean);
		 pageBean.setPage(sysRoleDao.queryListPage(selectItem));
		return pageBean;
	}

	/**
	 * 根据Id修改角色.
	 * @param sysRole
	 * @return
	 */
	public Integer updateSysRoleById(SysRoleDo sysRole)
	{
		SysRoleDo  dbRole=sysRoleDao.findByName(sysRole.getName());
		if(dbRole!=null && !dbRole.getId().equals(sysRole.getId()))
		{
			AssertUtils.isTrue(false, "角色名称重复");
		}
		return sysRoleDao.updateById(sysRole);
	}

	/**
	 * 根据Id删除角色.
	 * @param id
	 * @return
	 */
	public Integer deleteSysRoleById(String id)
	{
		return sysRoleDao.deleteById(id);
	}

	/**
	 * 根据Id获取角色.
	 * @param id
	 * @return
	 */
	public SysRoleDo findSysRoleById(String id)
	{
		return sysRoleDao.findById(id);
	}

	@Override
	public List<String> getRoleStrListByUserId(Integer userId) {
		return sysRoleDao.getNameListByUserId(userId);
	}

	@Override
	public List<SysRoleDo> getRoleListWithUserId(Integer userId) {
		return sysRoleDao.getRoleListWithUserId(userId);
	}

	@Override
	public Integer saveRolePermissions(String roleId, Long[] permissionIds) {
		  Integer result=0;
		sysRolePermissionDao.deletePermissionsByRoleId(roleId);
		if(permissionIds!=null)
		{
			for(Long permissionId:permissionIds)
			{
				SysRolePermissionDo rolePermission=new SysRolePermissionDo();
				rolePermission.setId(IdWorker.getIdStr());
				rolePermission.setRoleId(roleId);
				rolePermission.setPermissionId(permissionId);
				Integer dbresult= sysRolePermissionDao.insert(rolePermission);
				result+=dbresult;
			}
		}
		return result;
	}

	@Override
	public List<SysPermissionDo> queryPermissionByRoleId(String roleId) {
		return sysRolePermissionDao.getPermissionByRoleId(roleId);
	}

	@Override
	public List<SysPermissionDo> queryPermissionByRoleIdAndPlatformId(String roleId,Integer platformId)
	{
		return sysRolePermissionDao.getPermissionByRoleIdAndPlatformId(roleId, platformId);
	}
}
