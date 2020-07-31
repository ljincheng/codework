package cn.booktable.modules.component.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.SysPermissionDo;
import cn.booktable.core.page.PageDo;

/**
 * 权限资源.
 * @author ljc
 * @version  v1.0
 */
public interface SysPermissionComponent {

	/**
	 * 添加权限资源.
	 * @param sysPermission
	 * @return
	 */
	public Integer insertSysPermission(SysPermissionDo sysPermission);

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
	 * 除了树关系相关字段（id,parentId),其他的可以修改。
	 * @param sysPermission
	 * 权限资源
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
	 * 根据用户ID获取菜单。
	 * @param userId
	 * 用户ID
	 * @return
	 */
	public List<SysPermissionDo> getMenuListByUserId(Integer userId);

	/**
	 * 根据用户ID获取用户权限代码。
	 * @param userId
	 * 用户ID
	 * @return
	 */
	public List<SysPermissionDo> getCodeListByUserId(Integer userId);

	/**
	 * 根据用户ID获取用户权限代码字符串列表。
	 * @param userId
	 * 用户ID
	 * @return
	 */
	public List<String> getCodeStrListByUserId(Integer userId);

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
	 * 获取菜单ID的子菜单，如果获取全部菜单，参数ID设置空值。
	 * @param id
	 * 菜单ID
	 * @return
	 */
	public List<SysPermissionDo> findChildMenuList(Long id);
}
