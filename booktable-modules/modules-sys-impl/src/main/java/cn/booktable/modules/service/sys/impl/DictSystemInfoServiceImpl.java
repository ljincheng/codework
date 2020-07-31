/**
 * Project Name:jcpt-common <br>
 * File Name:CodeListServiceImpl.java <br>
 * Package Name:CodeListService <br>
 * @author anxymf
 * Date:2016年12月7日上午10:39:25 <br>
 * Copyright (c) 2016, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.service.sys.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.booktable.modules.component.sys.DictSystemInfoComponent;
import cn.booktable.modules.entity.sys.DictSystemInfoDo;
import cn.booktable.modules.service.sys.DictSystemInfoService;
import cn.booktable.core.page.PageDo;
import cn.booktable.util.AssertUtils;

/**
 *数据字典服务
 */
@Service("dictSystemInfoService")
public class DictSystemInfoServiceImpl implements DictSystemInfoService {

	/** 数据字典组件 */
	@Resource
	private DictSystemInfoComponent dictSystemInfoComponent;

	/**
	 *
	 * 查询数据字典(分页).
	 */
	@Override
	public PageDo<DictSystemInfoDo> queryListPage(Map<String, Object> selectItem) {
		return dictSystemInfoComponent.queryListPage(selectItem);
	}

	/**
	 *
	 * 新增数据字典.
	 */
	@Override
	public Integer insert(DictSystemInfoDo dictSystemInfoDo) {
		AssertUtils.notEmptyStr(dictSystemInfoDo.getCodeName(),"字典名称不能为空");
		AssertUtils.notEmptyStr(dictSystemInfoDo.getCodeType(),"字典类型不能为空");
		AssertUtils.notEmptyStr(dictSystemInfoDo.getCodeValue(),"字典值不能为空");
		AssertUtils.notEmptyStr(dictSystemInfoDo.getIsValid(),"字典是否有效不能为空");
		return dictSystemInfoComponent.insert(dictSystemInfoDo);
	}

	/**
	 *
	 * 根据ID查询数据字典.
	 */
	@Override
	public DictSystemInfoDo queryById(String codeId) {
		return dictSystemInfoComponent.queryById(codeId);
	}

	/**
	 *
	 * 修改数据字典.
	 */
	@Override
	public Integer update(DictSystemInfoDo dictSystemInfoDo) {
		AssertUtils.notEmptyStr(dictSystemInfoDo.getCodeName(),"字典名称不能为空");
		AssertUtils.notEmptyStr(dictSystemInfoDo.getCodeType(),"字典类型不能为空");
		AssertUtils.notEmptyStr(dictSystemInfoDo.getCodeValue(),"字典值不能为空");
//		AssertUtils.notEmptyStr(dictSystemInfoDo.getIsValid(),"字典是否有效不能为空");
		return dictSystemInfoComponent.update(dictSystemInfoDo);
	}

	/**
	 *
	 * 删除数据字典.
	 */
	@Override
	public Integer delete(String codeId) {
		return dictSystemInfoComponent.delete(codeId);
	}

	/**
	 *
	 * 根据类型查询数据字典.
	 */
	@Override
	public List<DictSystemInfoDo> queryCodeList(String codeType) {
		return dictSystemInfoComponent.queryCodeList(codeType);
	}

	@Override
	public List<DictSystemInfoDo> queryAll() {
		return dictSystemInfoComponent.queryAll();
	}

	@Override
	public DictSystemInfoDo findByCodeTypeAndValue(String codeType, String codeValue) {
		return dictSystemInfoComponent.findByCodeTypeAndValue(codeType,codeValue);
	}
}

