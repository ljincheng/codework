/**
 * Project Name:jcpt-common <br>
 * File Name:ParamServiceImpl.java <br>
 * Package Name:com.eic.jcpt.service.system.impl <br>
 * @author anxymf
 * Date:2017年1月11日上午11:15:16 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.service.sys.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.booktable.modules.component.sys.ParamComponent;
import cn.booktable.modules.entity.sys.ParamDo;
import cn.booktable.modules.service.sys.ParamService;
import cn.booktable.core.page.PageDo;
import cn.booktable.util.AssertUtils;

/**
 * ClassName: ParamServiceImpl <br>
 * Description: TODO
 * @author anxymf
 * Date:2017年1月11日上午11:15:16 <br>
 * @version
 * @since JDK 1.6
 */
@Service("paramService")
public class ParamServiceImpl implements ParamService {

	@Resource
	private ParamComponent paramComponent;

	@Override
	public Integer insert(ParamDo paramDo) {
		AssertUtils.isNotBlank(paramDo.getParamName(),"参数名称不能为空");
		AssertUtils.isNotBlank(paramDo.getParamCode(),"参数编码不能为空");
		AssertUtils.isNotBlank(paramDo.getParamValue(),"参数值不能为空");
		AssertUtils.isNotBlank(paramDo.getIsValid(),"参数是否有效不能为空");
		return paramComponent.insert(paramDo);
	}

	@Override
	public Integer update(ParamDo paramDo) {
		AssertUtils.isNotBlank(paramDo.getParamName(),"参数名称不能为空");
		AssertUtils.isNotBlank(paramDo.getParamCode(),"参数编码不能为空");
		AssertUtils.isNotBlank(paramDo.getParamValue(),"参数值不能为空");
		AssertUtils.isNotBlank(paramDo.getIsValid(),"参数是否有效不能为空");
		return paramComponent.update(paramDo);
	}

	@Override
	public Integer delete(String paramId) {
		return paramComponent.delete(paramId);
	}

	@Override
	public ParamDo queryById(String paramId) {
		return paramComponent.queryById(paramId);
	}

	@Override
	public ParamDo queryByCode(String paramCode) {
		return paramComponent.queryByCode(paramCode);
	}

	@Override
	public PageDo<ParamDo> queryListPage(Map<String, Object> selectItem) {
		return paramComponent.queryListPage(selectItem);
	}

	@Override
	public String queryValueByCode(String paramCode) {
		return paramComponent.queryValueByCode(paramCode);
	}

}

