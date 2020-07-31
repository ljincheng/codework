package cn.booktable.modules.service.sys;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import cn.booktable.modules.entity.sys.SysPermissionDo;
import cn.booktable.modules.entity.sys.SysUserDo;
import cn.booktable.core.page.PageDo;

/**
 * 权限资源.
 * @author ljc
 * @version  v1.0
 */
public interface SysPermissionService {

	/**
	 * 添加权限资源.
	 * @param sysPermission
	 * @return
	 */
	public Integer insertSysPermission(SysPermissionDo sysPermission);

	/**
	 * 根据操作用户保存权限
	 * @param sysPermission
	 * @param user
	 * @return
	 */
	public Integer insertSysPermissionByUser(SysPermissionDo sysPermission,SysUserDo user);

	/**
	 * 获取权限资源数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysPermissionDo> querySysPermissionList(Map<String,Object> selectItem);


	/**
	 * 根据Id修改权限资源.
	 * @param sysPermission
	 * @return
	 */
	public Integer updateSysPermissionById(SysPermissionDo sysPermission);

	/**
	 * 修改权限资源基本信息
	 * 除了树关系相关字段（id,parentId)外，其他字段都可以修改。
	 * @param sysPermission
	 * @return
	 */
	public Integer updateSysPermissionBaseInfoById(SysPermissionDo sysPermission);

	/**
	 * 根据Id删除权限资源.
	 * @param id
	 * @return
	 */
	public Integer deleteSysPermissionById(Long id);

	/**
	 * 根据Id获取权限资源.
	 * @param id
	 * @return
	 */
	public SysPermissionDo findSysPermissionById(Long id);


	/**
	 * 获取权限资源数据分页
	 * @param pageIndex
	 * 起始页
	 * @param pageSize
	 * 每页记录数
	 * @param selectItem
	 * 过滤条件
	 * @return
	 */
	public PageDo<SysPermissionDo> queryPermissionListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem);

	/**
	 * 获取菜单ID的子菜单，如果是全部菜单则参数设置为空。
	 * @param id
	 * 菜单ID
	 * @return
	 */
	public List<SysPermissionDo> findChildMenuList(Long id);

	/**
	 * 获取菜单ID的子菜单数据对象
	 * @param type
	 * 获取的数据对象类型
	 * @param id
	 * 菜单ID
	 * @return
	 */
	public <T> List<T> findChildMenuList(MenuListHandler<T> handler,Long id);

	/**
	 * 获取菜单ID的子菜单数据对象
	 * @param handler
	 * @param permissionId 菜单ID
	 * @param sysUser 用户
	 * @return
	 */
	public <T> List<T> findChildMenuListByUser(MenuListHandler<T> handler,Long permissionId,SysUserDo sysUser);

	/**
	 * 获取权限节点数据
	 * @param roleId 节点ID
	 * @return
	 */
	public List<PermissionNode> findPermissionNode(String roleId);

	/**
	 * 根据用户和角色ＩＤ获取权限
	 * @param roleId　角色ＩＤ
	 * @param sysUser　用户
	 * @return
	 */
	public List<PermissionNode> findPermissionNodeByUser(String roleId,SysUserDo sysUser);

	/**
	 * 获取菜单为JSONObject数据列表
	 * @param id 菜单ID
	 * @return
	 */
	public List<JSONObject> jsonObjectChildMenuList(Long id);

	/**
	 * 根据菜单、用户获取JSONObject数据列表
	 * @param id 菜单ID
	 * @param sysUser 用户
	 * @return
	 */
	public List<JSONObject> jsonObjectChildMenuListByUser(Long id,SysUserDo sysUser);

	/**
	 * 获取用户菜单数据
	 * @param handler 处理方法
	 * @param userId 用户ID
	 * @return
	 */
	public <T> List<T> findUserMenuList(MenuListHandler<T> handler,Integer userId);

	/**
	 * 获取用户菜单数据
	 * @param handler 处理方法
	 * @param sysUser 用户
	 * @return
	 */
	public <T> List<T> findUserMenuListByUser(MenuListHandler<T> handler, SysUserDo sysUser);

	/**
	 * 获取平台菜单
	 * @param handler
	 * @param userId 用户ID
	 * @param platformId 平台ID
	 * @param <T>
	 * @return
	 */
	public <T> List<T> findPlatformMenuList(MenuListHandler<T> handler,Integer userId, Integer platformId);

	/**
	 * 获取平台全部菜单
	 * @param handler
	 * @param userId
	 * @param platformId
	 * @param <T>
	 * @return
	 */
	public <T> List<T> findAllPlatformMenuList(MenuListHandler<T> handler,Integer platformId);
}
