/**
 * Project Name:jcpt-common <br>
 * File Name:CityInfoDao.java <br>
 * Package Name:com.hehenian.jcpt.dao.system <br>
 * @author anxymf
 * Date:2017年1月6日上午9:48:16 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.booktable.modules.entity.sys.DictCityInfoDo;

/**
 * ClassName: CityInfoDao <br>
 * Description: TODO
 * @author anxymf
 * Date:2017年1月6日上午9:48:16 <br>
 * @version
 * @since JDK 1.6
 */
@Mapper
public interface DictCityInfoDao {

	public List<DictCityInfoDo> queryProvince();

	public List<DictCityInfoDo> queryCityByProvince(String cityCode);

	/**
	 * 根据贷款端编码获取城市编码表记录（贷款端的编码是以c开头的）
	 * @param loanCode 贷款端编码
	 * @return
	 * @author ljc
	 */
	public DictCityInfoDo findCityByLoanCode(String loanCode);

	/**
	 * 根据贷款端编码获取城市编码表记录集（贷款端的编码是以c开头的）
	 * @param loanCode 贷款端编码
	 * @return
	 * @author ljc
	 */
	public List<DictCityInfoDo> findCityListByLoanCode(String loanCode);

}

