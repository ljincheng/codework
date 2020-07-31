/**
 * Project Name:jcpt-common <br>
 * File Name:AppProcessDao.java <br>
 * Package Name:com.hehenian.jcpt.dao.system <br>
 * @author anxymf
 * Date:2017年8月7日下午5:22:55 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.booktable.modules.entity.sys.AppRoleDo;
import cn.booktable.modules.entity.sys.ProcessInfoDo;
import cn.booktable.modules.entity.sys.SysUserDo;

/**
 * ClassName: AppProcessDao <br>
 * Description: TODO
 * @author anxymf
 * Date:2017年8月7日下午5:22:55 <br>
 * @version
 * @since JDK 1.6
 */
@Mapper
public interface AppProcessDao {

	List<SysUserDo> queryListPage(Map<String, Object> selectItem);

	List<ProcessInfoDo> queryList();

	List<String> queryProcessIdsByUserId(Long userId);

	int delete(Long userId);

	int insert(AppRoleDo appRole);



}

