package cn.booktable.modules.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import cn.booktable.modules.entity.sys.SysPermissionDo;
import cn.booktable.modules.entity.sys.SysRolePermissionDo;

/**
 * 角色权限关系表.
 * @author ljc
 * @version  v1.0
 */
@Mapper
public interface SysRolePermissionDao{

	/**
	 * 添加角色权限关系表.
	 * @param sysRolePermission
	 * @return
	 */
	public Integer insert(SysRolePermissionDo sysRolePermission);

	/**
	 * 获取角色权限关系表数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysRolePermissionDo> queryList(Map<String,Object> selectItem);


	/**
	 * 根据Id修改角色权限关系表.
	 * @param sysRolePermission
	 * @return
	 */
	public Integer updateById(SysRolePermissionDo sysRolePermission);

	/**
	 * 根据Id删除角色权限关系表.
	 * @param id
	 * @return
	 */
	public Integer deleteById(String id);

	/**
	 * 根据Id获取角色权限关系表.
	 * @param id
	 * @return
	 */
	public SysRolePermissionDo findById(String id);

	/**
	 * 删除角色权限
	 * @param id 角色ID
	 * @return
	 */
	public Integer deletePermissionsByRoleId(String roleId);


	/**
	 * 根据角色ID获取权限集
	 * @param roleId 角色ID
	 * @return
	 */
	public List<SysPermissionDo> getPermissionByRoleId(String roleId);

	/**
	 * 根据平台ID和我
	 * @param roleId　角色ID
	 * @param platformId　平台ID
	 * @return
	 */
	public List<SysPermissionDo> getPermissionByRoleIdAndPlatformId(@Param("roleId")String roleId,@Param("platformId")Integer platformId);
}
