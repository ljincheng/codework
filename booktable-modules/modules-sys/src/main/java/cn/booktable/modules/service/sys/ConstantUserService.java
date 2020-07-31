package cn.booktable.modules.service.sys;

import cn.booktable.modules.entity.sys.SysUserDo;

/**
 * 系统定议了的用户
 * @author ljc
 * @version 1.0
 */
public interface ConstantUserService {

	/**
	 * 自动标的操作用户
	 * @return
	 */
	SysUserDo autoLoanUser();
}
