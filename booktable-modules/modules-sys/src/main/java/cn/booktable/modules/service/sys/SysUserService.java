package cn.booktable.modules.service.sys;
import java.util.List;
import java.util.Map;
import java.util.Date;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.sys.SysPermissionDo;
import cn.booktable.modules.entity.sys.SysUserDo;

/**
 *
 * @author sys
 * @version v1.0
 */
public interface SysUserService {

    /**
     * 添加系统用户.
     * @param sysUser
     * @return
     */
    public int insertSysUser(SysUserDo sysUser);

    /**
     * 添加系统用户(含角色)
     * @param sysUser
     * @param roleIds 角色ID
     * @return
     */
    public int registerSysUser(SysUserDo sysUser,String[] roleIds);

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
    public int updateSysUserById(SysUserDo sysUser);

    /**
     * 根据Id删除系统用户.
     * @param id
     * @return
     */
    public int deleteSysUserById(Integer id);

    /**
     * 修改用户锁
     * @param id 用户ID
     * @param isLock 是否锁定
     * @return
     */
    public Integer updateUserLockStatus(Integer id,Boolean isLock);

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
     * 根据用户ID获取菜单
     * @param userId
     * @return
     */
    public List<SysPermissionDo> getMenuListByUserId(Integer userId);

    /**
     * 根据用户ID获取用户权限代码。
     * @param userId
     * 用户ID
     * @return
     */
    public List<SysPermissionDo> getPermissionCodeListByUserId(Integer userId);

    /**
     * 根据用户ID获取用户权限代码字符串列表。
     * @param userId
     * 用户ID
     * @return
     */
    public List<String> getPermissionCodeStrListByUserId(Integer userId);

    /**
     * 根据用户ID获取角色字符串。
     * @param userid
     * 用户ID
     * @return
     */
    public List<String> getRoleStrListByUserId(Integer userId);

    /**
     * 修改密码
     * @param userId
     * 用户ID
     * @param password
     * 用户密码
     * @return
     */
    public int resetPassword(Integer userId,String password,Date modifyPwdTime);

    /**
     * 修改用户拥有的角色
     * @param roles
     * 角色数组
     * @param userId
     * 用户ID
     * @return
     */
    public int modifyUserRoles(String[] roles,Integer userId);


    /**
     * 根据角色ID获取用户集
     * @param roleId 角色ID
     * @param pageIndex 起始页
     * @param pageSize 每页记录数
     * @param selectItem 过滤条件
     * @return
     */
    public PageDo<SysUserDo> queryUserByRoleIdListPage(String roleId,Long pageIndex,Integer pageSize,Map<String, Object> selectItem);

    /**
     * 获取不包含角色ID列表的用户集
     * @param roleIdList 角色ID列表
     * @param pageIndex
     * @param pageSize
     * @param selectItem
     * @return
     */
    public PageDo<SysUserDo> queryUserNoInRoleIdListPage(String[] roleIdList,Long pageIndex,Integer pageSize,Map<String, Object> selectItem);

    /**
     * 增加用户角色
     * @param userId
     * @param roleId
     * @return
     */
    public Integer addUserRoleId(Integer userId,String roleId);


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
