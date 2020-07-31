package cn.booktable.modules.component.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.SysPermissionDo;
import cn.booktable.modules.entity.sys.SysPlatformDo;
import cn.booktable.core.page.PageDo;

/**
 * 系统平台.
 * @author ljc
 * @version  v1.0
 */
public interface SysPlatformComponent {

	/**
	 * 添加系统平台.
	 * @param sysPlatform
	 * @return
	 */
	public Integer insertSysPlatform(SysPlatformDo sysPlatform);

	/**
	 * 获取系统平台数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysPlatformDo> querySysPlatformList(Map<String,Object> selectItem);

	/**
	 * 获取系统平台数据集
	 * @param pageIndex
	 * 起始页
	 * @param pageSize
	 * 每页记录数
	 * @param selectItem
	 * 过滤条件
	 * @return
	 */
	public PageDo<SysPlatformDo> querySysPlatformListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem);

	/**
	 * 根据Id修改系统平台.
	 * @param sysPlatform
	 * @return
	 */
	public Integer updateSysPlatformById(SysPlatformDo sysPlatform);

	/**
	 * 根据Id删除系统平台.
	 * @param id
	 * @return
	 */
	public Integer deleteSysPlatformById(Integer id);

	/**
	 * 根据Id获取系统平台.
	 * @param id
	 * @return
	 */
	public SysPlatformDo findSysPlatformById(Integer id);

	/**
	 * 根据用户ID获取平台菜单
	 * @param userId 用户ID
	 * @param platformId 平台ID
	 * @return
	 */
	public List<SysPermissionDo> getMenuListByUserId(Integer userId,Integer platformId);

	/**
	 * 根据平台ID获取菜单列表
	 * @param platformId 平台ID
	 * @param menuId 菜单ID
	 * @return
	 */
	public List<SysPermissionDo> getChildMenuListByPlatformId(Integer platformId,Long menuId);

	/**
	 * 根据平台ID获取菜单
	 * @param platformId
	 * @return
	 */
	public List<SysPermissionDo> getAllMenuListByPlatformId(Integer platformId);

	/**
	 * 增加平台菜单
	 * @param platformId 平台ID
	 * @param menuId 菜单ID
	 * @return
	 */
	public Integer addPlatformMenu(Integer platformId,Long menuId);

	/**
	 * 删除平台菜单
	 * @param menuId
	 * @param platformId
	 * @return
	 */
	public Integer deletePlatformMenu(Long menuId,Integer platformId);
}
