package cn.booktable.modules.service.shop.impl;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.service.shop.ShopCategoryService;
import cn.booktable.modules.component.shop.ShopCategoryComponent;

import cn.booktable.modules.entity.shop.ShopCategoryDo;

/**
 *
 * @author ljc
 * @version v1.0
 */
@Service("shopCategoryService")
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryComponent shopCategoryComponent;


    @Override
    public Integer insertShopCategory(ShopCategoryDo shopCategoryDo){
        return shopCategoryComponent.insertShopCategory(shopCategoryDo);
    }

    @Override
    public List<ShopCategoryDo> queryShopCategoryList(Map<String,Object> selectItem){
        return shopCategoryComponent.queryShopCategoryList(selectItem);
    }

    @Override
    public PageDo<ShopCategoryDo> queryShopCategoryListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem){
        return shopCategoryComponent.queryShopCategoryListPage(pageIndex,pageSize,selectItem);
    }

    @Override
    public Integer updateShopCategoryById(ShopCategoryDo shopCategoryDo){
        return shopCategoryComponent.updateShopCategoryById(shopCategoryDo);
    }

    @Override
    public Integer deleteShopCategoryById(Long id){
        return shopCategoryComponent.deleteShopCategoryById(id);
    }

    @Override
    public ShopCategoryDo findShopCategoryById(Long id){
        return shopCategoryComponent.findShopCategoryById(id);
    }


}