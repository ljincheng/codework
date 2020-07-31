package cn.booktable.modules.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import cn.booktable.modules.entity.sys.SysPermissionDo;
import cn.booktable.modules.entity.sys.SysPlatformDo;
import cn.booktable.modules.entity.sys.SysPlatformMenuDo;

/**
 * 系统平台.
 * @author ljc
 * @version  v1.0
 */
@Mapper
public interface SysPlatformDao{

	/**
	 * 添加系统平台.
	 * @param sysPlatform
	 * @return
	 */
	public Integer insert(SysPlatformDo sysPlatform);

	/**
	 * 获取系统平台数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysPlatformDo> queryList(Map<String,Object> selectItem);

	/**
	 * 获取系统平台数据分页列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysPlatformDo> queryListPage(Map<String,Object> selectItem);


	/**
	 * 根据Id修改系统平台.
	 * @param sysPlatform
	 * @return
	 */
	public Integer updateById(SysPlatformDo sysPlatform);

	/**
	 * 根据Id删除系统平台.
	 * @param id
	 * @return
	 */
	public Integer deleteById(Integer id);

	/**
	 * 根据Id获取系统平台.
	 * @param id
	 * @return
	 */
	public SysPlatformDo findById(Integer id);


	/**
	 * 根据用户ID获取菜单。
	 * @param userId 用户ID
	 * @param platformId 平台ID
	 * 用户ID
	 * @return
	 */
	public List<SysPermissionDo> getMenuListByUserId(@Param("userId")Integer userId,@Param("platformId")Integer platformId);

	/**
	 * 根据平台ID获取菜单
	 * @param platformId
	 * @return
	 */
	public List<SysPermissionDo> getAllMenuListByPlatformId(@Param("platformId")Integer platformId);

	/**
	 * 根据平台获取菜单
	 * @param platformId 平台ID
	 * @param menuId 菜单ID
	 * @return
	 */
	public List<SysPermissionDo> getChildMenuListByPlatformId(@Param("platformId")Integer platformId,@Param("menuId")Long menuId);

	/**
	 * 增加平台菜单
	 * @param platformMenu 平台菜单
	 * @return
	 */
	public Integer addPlatformMenu(SysPlatformMenuDo platformMenu);

	/**
	 * 查询平台菜单
	 * @param platformMenu 平台菜单，platformId必填
	 * @return
	 */
	public List<SysPlatformMenuDo> queryPlatformMenuList(SysPlatformMenuDo platformMenu);

	/**
	 *  删除平台菜单
	 * @param menuId
	 * @param platformId
	 * @return
	 */
	public Integer deletePlatformMenu(@Param("menuId")Long menuId,@Param("platformId")Integer platformId);
}
