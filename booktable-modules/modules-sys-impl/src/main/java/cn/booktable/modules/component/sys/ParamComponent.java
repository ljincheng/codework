/**
 * Project Name:jcpt-common <br>
 * File Name:ParamComponent.java <br>
 * Package Name:com.eic.jcpt.component.system <br>
 * @author anxymf
 * Date:2017年1月11日上午11:15:39 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.component.sys;

import java.util.Map;

import cn.booktable.modules.entity.sys.ParamDo;
import cn.booktable.core.page.PageDo;

/**
 * ClassName: ParamComponent <br>
 * Description: TODO
 * @author anxymf
 * Date:2017年1月11日上午11:15:39 <br>
 * @version
 * @since JDK 1.6
 */
public interface ParamComponent {

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

