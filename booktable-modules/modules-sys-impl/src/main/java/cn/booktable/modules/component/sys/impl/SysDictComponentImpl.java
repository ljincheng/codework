package cn.booktable.modules.component.sys.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.booktable.modules.component.sys.SysDictComponent;
import org.springframework.stereotype.Component;

import cn.booktable.modules.dao.sys.SysDictDao;
import cn.booktable.modules.entity.sys.SysDictDo;
import cn.booktable.core.page.PageDo;

/**
 * 数据字典组件
 */
@Component
public class SysDictComponentImpl implements SysDictComponent {

	/** 数据字典持久对象 */
	@Resource
	private SysDictDao sysDictDao;

	/**
	 *
	 * 新增数据字典.
	 */
	@Override
	public Integer insert(SysDictDo codeList) {
		codeList.setCreateTime(new Date());
		return sysDictDao.insert(codeList);
	}

	/**
	 *
	 * 删除数据字典.
	 */
	@Override
	public Integer delete(String codeId) {
		return sysDictDao.delete(codeId);
	}

	/**
	 *
	 * 查询数据字典(分页).
	 */
	@Override
	public PageDo<SysDictDo> queryListPage(Map<String, Object> selectItem) {
		String pageIndex = (String)selectItem.get("pageIndex");
		String pageSize = (String)selectItem.get("pageSize");
		PageDo<SysDictDo> page = new PageDo<SysDictDo>(Long.valueOf(pageIndex),
				Integer.valueOf(pageSize));
		selectItem.put("page", page);
		page.setPage(sysDictDao.queryListPage(selectItem));
		return page;
	}

	/**
	 *
	 * 根据ID查询数据字典.
	 */
	@Override
	public SysDictDo queryById(String codeId) {
		return sysDictDao.queryById(codeId);
	}

	/**
	 *
	 * 修改数据字典.
	 */
	@Override
	public Integer update(SysDictDo codeList) {
		return sysDictDao.update(codeList);
	}

	/**
	 *
	 * 根据类型查询数据字典.
	 */
	@Override
	public List<SysDictDo> queryCodeList(String codeType) {
		return sysDictDao.queryCodeList(codeType);
	}

	/**
	 *
	 * 根据类型查询数据字典返回map.
	 */
	@Override
	public Map<String, String> queryCodeListToMap(String codeType) {
		Map<String, String> map = new HashMap<String, String>();
		List<SysDictDo> list = sysDictDao.queryCodeList(codeType);
		for (SysDictDo codeList : list) {
			map.put(codeList.getCodeValue(), codeList.getCodeName());
		}
		return map;
	}

	/**
	 *
	 * 查询所有.
	 */
	@Override
	public List<SysDictDo> queryAll() {
		return sysDictDao.queryAll();
	}

	@Override
	public SysDictDo findByCodeTypeAndValue(String codeType, String codeValue){
		return sysDictDao.findByCodeTypeAndValue(codeType,codeValue);
	}
}

