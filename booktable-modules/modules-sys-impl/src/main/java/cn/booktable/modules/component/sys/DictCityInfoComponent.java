/**
 * Project Name:jcpt-common <br>
 * File Name:CityInfoComponent.java <br>
 * Package Name:com.hehenian.jcpt.component.system <br>
 * @author anxymf
 * Date:2017年1月9日上午9:22:20 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.component.sys;

import java.util.List;

import cn.booktable.modules.entity.sys.DictCityInfoDo;

/**
 * ClassName: CityInfoComponent <br>
 * Description: TODO
 * @author anxymf
 * Date:2017年1月9日上午9:22:20 <br>
 * @version
 * @since JDK 1.6
 */
public interface DictCityInfoComponent {

	public List<DictCityInfoDo> queryProvince();

	public List<DictCityInfoDo> queryCityByProvince(String cityCode);

	/**
	 * 根据贷款端编码获取城市编码表记录
	 * @param loanCode 贷款端编码
	 * @return
	 * @author ljc
	 */
	public DictCityInfoDo queryCityByLoanCode(String loanCode);

	/**
	 * 根据贷款端编码获取城市编码表记录集
	 * @param loanCode 贷款端编码
	 * @return
	 * @author ljc
	 */
	public List<DictCityInfoDo> queryCityListByLoanCode(String loanCode);

}

