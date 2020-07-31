package cn.booktable.modules.dao.sys;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import cn.booktable.modules.entity.sys.SysUserDo;
import cn.booktable.modules.entity.sys.SysUserRoleDo;

/**
 * 用户与角色关系.
 * @author ljc
 * @version  v1.0
 */
@Mapper
public interface SysUserRoleDao{

	/**
	 * 添加用户与角色关系.
	 * @param sysUserRole
	 * @return
	 */
	public Integer insert(SysUserRoleDo sysUserRole);

	/**
	 * 获取用户与角色关系数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysUserRoleDo> queryList(Map<String,Object> selectItem);


	/**
	 * 根据Id修改用户与角色关系.
	 * @param sysUserRole
	 * @return
	 */
	public Integer updateById(SysUserRoleDo sysUserRole);

	/**
	 * 根据Id删除用户与角色关系.
	 * @param id
	 * @return
	 */
	public Integer deleteById(String id);

	/**
	 * 根据Id获取用户与角色关系.
	 * @param id
	 * @return
	 */
	public SysUserRoleDo findById(String id);

	/**
	 * 根据角色ID获取用户集
	 * @param selectItem 过滤条件
	 * @return
	 */
	public List<SysUserDo> queryUserByRoleIdListPage(Map<String, Object> selectItem);

	/**
	 * 查询不属于角色ID列表的用户集
	 * @param selectItem
	 * @return
	 */
	public List<SysUserDo> queryUserNoInRoleIdListPage(Map<String, Object> selectItem);
}
