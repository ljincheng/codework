package cn.booktable.modules.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import cn.booktable.modules.entity.sys.DictSystemInfoDo;

/**
 *
 * ClassName: CodeListDao <br>
 * Description: 数据字典持久对象<br>
 * @author anxymf
 * Date:2016年12月27日下午2:15:12 <br>
 * @version
 * @since JDK 1.6
 */
@Mapper
public interface DictSystemInfoDao {

    /**
     *
     * findById:根据Id查询. <br>
     *
     * @author anxymf
     * Date:2016年11月14日上午11:06:44 <br>
     * @param id
     * @return
     */
    public DictSystemInfoDo queryById(String id);

	/**
	 *
	 * insert:新增. <br>
	 *
	 * @author anxymf
	 * Date:2016年11月14日上午11:06:41 <br>
	 * @param t
	 * @return
	 */
    public Integer insert(DictSystemInfoDo t);

    /**
     *
     * update:更新. <br>
     *
     * @author anxymf
     * Date:2016年11月14日上午11:06:50 <br>
     * @param t
     * @return
     */
    public Integer update(DictSystemInfoDo t);


    /**
     *
     * deleteById:根据Id删除. <br>
     *
     * @author anxymf
     * Date:2016年11月14日上午11:06:47 <br>
     * @param id
     * @return
     */
    public Integer delete(String id);

    /**
     *
     * queryListPage:分页查询. <br>
     *
     * @author anxymf
     * Date:2016年12月27日下午2:16:42 <br>
     * @param selectItem 查询参数map
     * @return
     */
    public List<DictSystemInfoDo> queryListPage(Map<String, Object> selectItem);
	/**
	 *
	 * queryCodeList:根据类型查询数据字典. <br>
	 *
	 * @author anxymf
	 * Date:2016年12月27日下午2:15:21 <br>
	 * @param type
	 * @return
	 */
	List<DictSystemInfoDo> queryCodeList(String type);

	/**
	 *
	 * queryAll:查询所有. <br>
	 *
	 * @author anxymf
	 * Date:2017年4月6日上午9:13:57 <br>
	 * @return
	 */
	List<DictSystemInfoDo> queryAll();

	/**
	 *
	 * @param codeName
	 * @param codeValue
	 * @return
	 */
	DictSystemInfoDo findByCodeTypeAndValue(@Param("codeType") String codeType, @Param("codeValue")String codeValue);

}
