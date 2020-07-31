package cn.booktable.modules.service.sys.impl;

import org.springframework.stereotype.Service;

import cn.booktable.modules.entity.sys.SysUserDo;
import cn.booktable.modules.service.sys.ConstantUserService;

/**
 * 常量用户
 * @author ljc
 * @version 1.0
 */
@Service("constantUserService")
public class ConstantUserServiceImpl implements ConstantUserService{

	@Override
	public SysUserDo autoLoanUser() {
		SysUserDo sysUser=new SysUserDo();
		sysUser.setRealName("system");
		sysUser.setId(-100);
		sysUser.setUserName("system");
		return sysUser;
	}

}
