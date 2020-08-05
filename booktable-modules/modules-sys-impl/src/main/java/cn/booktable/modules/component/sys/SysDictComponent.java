package cn.booktable.modules.component.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.SysDictDo;
import cn.booktable.core.page.PageDo;

/**
 * 数据字典组件
 */
public interface SysDictComponent {

	/**
	 *
	 * insert:新增数据字典. <br>
	 * @param codeList 数据字典对象
	 * @return
	 */
	Integer insert(SysDictDo codeList);

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
	PageDo<SysDictDo> queryListPage(Map<String, Object> selectItem);

	/**
	 *
	 * queryById:根据ID查询数据字典. <br>
	 * @param codeId 字典ID
	 * @return
	 */
	SysDictDo queryById(String codeId);

	/**
	 *
	 * update:修改数据字典. <br>
	 * @param codeList
	 * @return
	 */
	Integer update(SysDictDo codeList);

	/**
	 *
	 * queryCodeList:根据类型查询数据字典. <br>
	 * @param codeType 字典类型
	 * @return
	 */
	List<SysDictDo> queryCodeList(String codeType);

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
	 * @return
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

