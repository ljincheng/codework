/**
 * Project Name:jcpt-common <br>
 * File Name:CityInfoServiceImpl.java <br>
 * Package Name:com.hehenian.jcpt.service.system.impl <br>
 * @author anxymf
 * Date:2017年1月9日上午9:25:44 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.service.sys.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.booktable.modules.component.sys.DictCityInfoComponent;
import cn.booktable.modules.entity.sys.DictCityInfoDo;
import cn.booktable.modules.service.sys.DictCityInfoService;

/**
 * ClassName: CityInfoServiceImpl <br>
 * Description: TODO
 * @author anxymf
 * Date:2017年1月9日上午9:25:44 <br>
 * @version
 * @since JDK 1.6
 */
@Service("dictCityInfoService")
public class DictCityInfoServiceImpl implements DictCityInfoService {

	@Resource
	private DictCityInfoComponent dictCityInfoComponent;

	@Override
	public List<DictCityInfoDo> queryProvince() {
		return dictCityInfoComponent.queryProvince();
	}

	@Override
	public List<DictCityInfoDo> queryCityByProvince(String cityCode) {
		return dictCityInfoComponent.queryCityByProvince(cityCode);
	}

}

