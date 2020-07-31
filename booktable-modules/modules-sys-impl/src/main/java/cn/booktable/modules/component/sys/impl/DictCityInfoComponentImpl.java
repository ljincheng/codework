/**
 * Project Name:jcpt-common <br>
 * File Name:CityInfoComponentImpl.java <br>
 * Package Name:com.hehenian.jcpt.component.system.impl <br>
 * @author anxymf
 * Date:2017年1月9日上午9:22:34 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.component.sys.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.booktable.modules.component.sys.DictCityInfoComponent;
import cn.booktable.modules.dao.sys.DictCityInfoDao;
import cn.booktable.modules.entity.sys.DictCityInfoDo;

/**
 * ClassName: CityInfoComponentImpl <br>
 * Description: TODO
 * @author anxymf
 * Date:2017年1月9日上午9:22:34 <br>
 * @version
 * @since JDK 1.6
 */
@Component
public class DictCityInfoComponentImpl implements DictCityInfoComponent {

	@Resource
	private DictCityInfoDao dictCityInfoDao;

	@Override
	public List<DictCityInfoDo> queryProvince() {
		return dictCityInfoDao.queryProvince();
	}

	@Override
	public List<DictCityInfoDo> queryCityByProvince(String cityCode) {
		return dictCityInfoDao.queryCityByProvince(cityCode);
	}

	@Override
	public DictCityInfoDo queryCityByLoanCode(String loanCode) {
		return dictCityInfoDao.findCityByLoanCode(loanCode);
	}


	@Override
	public List<DictCityInfoDo> queryCityListByLoanCode(String loanCode)
	{
		return dictCityInfoDao.findCityListByLoanCode(loanCode);
	}

}

