/**
 * Project Name:jcpt-common <br>
 * File Name:CodeListComponent.java <br>
 * Package Name:com.eic.jcpt.component.system <br>
 * @author anxymf
 * Date:2016年12月7日上午10:13:16 <br>
 * Copyright (c) 2016, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.component.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.DictSystemInfoDo;
import cn.booktable.core.page.PageDo;

/**
 * ClassName: CodeListComponent <br>
 * Description: 数据字典组件
 * @version
 * @since JDK 1.6
 */
public interface DictSystemInfoComponent {

	/**
	 *
	 * insert:新增数据字典. <br>
	 * @param codeList 数据字典对象
	 * @return
	 */
	Integer insert(DictSystemInfoDo codeList);

	/**
	 *
	 * delete:删除数据字典. <br>
	 * @param codeId 字典ID
	 * @return
	 */
	Integer delete(String codeId);

	/**
	 *
	 * queryListPage:查询数据字典(分页). <br>
	 * @param selectItem 查询参数map
	 * @return
	 */
	PageDo<DictSystemInfoDo> queryListPage(Map<String, Object> selectItem);

	/**
	 *
	 * queryById:根据ID查询数据字典. <br>
	 * @param codeId 字典ID
	 * @return
	 */
	DictSystemInfoDo queryById(String codeId);

	/**
	 *
	 * update:修改数据字典. <br>
	 * @param codeList
	 * @return
	 */
	Integer update(DictSystemInfoDo codeList);

	/**
	 *
	 * queryCodeList:根据类型查询数据字典. <br>
	 * @param codeType 字典类型
	 * @return
	 */
	List<DictSystemInfoDo> queryCodeList(String codeType);

	/**
	 *
	 * queryCodeListToMap:根据类型查询数据字典返回map. <br>
	 * @param string
	 * @return key--codeValue value--codeName
	 */
	Map<String,String> queryCodeListToMap(String string);

	/**
	 *
	 * queryAll:查询所有. <br>
	 * Date:2017年4月6日上午9:13:03 <br>
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

