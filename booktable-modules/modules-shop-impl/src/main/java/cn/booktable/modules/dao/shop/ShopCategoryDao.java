package cn.booktable.modules.dao.shop;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.shop.ShopCategoryDo;

/**
 * 商品分类
 * @author ljc
 * @version v1.0
 */
@Repository("shopCategoryDao")
public interface ShopCategoryDao {

    /**
     * 添加商品分类
     * @param shopCategoryDo
     * @return
     */
    public Integer insert(ShopCategoryDo shopCategoryDo);

    /**
     * 获取商品分类列表
     * @param selectItem
     * @return
     */
    public List<ShopCategoryDo> queryList(Map<String,Object> selectItem);

    /**
     * 获取商品分类分页列表
     * @param selectItem
     * @return
     */
    public List<ShopCategoryDo> queryListPage(Map<String,Object> selectItem);

    /**
     * 根据id修改商品分类
     * @param shopCategoryDo
     * @return
     */
    public Integer updateById(ShopCategoryDo shopCategoryDo);

    /**
     * 根据id删除商品分类
     * @param id
     * @return
     */
    public Integer deleteById(Long id);

    /**
     * 根据id查找商品分类
     * @param id
     * @return
     */
    public ShopCategoryDo findById(Long id);


}