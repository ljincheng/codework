package cn.booktable.modules.service.sys.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import cn.booktable.modules.component.sys.SysPermissionComponent;
import cn.booktable.modules.component.sys.SysPlatformComponent;
import cn.booktable.modules.entity.sys.SysPermissionDo;
import cn.booktable.modules.entity.sys.SysUserDo;
import cn.booktable.modules.service.sys.JsonMenuHandler;
import cn.booktable.modules.service.sys.MenuListHandler;
import cn.booktable.modules.service.sys.PermissionNode;
import cn.booktable.modules.service.sys.PermissionNodeHandler;
import cn.booktable.modules.service.sys.SysPermissionService;
import cn.booktable.modules.service.sys.SysRoleService;
import cn.booktable.core.constant.SystemConst;
import cn.booktable.core.page.PageDo;

/**
 * 权限资源.
 * @author ljc
 * @version  v1.0
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl  implements SysPermissionService{

	@Autowired
	private SysPermissionComponent sysPermissionComponent;
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysPlatformComponent sysPlatformComponent;

	/**
	 * 添加权限资源.
	 * @param sysPermission
	 * @return
	 */
	public Integer insertSysPermission(SysPermissionDo sysPermission)
	{
		return sysPermissionComponent.insertSysPermission(sysPermission);
	}

	@Override
	public Integer insertSysPermissionByUser(SysPermissionDo sysPermission,SysUserDo user)
	{
		Integer dbResult=sysPermissionComponent.insertSysPermission(sysPermission);
		if(dbResult>0)
		{
			if(user.getPlatformId()!=null)
			{
				sysPlatformComponent.addPlatformMenu(user.getPlatformId(), sysPermission.getId());
			}
		}
		return dbResult;
	}

	/**
	 * 获取权限资源数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysPermissionDo> querySysPermissionList(Map<String,Object> selectItem)
	{
		return sysPermissionComponent.querySysPermissionList(selectItem);
	}


	/**
	 * 根据Id修改权限资源.
	 * @param sysPermission
	 * @return
	 */
	public Integer updateSysPermissionById(SysPermissionDo sysPermission)
	{
		return sysPermissionComponent.updateSysPermissionById(sysPermission);
	}

	@Override
	public Integer updateSysPermissionBaseInfoById(SysPermissionDo sysPermission) {
		return sysPermissionComponent.updateSysPermissionBaseInfoById(sysPermission);
	}

	/**
	 * 根据Id删除权限资源.
	 * @param id
	 * @return
	 */
	public Integer deleteSysPermissionById(Long id)
	{
		Integer dbResult=sysPermissionComponent.deleteSysPermissionById(id);
		if(dbResult!=null && dbResult>0)
		{
			sysPlatformComponent.deletePlatformMenu(id,null);
		}
		return dbResult;
	}


	/**
	 * 根据Id获取权限资源.
	 * @param id
	 * @return
	 */
	public SysPermissionDo findSysPermissionById(Long id)
	{
		return sysPermissionComponent.findSysPermissionById(id);
	}

	@Override
	public PageDo<SysPermissionDo> queryPermissionListPage(Long pageIndex, Integer pageSize,
			Map<String, Object> selectItem) {
		return sysPermissionComponent.queryPermissionListPage(pageIndex, pageSize, selectItem);
	}

	@Override
	public List<SysPermissionDo> findChildMenuList(Long id) {
		return sysPermissionComponent.findChildMenuList(id);
	}

	@Override
	public <T> List<T> findChildMenuList(MenuListHandler<T> handler, Long id) {
		 List<SysPermissionDo> menuList=sysPermissionComponent.findChildMenuList(id);
		 List<T> result=new ArrayList<T>();
		 if(menuList!=null)
		 {
			 Long pid=id;
			 if(id==null)
			 {
				 pid=0L;
			 }
			 for(int i=0,k=menuList.size();i<k;i++)
			 {
				 SysPermissionDo sysPer=menuList.get(i);
				 if(sysPer.getParentId()!=null && sysPer.getParentId().equals(pid))
				 {
					 T item= handler.handler(sysPer);
					 menuChildProcessor(menuList, sysPer, handler, item);
					 result.add(item);
				 }
			 }
		 }
		return result;
	}

	@Override
	public <T> List<T> findChildMenuListByUser(MenuListHandler<T> handler,Long id,SysUserDo sysUser){
		List<SysPermissionDo> menuList=null;
		if(sysUser.getPlatformId()==null || sysUser.getPlatformId().intValue()==SystemConst.PLATFORM_DEFAULT)
		{
			menuList=sysPermissionComponent.findChildMenuList(id);
		}else {
			menuList=sysPlatformComponent.getChildMenuListByPlatformId(sysUser.getPlatformId(),id);
		}
//		List<SysPermissionDo> menuList=sysPermissionComponent.findChildMenuList(id);
		 List<T> result=new ArrayList<T>();
		 if(menuList!=null)
		 {
			 Long pid=id;
			 if(id==null)
			 {
				 pid=0L;
			 }
			 for(int i=0,k=menuList.size();i<k;i++)
			 {
				 SysPermissionDo sysPer=menuList.get(i);
				 if(sysPer.getParentId()!=null && sysPer.getParentId().equals(pid))
				 {
					 T item= handler.handler(sysPer);
					 menuChildProcessor(menuList, sysPer, handler, item);
					 result.add(item);
				 }
			 }
		 }
		return result;
	}

	/**
	 * 处理子菜单节点链接
	 * @param menuList
	 * 菜单数据列表
	 * @param sysPer
	 * 当前要获取子节点的菜单
	 * @param handler
	 * 菜单转换处理器
	 * @param parentMenu
	 * 当前要获取子节点的菜单转换对象
	 */
	private <T> void menuChildProcessor(List<SysPermissionDo> menuList,SysPermissionDo sysPer, MenuListHandler<T> handler,T parentMenu)
	{
		if(menuList!=null)
		{
			for(int i=0,k=menuList.size();i<k;i++)
			{
				SysPermissionDo item=menuList.get(i);
				if(item.getParentId()!=null && item.getParentId().equals(sysPer.getId()))
				{
					T menu=handler.handler(item);
					menuChildProcessor(menuList, item, handler, menu);
					handler.linkRelations(parentMenu, menu);
				}
			}
		}
	}

	@Override
	public <T> List<T> findUserMenuList(MenuListHandler<T> handler, Integer userId) {
		List<SysPermissionDo> menuList=sysPermissionComponent.getMenuListByUserId(userId);
		 List<T> result=new ArrayList<T>();
		 if(menuList!=null)
		 {
			 Long pid=0L;
			 for(int i=0,k=menuList.size();i<k;i++)
			 {
				 SysPermissionDo sysPer=menuList.get(i);
				 if(sysPer.getParentId()!=null && sysPer.getParentId().equals(pid))
				 {
					 T item= handler.handler(sysPer);
					 menuChildProcessor(menuList, sysPer, handler, item);
					 result.add(item);
				 }
			 }
		 }
		return result;
	}

	@Override
	public <T> List<T> findUserMenuListByUser(MenuListHandler<T> handler, SysUserDo sysUser) {
		List<SysPermissionDo> menuList=null;
		if(sysUser.getPlatformId()==null || sysUser.getPlatformId().intValue()==SystemConst.PLATFORM_DEFAULT)
		{
			menuList=sysPermissionComponent.getMenuListByUserId(sysUser.getId());
		}else {
			menuList=sysPlatformComponent.getMenuListByUserId(sysUser.getId(), sysUser.getPlatformId());
		}
		List<T> result=new ArrayList<T>();
		if(menuList!=null)
		{
			Long pid=0L;
			for(int i=0,k=menuList.size();i<k;i++)
			{
				SysPermissionDo sysPer=menuList.get(i);
				if(sysPer.getParentId()!=null && sysPer.getParentId().equals(pid))
				{
					T item= handler.handler(sysPer);
					menuChildProcessor(menuList, sysPer, handler, item);
					result.add(item);
				}
			}
		}
		return result;
	}


	@Override
	public <T> List<T> findPlatformMenuList(MenuListHandler<T> handler,Integer userId, Integer platformId) {
		List<SysPermissionDo> menuList=sysPlatformComponent.getMenuListByUserId(userId, platformId);
		List<T> result=new ArrayList<T>();
		if(menuList!=null)
		{
			Long pid=0L;
			for(int i=0,k=menuList.size();i<k;i++)
			{
				SysPermissionDo sysPer=menuList.get(i);
				if(sysPer.getParentId()!=null && sysPer.getParentId().equals(pid))
				{
					T item= handler.handler(sysPer);
					menuChildProcessor(menuList, sysPer, handler, item);
					result.add(item);
				}
			}
		}
		return result;
	}

	@Override
	public <T> List<T> findAllPlatformMenuList(MenuListHandler<T> handler, Integer platformId) {
		List<SysPermissionDo> menuList=sysPlatformComponent.getAllMenuListByPlatformId(platformId);
		List<T> result=new ArrayList<T>();
		if(menuList!=null)
		{
			Long pid=0L;
			for(int i=0,k=menuList.size();i<k;i++)
			{
				SysPermissionDo sysPer=menuList.get(i);
				if(sysPer.getParentId()!=null && sysPer.getParentId().equals(pid))
				{
					T item= handler.handler(sysPer);
					menuChildProcessor(menuList, sysPer, handler, item);
					result.add(item);
				}
			}
		}
		return result;
	}

	@Override
	public List<JSONObject> jsonObjectChildMenuList(Long id) {
		List<JSONObject> dataList=findChildMenuList(new JsonMenuHandler(), id);
		return dataList;
	}

	@Override
	public List<JSONObject> jsonObjectChildMenuListByUser(Long id,SysUserDo sysUser)
	{
		List<JSONObject> dataList=findChildMenuListByUser(new JsonMenuHandler(), id, sysUser);
		return dataList;
	}
	@Override
	public List<PermissionNode> findPermissionNode(String roleId) {
		PermissionNodeHandler permissionNodeHandler=new PermissionNodeHandler();
		permissionNodeHandler.setPermissionList( sysRoleService.queryPermissionByRoleId(roleId));
		findChildMenuList(permissionNodeHandler, null);
		return  permissionNodeHandler.getRoot();
	}

	@Override
	public List<PermissionNode> findPermissionNodeByUser(String roleId,SysUserDo sysUser){
		PermissionNodeHandler permissionNodeHandler=new PermissionNodeHandler();
		permissionNodeHandler.setPermissionList( sysRoleService.queryPermissionByRoleIdAndPlatformId(roleId, sysUser.getPlatformId()));
		findChildMenuListByUser(permissionNodeHandler, null, sysUser);
		return  permissionNodeHandler.getRoot();
	}
}
