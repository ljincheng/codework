package cn.booktable.modules.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import cn.booktable.modules.entity.sys.SysDictDo;

@Mapper
public interface SysDictDao {

    /**
     * findById:根据Id查询. <br>
     */
    public SysDictDo queryById(String id);

    public Integer insert(SysDictDo t);

    /**
     *
     * update:更新. <br>
     */
    public Integer update(SysDictDo t);


    /**
     *
     * deleteById:根据Id删除. <br>
     */
    public Integer delete(String id);

    /**
     *
     * queryListPage:分页查询. <br>
     */
    public List<SysDictDo> queryListPage(Map<String, Object> selectItem);
	/**
	 *
	 * queryCodeList:根据类型查询数据字典. <br>
	 */
	List<SysDictDo> queryCodeList(String type);

	/**
	 *
	 * queryAll:查询所有.
	 */
	List<SysDictDo> queryAll();

	/**
	 *
	 * @param codeType
	 * @param codeValue
	 * @return
	 */
	SysDictDo findByCodeTypeAndValue(@Param("codeType") String codeType, @Param("codeValue")String codeValue);

}
