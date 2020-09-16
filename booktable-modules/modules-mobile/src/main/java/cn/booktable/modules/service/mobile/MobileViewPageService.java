package cn.booktable.modules.service.mobile;
import java.util.List;
import java.util.Map;
import java.util.Date;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.mobile.MobileViewPageDo;

/**
 * 移动视图页面
 * @author ljc
 * @version v1.0
 */
public interface MobileViewPageService {

    /**
     * 添加移动视图页面
     * @param mobileViewPageDo
     * @return
     */
    public Integer insertMobileViewPage(MobileViewPageDo mobileViewPageDo);

    /**
     * 获取移动视图页面列表
     * @param selectItem
     * @return
     */
    public List<MobileViewPageDo> queryMobileViewPageList(Map<String,Object> selectItem);

    /**
     * 获取移动视图页面分页列表
     * @param pageIndex 起始页
     * @param pageSize 每页记录数
     * @param selectItem 过滤条件
     * @return
     */
    public PageDo<MobileViewPageDo> queryMobileViewPageListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem);

    /**
     * 根据id修改移动视图页面
     * @param mobileViewPageDo
     * @return
     */
    public Integer updateMobileViewPageById(MobileViewPageDo mobileViewPageDo);

    /**
     * 根据id删除移动视图页面
     * @param id
     * @return
     */
    public Integer deleteMobileViewPageById(Long id);

    /**
     * 根据id查找移动视图页面
     * @param id
     * @return
     */
    public MobileViewPageDo findMobileViewPageById(Long id);


}