package cn.booktable.modules.dao.sys;



import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.SysParamDo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysParamDao {

	 /**
     *
     * findById:根据Id查询. <br>
     * @param id
     * @return
     */
    public SysParamDo queryById(String id);

    /**
     * 根据编号找参数
     * @param paramCode
     * @return
     */
    SysParamDo queryByCode(String paramCode);

	/**
	 *
	 * insert:新增. <br>
	 * @param t
	 * @return
	 */
    public Integer insert(SysParamDo t);

    /**
     *
     * update:更新. <br>
     * @param t
     * @return
     */
    public Integer update(SysParamDo t);


    /**
     *
     * deleteById:根据Id删除. <br>
     * @param id
     * @return
     */
    public Integer delete(String id);

    /**
     *
     * queryListPage:分页查询. <br>
     * @param selectItem 查询参数map
     * @return
     */
    public List<SysParamDo> queryListPage(Map<String, Object> selectItem);

	String queryValueByCode(String paramCode);


}

