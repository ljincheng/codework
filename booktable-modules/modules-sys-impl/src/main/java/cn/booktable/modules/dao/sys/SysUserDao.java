package cn.booktable.modules.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.booktable.modules.entity.sys.SysUserDo;
import cn.booktable.modules.entity.sys.SysUserRoleDo;

/**
 * 系统用户.
 * @author ljc
 * @version  v1.0
 */
@Mapper
public interface SysUserDao{

	/**
	 * 添加系统用户.
	 * @param sysUser
	 * @return
	 */
	public Integer insert(SysUserDo sysUser);

	/**
	 * 获取系统用户数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysUserDo> queryList(Map<String,Object> selectItem);

	/**
	 * 获取系统用户数据分页列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysUserDo> queryListPage(Map<String,Object> selectItem);

	/**
	 * 根据Id修改系统用户.
	 * @param sysUser
	 * @return
	 */
	public Integer updateById(SysUserDo sysUser);

	/**
	 * 根据Id删除系统用户.
	 * @param id
	 * @return
	 */
	public Integer deleteById(Integer id);

	/**
	 * 修改用户锁定状态
	 * @param id
	 * @param locked
	 * @return
	 */
	public Integer updateLockStatus(@Param("id")Integer id,@Param("locked") Integer locked);

	/**
	 * 根据Id获取系统用户.
	 * @param id
	 * @return
	 */
	public SysUserDo findById(Integer id);


	/**
	 * 根据用户名获取系统用户
	 * @param userName
	 * 用户名
	 * @return
	 */
	public SysUserDo findByUserName(String userName);

	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	public Integer resetPassword(SysUserDo user);

	/**
	 * 删除用户拥有角色
	 * @param userId
	 * 用户ID
	 * @return
	 */
	public Integer deleteUserRolesByUserId(Integer userId);

	/**
	 * 添加用户角
	 * @param userRole
	 * @return
	 */
	public Integer insertUserRoles(SysUserRoleDo userRole);

	/**
	 * 根据用户ID更新用户登录错误次数
	 * @param sysUser
	 * @return
	 */
	public Integer updateLoginExcessiveAttemptsByUserId(SysUserDo sysUser);

	/**
	 * 更新用户PHOTO
	 * @param sysUser
	 * @return
	 */
	public Integer updateUserPhoto(SysUserDo sysUser);

	/**
	 * 更新用户的背景图
	 * @param sysUserDo
	 * @return
	 */
	public Integer updateUserWallPhoto(SysUserDo sysUserDo);

	/**
	 * 恢复用户状态
	 * @param sysUserDo
	 * @return
	 */
	public Integer recoverUserStatusById(Integer id);
}
