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

import cn.booktable.modules.entity.sys.SysParamDo;
import org.springframework.stereotype.Service;

import cn.booktable.modules.component.sys.SysParamComponent;
import cn.booktable.modules.service.sys.SysParamService;
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
@Service("sysParamService")
public class SysParamServiceImpl implements SysParamService {

	@Resource
	private SysParamComponent sysParamComponent;

	@Override
	public Integer insert(SysParamDo sysParamDo) {
		AssertUtils.isNotBlank(sysParamDo.getParamName(),"参数名称不能为空");
		AssertUtils.isNotBlank(sysParamDo.getParamCode(),"参数编码不能为空");
		AssertUtils.isNotBlank(sysParamDo.getParamValue(),"参数值不能为空");
		AssertUtils.isNotBlank(sysParamDo.getIsValid(),"参数是否有效不能为空");
		return sysParamComponent.insert(sysParamDo);
	}

	@Override
	public Integer update(SysParamDo sysParamDo) {
		AssertUtils.isNotBlank(sysParamDo.getParamName(),"参数名称不能为空");
		AssertUtils.isNotBlank(sysParamDo.getParamCode(),"参数编码不能为空");
		AssertUtils.isNotBlank(sysParamDo.getParamValue(),"参数值不能为空");
		AssertUtils.isNotBlank(sysParamDo.getIsValid(),"参数是否有效不能为空");
		return sysParamComponent.update(sysParamDo);
	}

	@Override
	public Integer delete(String paramId) {
		return sysParamComponent.delete(paramId);
	}

	@Override
	public SysParamDo queryById(String paramId) {
		return sysParamComponent.queryById(paramId);
	}

	@Override
	public SysParamDo queryByCode(String paramCode) {
		return sysParamComponent.queryByCode(paramCode);
	}

	@Override
	public PageDo<SysParamDo> queryListPage(Map<String, Object> selectItem) {
		return sysParamComponent.queryListPage(selectItem);
	}

	@Override
	public String queryValueByCode(String paramCode) {
		return sysParamComponent.queryValueByCode(paramCode);
	}

}

