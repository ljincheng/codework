package cn.booktable.modules.component.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.SysUserDo;
import cn.booktable.core.page.PageDo;

/**
 * 系统用户.
 * @author ljc
 * @version  v1.0
 */
public interface SysUserComponent {

	/**
	 * 添加系统用户.
	 * @param sysUser
	 * @return
	 */
	public Integer insertSysUser(SysUserDo sysUser);

	/**
	 * 获取系统用户数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysUserDo> querySysUserList(Map<String,Object> selectItem);

	/**
	 * 获取系统用户数据集
	 * @param pageIndex
	 * 起始页
	 * @param pageSize
	 * 每页记录数
	 * @param selectItem
	 * 过滤条件
	 * @return
	 */
	public PageDo<SysUserDo> querySysUserListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem);

	/**
	 * 根据Id修改系统用户.
	 * @param sysUser
	 * @return
	 */
	public Integer updateSysUserById(SysUserDo sysUser);

	/**
	 * 根据Id删除系统用户.
	 * @param id
	 * @return
	 */
	public Integer deleteSysUserById(Integer id);

	/**
	 * 修改用户锁
	 * @param id
	 * @param isLock
	 * @return
	 */
	public Integer updateLockStatus(Integer id,Boolean isLock);

	/**
	 * 根据Id获取系统用户.
	 * @param id
	 * @return
	 */
	public SysUserDo findSysUserById(Integer id);

	/**
	 * 根据用户名获取系统用户
	 * @param userName
	 * 用户名
	 * @return
	 */
	public SysUserDo findSysUserByUserName(String userName);

	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	public Integer resetPassword(SysUserDo user);

	/**
	 * 修改用户拥有的角色
	 * @param roles
	 * 角色数组
	 * @param userId
	 * 用户ID
	 * @return
	 */
	public Integer modifyUserRoles(String[] roles,Integer userId);


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
	 * 恢复用户ID
	 * @param userId
	 * @return
	 */
	public Integer recoverUserStatusById(Integer userId);
}
