package cn.booktable.modules.component.shop.impl;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.component.shop.ShopCategoryComponent;
import cn.booktable.modules.dao.shop.ShopCategoryDao;

import cn.booktable.modules.entity.shop.ShopCategoryDo;

/**
 * 商品分类
 * @author ljc
 * @version v1.0
 */
@Component("shopCategoryComponent")
public class ShopCategoryComponentImpl implements ShopCategoryComponent {

    @Autowired
    private ShopCategoryDao shopCategoryDao;


    @Override
    public Integer insertShopCategory(ShopCategoryDo shopCategoryDo){
        return shopCategoryDao.insert(shopCategoryDo);
    }

    @Override
    public List<ShopCategoryDo> queryShopCategoryList(Map<String,Object> selectItem){
        return shopCategoryDao.queryList(selectItem);
    }

    @Override
    public PageDo<ShopCategoryDo> queryShopCategoryListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem){
        if(selectItem==null){
            selectItem=new HashMap<String,Object>();
        }
        PageDo<ShopCategoryDo> pageBean=new PageDo<ShopCategoryDo>(pageIndex, pageSize);
        selectItem.put("page", pageBean);
        pageBean.setPage(shopCategoryDao.queryListPage(selectItem));
        return pageBean;
    }

    @Override
    public Integer updateShopCategoryById(ShopCategoryDo shopCategoryDo){
        return shopCategoryDao.updateById(shopCategoryDo);
    }

    @Override
    public Integer deleteShopCategoryById(Long id){
        return shopCategoryDao.deleteById(id);
    }

    @Override
    public ShopCategoryDo findShopCategoryById(Long id){
        return shopCategoryDao.findById(id);
    }


}