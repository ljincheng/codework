package cn.booktable.modules.service.sys.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.booktable.modules.component.sys.SysDictComponent;
import org.springframework.stereotype.Service;

import cn.booktable.modules.entity.sys.SysDictDo;
import cn.booktable.modules.service.sys.SysDictService;
import cn.booktable.core.page.PageDo;
import cn.booktable.util.AssertUtils;

/**
 *数据字典服务
 */
@Service("sysDictService")
public class SysDictServiceImpl implements SysDictService {

	/** 数据字典组件 */
	@Resource
	private SysDictComponent sysDictComponent;

	/**
	 *
	 * 查询数据字典(分页).
	 */
	@Override
	public PageDo<SysDictDo> queryListPage(Map<String, Object> selectItem) {
		return sysDictComponent.queryListPage(selectItem);
	}

	/**
	 *
	 * 新增数据字典.
	 */
	@Override
	public Integer insert(SysDictDo sysDictDo) {
		AssertUtils.isNotBlank(sysDictDo.getCodeName(),"字典名称不能为空");
		AssertUtils.isNotBlank(sysDictDo.getCodeType(),"字典类型不能为空");
		AssertUtils.isNotBlank(sysDictDo.getCodeValue(),"字典值不能为空");
		AssertUtils.isNotBlank(sysDictDo.getIsValid(),"字典是否有效不能为空");
		return sysDictComponent.insert(sysDictDo);
	}

	/**
	 *
	 * 根据ID查询数据字典.
	 */
	@Override
	public SysDictDo queryById(String codeId) {
		return sysDictComponent.queryById(codeId);
	}

	/**
	 *
	 * 修改数据字典.
	 */
	@Override
	public Integer update(SysDictDo sysDictDo) {
		AssertUtils.isNotBlank(sysDictDo.getCodeName(),"字典名称不能为空");
		AssertUtils.isNotBlank(sysDictDo.getCodeType(),"字典类型不能为空");
		AssertUtils.isNotBlank(sysDictDo.getCodeValue(),"字典值不能为空");
//		AssertUtils.isNotBlank(sysDictDo.getIsValid(),"字典是否有效不能为空");
		return sysDictComponent.update(sysDictDo);
	}

	/**
	 *
	 * 删除数据字典.
	 */
	@Override
	public Integer delete(String codeId) {
		return sysDictComponent.delete(codeId);
	}

	/**
	 *
	 * 根据类型查询数据字典.
	 */
	@Override
	public List<SysDictDo> queryCodeList(String codeType) {
		return sysDictComponent.queryCodeList(codeType);
	}

	@Override
	public List<SysDictDo> queryAll() {
		return sysDictComponent.queryAll();
	}

	@Override
	public SysDictDo findByCodeTypeAndValue(String codeType, String codeValue) {
		return sysDictComponent.findByCodeTypeAndValue(codeType,codeValue);
	}
}

