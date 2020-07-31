/**
 * Project Name:jcpt-common <br>
 * File Name:ParamService.java <br>
 * Package Name:com.hehenian.jcpt.service.system <br>
 * @author anxymf
 * Date:2017年1月11日上午11:14:51 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.service.sys;

import java.util.Map;

import cn.booktable.modules.entity.sys.ParamDo;
import cn.booktable.core.page.PageDo;

/**
 * ClassName: ParamService <br>
 * Description: 系统参数
 * @author anxymf
 * Date:2017年1月11日上午11:14:51 <br>
 * @version
 * @since JDK 1.6
 */
public interface ParamService {

	Integer insert(ParamDo paramDo);

	Integer update(ParamDo paramDo);

	Integer delete(String paramId);

	ParamDo queryById(String paramId);

	/**
	 * 根据编号找参数
	 * @param paramCode
	 * @return
	 */
	ParamDo queryByCode(String paramCode);

	PageDo<ParamDo> queryListPage(Map<String, Object> selectItem);

	String queryValueByCode(String paramCode);
}

