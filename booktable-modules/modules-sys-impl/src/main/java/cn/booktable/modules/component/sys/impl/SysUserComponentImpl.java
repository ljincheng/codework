package cn.booktable.modules.component.sys.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.booktable.toolkit.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.modules.component.sys.SysUserComponent;
import cn.booktable.modules.dao.sys.SysUserDao;
import cn.booktable.modules.entity.sys.SysUserDo;
import cn.booktable.modules.entity.sys.SysUserRoleDo;
import cn.booktable.core.page.PageDo;
import cn.booktable.util.StringUtils;

/**
 * 系统用户.
 * @author ljc
 * @version  v1.0
 */
@Component("sysUserComponent")
public class SysUserComponentImpl  implements SysUserComponent{

	@Autowired
	private SysUserDao sysUserDao;

	/**
	 * 添加系统用户.
	 * @param sysUser
	 * @return
	 */
	public Integer insertSysUser(SysUserDo sysUser)
	{
		return sysUserDao.insert(sysUser);
	}

	/**
	 * 获取系统用户数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysUserDo> querySysUserList(Map<String,Object> selectItem)
	{
		return sysUserDao.queryList(selectItem);
	}


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
	public PageDo<SysUserDo> querySysUserListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem)
	{
		 if(selectItem==null)
		 {
			 selectItem=new HashMap<String,Object>();
		 }
		 PageDo<SysUserDo> pageBean=new PageDo<SysUserDo>(pageIndex, pageSize);
		 selectItem.put("page", pageBean);
		 pageBean.setPage(sysUserDao.queryListPage(selectItem));
		return pageBean;
	}


	/**
	 * 根据Id修改系统用户.
	 * @param sysUser
	 * @return
	 */
	public Integer updateSysUserById(SysUserDo sysUser)
	{
		return sysUserDao.updateById(sysUser);
	}

	/**
	 * 根据Id删除系统用户.
	 * @param id
	 * @return
	 */
	public Integer deleteSysUserById(Integer id)
	{
		return sysUserDao.deleteById(id);
	}

	@Override
	public Integer updateLockStatus(Integer id,Boolean isLock)
	{
		return sysUserDao.updateLockStatus(id,isLock?2:1);
	}

	/**
	 * 根据Id获取系统用户.
	 * @param id
	 * @return
	 */
	public SysUserDo findSysUserById(Integer id)
	{
		return sysUserDao.findById(id);
	}

	@Override
	public SysUserDo findSysUserByUserName(String userName) {
		return sysUserDao.findByUserName(userName);
	}

	@Override
	public Integer resetPassword(SysUserDo user) {
		user.setUpdateTime(new Date());
		return sysUserDao.resetPassword(user);
	}

	@Override
	public Integer modifyUserRoles(String[] roles, Integer userId) {
		if(userId!=null)
		{
			sysUserDao.deleteUserRolesByUserId(userId);
			if(roles!=null && roles.length>0)
			{
				for(String role:roles)
				{
					SysUserRoleDo userRole=new SysUserRoleDo();
					userRole.setId(IdWorker.getIdStr());
					userRole.setUserId(userId);
					userRole.setRoleId(role);
					sysUserDao.insertUserRoles(userRole);
				}
			}
			return 1;
		}else{
			return 0;
		}
	}

	@Override
	public Integer updateLoginExcessiveAttemptsByUserId(SysUserDo sysUser) {
		return sysUserDao.updateLoginExcessiveAttemptsByUserId(sysUser);
	}


	@Override
	public Integer updateUserPhoto(SysUserDo sysUser){
		return sysUserDao.updateUserPhoto(sysUser);
	}

	@Override
	public Integer updateUserWallPhoto(SysUserDo sysUserDo) {
		return sysUserDao.updateUserWallPhoto(sysUserDo);
	}

	@Override
	public Integer recoverUserStatusById(Integer userId) {
		return sysUserDao.recoverUserStatusById(userId);
	}
}
