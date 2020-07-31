/**
 * Project Name:jcpt-common <br>
 * File Name:CodeListComponentImpl.java <br>
 * Package Name:com.eic.jcpt.component.loan.impl <br>
 * @author anxymf
 * Date:2016年12月7日上午10:15:58 <br>
 * Copyright (c) 2016, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.component.sys.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.booktable.modules.component.sys.DictSystemInfoComponent;
import cn.booktable.modules.dao.sys.DictSystemInfoDao;
import cn.booktable.modules.entity.sys.DictSystemInfoDo;
import cn.booktable.core.page.PageDo;

/**
 * ClassName: CodeListComponentImpl <br>
 * Description: 数据字典组件
 * @author anxymf
 * Date:2016年12月7日上午10:15:58 <br>
 * @version
 * @since JDK 1.6
 */
@Component
public class DictSystemInfoComponentImpl implements DictSystemInfoComponent {

	/** 数据字典持久对象 */
	@Resource
	private DictSystemInfoDao dictSystemInfoDao;

	/**
	 *
	 * 新增数据字典.
	 * @see com.eic.jcptsystem.component.system.DictSystemInfoComponent#insert(com.eic.jcptsystem.model.system.DictSystemInfoDo)
	 */
	@Override
	public Integer insert(DictSystemInfoDo codeList) {
		codeList.setCreateTime(new Date());
		return dictSystemInfoDao.insert(codeList);
	}

	/**
	 *
	 * 删除数据字典.
	 * @see com.eic.jcptsystem.component.system.DictSystemInfoComponent#delete(java.lang.String)
	 */
	@Override
	public Integer delete(String codeId) {
		return dictSystemInfoDao.delete(codeId);
	}

	/**
	 *
	 * 查询数据字典(分页).
	 * @see com.eic.jcptsystem.component.system.DictSystemInfoComponent#queryListPage(java.util.Map)
	 */
	@Override
	public PageDo<DictSystemInfoDo> queryListPage(Map<String, Object> selectItem) {
		String pageIndex = (String)selectItem.get("pageIndex");
		String pageSize = (String)selectItem.get("pageSize");
		PageDo<DictSystemInfoDo> page = new PageDo<DictSystemInfoDo>(Long.valueOf(pageIndex),
				Integer.valueOf(pageSize));
		selectItem.put("page", page);
		page.setPage(dictSystemInfoDao.queryListPage(selectItem));
		return page;
	}

	/**
	 *
	 * 根据ID查询数据字典.
	 * @see com.eic.jcptsystem.component.system.DictSystemInfoComponent#queryById(java.lang.String)
	 */
	@Override
	public DictSystemInfoDo queryById(String codeId) {
		return dictSystemInfoDao.queryById(codeId);
	}

	/**
	 *
	 * 修改数据字典.
	 * @see com.eic.jcptsystem.component.system.DictSystemInfoComponent#update(com.eic.jcptsystem.model.system.DictSystemInfoDo)
	 */
	@Override
	public Integer update(DictSystemInfoDo codeList) {
		return dictSystemInfoDao.update(codeList);
	}

	/**
	 *
	 * 根据类型查询数据字典.
	 * @see com.eic.jcptsystem.component.system.DictSystemInfoComponent#queryCodeList(java.lang.String)
	 */
	@Override
	public List<DictSystemInfoDo> queryCodeList(String codeType) {
		return dictSystemInfoDao.queryCodeList(codeType);
	}

	/**
	 *
	 * 根据类型查询数据字典返回map.
	 * @see com.eic.jcptsystem.component.system.DictSystemInfoComponent#queryCodeListToMap(java.lang.String)
	 */
	@Override
	public Map<String, String> queryCodeListToMap(String codeType) {
		Map<String, String> map = new HashMap<String, String>();
		List<DictSystemInfoDo> list = dictSystemInfoDao.queryCodeList(codeType);
		for (DictSystemInfoDo codeList : list) {
			map.put(codeList.getCodeValue(), codeList.getCodeName());
		}
		return map;
	}

	/**
	 *
	 * 查询所有.
	 * @see com.eic.jcptsystem.component.system.DictSystemInfoComponent#queryAll()
	 */
	@Override
	public List<DictSystemInfoDo> queryAll() {
		return dictSystemInfoDao.queryAll();
	}

	@Override
	public DictSystemInfoDo findByCodeTypeAndValue(String codeType,String codeValue){
		return dictSystemInfoDao.findByCodeTypeAndValue(codeType,codeValue);
	}
}

