package cn.booktable.modules.dao.mobile;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.mobile.MobileViewPageDo;
import java.util.Date;

/**
 * 移动视图页面
 * @author ljc
 * @version v1.0
 */
@Repository("mobileViewPageDao")
public interface MobileViewPageDao {

    /**
     * 添加移动视图页面
     * @param mobileViewPageDo
     * @return
     */
    public Integer insert(MobileViewPageDo mobileViewPageDo);

    /**
     * 获取移动视图页面列表
     * @param selectItem
     * @return
     */
    public List<MobileViewPageDo> queryList(Map<String,Object> selectItem);

    /**
     * 获取移动视图页面分页列表
     * @param selectItem
     * @return
     */
    public List<MobileViewPageDo> queryListPage(Map<String,Object> selectItem);

    /**
     * 根据id修改移动视图页面
     * @param mobileViewPageDo
     * @return
     */
    public Integer updateById(MobileViewPageDo mobileViewPageDo);

    /**
     * 根据id删除移动视图页面
     * @param id
     * @return
     */
    public Integer deleteById(Long id);

    /**
     * 根据id查找移动视图页面
     * @param id
     * @return
     */
    public MobileViewPageDo findById(Long id);


}