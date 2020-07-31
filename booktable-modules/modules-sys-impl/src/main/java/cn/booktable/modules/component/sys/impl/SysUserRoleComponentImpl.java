package cn.booktable.modules.component.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.modules.component.sys.SysUserRoleComponent;
import cn.booktable.modules.dao.sys.SysUserRoleDao;
import cn.booktable.modules.entity.sys.SysUserDo;
import cn.booktable.modules.entity.sys.SysUserRoleDo;
import cn.booktable.core.page.PageDo;

/**
 * 用户与角色关系.
 * @author ljc
 * @version  v1.0
 */
@Component("sysUserRoleComponent")
public class SysUserRoleComponentImpl  implements SysUserRoleComponent{

	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	/**
	 * 添加用户与角色关系.
	 * @param sysUserRole
	 * @return
	 */
	public Integer insertSysUserRole(SysUserRoleDo sysUserRole)
	{
		return sysUserRoleDao.insert(sysUserRole);
	}

	/**
	 * 获取用户与角色关系数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysUserRoleDo> querySysUserRoleList(Map<String,Object> selectItem)
	{
		return sysUserRoleDao.queryList(selectItem);
	}


	/**
	 * 根据Id修改用户与角色关系.
	 * @param sysUserRole
	 * @return
	 */
	public Integer updateSysUserRoleById(SysUserRoleDo sysUserRole)
	{
		return sysUserRoleDao.updateById(sysUserRole);
	}

	/**
	 * 根据Id删除用户与角色关系.
	 * @param id
	 * @return
	 */
	public Integer deleteSysUserRoleById(String id)
	{
		return sysUserRoleDao.deleteById(id);
	}

	/**
	 * 根据Id获取用户与角色关系.
	 * @param id
	 * @return
	 */
	public SysUserRoleDo findSysUserRoleById(String id)
	{
		return sysUserRoleDao.findById(id);
	}

	@Override
	public PageDo<SysUserDo> queryByRoleIdListPage(String roleId, Long pageIndex, Integer pageSize,
			Map<String, Object> selectItem) {

		 if(selectItem==null)
		 {
			 selectItem=new HashMap<String,Object>();
		 }
		 selectItem.put("roleId", roleId);
		 PageDo<SysUserDo> pageBean=new PageDo<SysUserDo>(pageIndex, pageSize);
		 selectItem.put("page", pageBean);
		 pageBean.setPage(sysUserRoleDao.queryUserByRoleIdListPage(selectItem));
		return pageBean;
	}

	@Override
	public PageDo<SysUserDo> queryUserNoInRoleIdListPage(String[] roleIdList, Long pageIndex, Integer pageSize, Map<String, Object> selectItem) {
		if(selectItem==null)
		{
			selectItem=new HashMap<String,Object>();
		}
		selectItem.put("roleIdList", roleIdList);
		PageDo<SysUserDo> pageBean=new PageDo<SysUserDo>(pageIndex, pageSize);
		selectItem.put("page", pageBean);
		pageBean.setPage(sysUserRoleDao.queryUserNoInRoleIdListPage(selectItem));
		return pageBean;
	}
}
