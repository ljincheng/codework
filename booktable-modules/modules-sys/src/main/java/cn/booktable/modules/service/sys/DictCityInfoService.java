/**
 * Project Name:jcpt-common <br>
 * File Name:CityInfoService.java <br>
 * Package Name:com.hehenian.jcpt.service.system <br>
 * @author anxymf
 * Date:2017年1月9日上午9:25:27 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.service.sys;

import java.util.List;

import cn.booktable.modules.entity.sys.DictCityInfoDo;

/**
 * ClassName: CityInfoService <br>
 * Description: TODO
 * @author anxymf
 * Date:2017年1月9日上午9:25:27 <br>
 * @version
 * @since JDK 1.6
 */
public interface DictCityInfoService {

	public List<DictCityInfoDo> queryProvince();

	public List<DictCityInfoDo> queryCityByProvince(String cityCode);
}

