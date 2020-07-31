/**
 * Project Name:jcpt-common <br>
 * File Name:CodeListService.java <br>
 * Package Name:com.hehenian.jcpt.service.system <br>
 * @author anxymf
 * Date:2016年12月7日上午10:39:04 <br>
 * Copyright (c) 2016, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.service.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.DictSystemInfoDo;
import cn.booktable.core.page.PageDo;

/**
 * ClassName: CodeListService <br>
 * Description: 数据字典服务
 * @author anxymf
 * Date:2016年12月7日上午10:39:04 <br>
 * @version
 * @since JDK 1.6
 */
public interface DictSystemInfoService {

	/**
	 *
	 * queryListPage:查询数据字典(分页). <br>
	 *
	 * @author anxymf
	 * Date:2016年12月21日下午3:09:54 <br>
	 * @param selectItem 查询参数map
	 * @return
	 */
	PageDo<DictSystemInfoDo> queryListPage(Map<String, Object> selectItem);

	/**
	 *
	 * insert:新增数据字典. <br>
	 *
	 * @author anxymf
	 * Date:2016年12月21日下午3:10:20 <br>
	 * @param codeList 数据字典对象
	 * @return
	 */
	Integer insert(DictSystemInfoDo codeList);

	/**
	 *
	 * queryById:根据ID查询数据字典. <br>
	 *
	 * @author anxymf
	 * Date:2016年12月21日下午3:10:32 <br>
	 * @param codeId 字典ID
	 * @return
	 */
	DictSystemInfoDo queryById(String codeId);

	/**
	 *
	 * update:修改数据字典. <br>
	 *
	 * @author anxymf
	 * Date:2016年12月21日下午3:10:45 <br>
	 * @param codeList 数据字典对象
	 * @return
	 */
	Integer update(DictSystemInfoDo codeList);

	/**
	 *
	 * delete:删除数据字典. <br>
	 *
	 * @author anxymf
	 * Date:2016年12月21日下午3:11:12 <br>
	 * @param codeId 字典ID
	 * @return
	 */
	Integer delete(String codeId);

	/**
	 *
	 * queryCodeList:根据类型查询数据字典. <br>
	 *
	 * @author anxymf
	 * Date:2016年12月21日下午3:28:52 <br>
	 * @param codeType 字典类型
	 * @return
	 */
	List<DictSystemInfoDo> queryCodeList(String codeType);

	/**
	 *
	 * queryAll:查询所有. <br>
	 *
	 * @author anxymf
	 * Date:2017年4月6日上午9:12:15 <br>
	 * @return
	 */
	List<DictSystemInfoDo> queryAll();

	/**
	 * 根据类型、值 获取字典项
	 * @param codeType 字典类型
	 * @param codeValue 字典值
	 * @return
	 */
	DictSystemInfoDo findByCodeTypeAndValue(String codeType,String codeValue);

}

