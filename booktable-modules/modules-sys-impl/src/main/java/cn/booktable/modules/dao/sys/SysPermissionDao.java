package cn.booktable.modules.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import cn.booktable.modules.entity.sys.SysPermissionDo;

/**
 * 权限资源.
 * @author ljc
 * @version  v1.0
 */
@Mapper
public interface SysPermissionDao{

	/**
	 * 添加权限资源.
	 * @param sysPermission
	 * @return
	 */
	public Integer insert(SysPermissionDo sysPermission);

	/**
	 * 获取ID最大值
	 * @return
	 */
	public Long getMaxId();

	/**
	 * 获取权限资源数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysPermissionDo> queryList(Map<String,Object> selectItem);


	/**
	 * 根据Id修改权限资源.
	 * @param sysPermission
	 * @return
	 */
	public Integer updateById(SysPermissionDo sysPermission);

	/**
	 * 修改基本信息
	 * 除了树节点关系外，其他字段可以修改
	 * @param sysPermission
	 * @return
	 */
	public Integer updateBaseInfoById(SysPermissionDo sysPermission);

	/**
	 * 根据Id删除权限资源.
	 * @param id
	 * @return
	 */
	public Integer deleteById(Long id);

	/**
	 * 根据路径删除权限资源
	 * @param path
	 * 路径
	 * @return
	 */
	public Integer deleteByPath(String path);

	/**
	 * 根据Id获取权限资源.
	 * @param id
	 * @return
	 */
	public SysPermissionDo findById(Long id);

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
	 * @param selectItem
	 * 过滤条件
	 * @return
	 */
	public List<SysPermissionDo> queryListPage(Map<String,Object> selectItem);

	/**
	 * 获取菜单ID的子菜单列表
	 * @param id
	 * 菜单ID
	 * @return
	 */
	public List<SysPermissionDo> findChildMenuList(@Param("id") Long id);
}
