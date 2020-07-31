package cn.booktable.modules.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.booktable.modules.entity.sys.SysRoleDo;

/**
 * 角色.
 * @author ljc
 * @version  v1.0
 */
@Mapper
public interface SysRoleDao{

	/**
	 * 添加角色.
	 * @param sysRole
	 * @return
	 */
	public Integer insert(SysRoleDo sysRole);

	/**
	 * 获取角色数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysRoleDo> queryList(Map<String,Object> selectItem);

	/**
	 * 获取角色数据分页列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysRoleDo> queryListPage(Map<String,Object> selectItem);

	/**
	 * 根据Id修改角色.
	 * @param sysRole
	 * @return
	 */
	public Integer updateById(SysRoleDo sysRole);

	/**
	 * 根据Id删除角色.
	 * @param id
	 * @return
	 */
	public int deleteById(String id);

	/**
	 * 根据Id获取角色.
	 * @param id
	 * @return
	 */
	public SysRoleDo findById(String id);

	/**
	 * 根据角色名称获取角色
	 * @param name
	 * 角色名称
	 * @return
	 */
	public SysRoleDo findByName(String name);

	/**
	 * 根据用户ID获取角色字符串。
	 * @param userid
	 * 用户ID
	 * @return
	 */
	public List<String> getNameListByUserId(Integer userId);

	/**
	 * 获取角色列表（包含用户已有角色信息）
	 * @param userId
	 * 用户ID
	 * @return
	 */
	public List<SysRoleDo> getRoleListWithUserId(Integer userId);

}
