package cn.booktable.modules.service.shop;
import java.util.List;
import java.util.Map;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.shop.ShopCategoryDo;

/**
 *
 * @author ljc
 * @version v1.0
 */
public interface ShopCategoryService {

    /**
     * 添加
     * @param shopCategoryDo
     * @return
     */
    public Integer insertShopCategory(ShopCategoryDo shopCategoryDo);

    /**
     * 获取列表
     * @param selectItem
     * @return
     */
    public List<ShopCategoryDo> queryShopCategoryList(Map<String,Object> selectItem);

    /**
     * 获取分页列表
     * @param pageIndex 起始页
     * @param pageSize 每页记录数
     * @param selectItem 过滤条件
     * @return
     */
    public PageDo<ShopCategoryDo> queryShopCategoryListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem);

    /**
     * 根据id修改
     * @param shopCategoryDo
     * @return
     */
    public Integer updateShopCategoryById(ShopCategoryDo shopCategoryDo);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public Integer deleteShopCategoryById(Long id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public ShopCategoryDo findShopCategoryById(Long id);


}