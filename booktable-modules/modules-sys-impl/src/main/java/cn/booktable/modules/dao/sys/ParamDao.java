/**
 * Project Name:jcpt-common <br>
 * File Name:CityInfoDao.java <br>
 * Package Name:com.eic.jcpt.dao.system <br>
 * @author anxymf
 * Date:2017年1月6日上午9:48:16 <br>
 * Copyright (c) 2017, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.dao.sys;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import cn.booktable.modules.entity.sys.ParamDo;

/**
 * ClassName: CityInfoDao <br>
 * Description: TODO
 * @author anxymf
 * Date:2017年1月6日上午9:48:16 <br>
 * @version
 * @since JDK 1.6
 */
@Mapper
public interface ParamDao{

	 /**
     *
     * findById:根据Id查询. <br>
     * @param id
     * @return
     */
    public ParamDo queryById(String id);

    /**
     * 根据编号找参数
     * @param paramCode
     * @return
     */
    ParamDo queryByCode(String paramCode);

	/**
	 *
	 * insert:新增. <br>
	 * @param t
	 * @return
	 */
    public Integer insert(ParamDo t);

    /**
     *
     * update:更新. <br>
     * @param t
     * @return
     */
    public Integer update(ParamDo t);


    /**
     *
     * deleteById:根据Id删除. <br>
     * @param id
     * @return
     */
    public Integer delete(String id);

    /**
     *
     * queryListPage:分页查询. <br>
     * @param selectItem 查询参数map
     * @return
     */
    public List<ParamDo> queryListPage(Map<String, Object> selectItem);

	String queryValueByCode(String paramCode);


}

