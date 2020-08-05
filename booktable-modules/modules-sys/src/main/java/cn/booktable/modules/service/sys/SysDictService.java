package cn.booktable.modules.service.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.SysDictDo;
import cn.booktable.core.page.PageDo;

/**
 * 数据字典服务
 */
public interface SysDictService {

	/**
	 *
	 * queryListPage:查询数据字典(分页). <br>
	 */
	PageDo<SysDictDo> queryListPage(Map<String, Object> selectItem);

	/**
	 *
	 * insert:新增数据字典. <br>
	 */
	Integer insert(SysDictDo codeList);

	/**
	 *
	 * queryById:根据ID查询数据字典. <br>
	 */
	SysDictDo queryById(String codeId);

	/**
	 *
	 * update:修改数据字典. <br>
	 */
	Integer update(SysDictDo codeList);

	/**
	 *
	 * delete:删除数据字典. <br>
	 */
	Integer delete(String codeId);

	/**
	 *
	 * queryCodeList:根据类型查询数据字典. <br>
	 */
	List<SysDictDo> queryCodeList(String codeType);

	/**
	 *
	 * queryAll:查询所有. <br>
	 */
	List<SysDictDo> queryAll();

	/**
	 * 根据类型、值 获取字典项
	 * @param codeType 字典类型
	 * @param codeValue 字典值
	 * @return
	 */
	SysDictDo findByCodeTypeAndValue(String codeType, String codeValue);

}

