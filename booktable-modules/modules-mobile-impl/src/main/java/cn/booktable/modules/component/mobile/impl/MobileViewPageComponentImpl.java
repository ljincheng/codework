package cn.booktable.modules.component.mobile.impl;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.component.mobile.MobileViewPageComponent;
import cn.booktable.modules.dao.mobile.MobileViewPageDao;

import cn.booktable.modules.entity.mobile.MobileViewPageDo;

/**
 * 移动视图页面
 * @author ljc
 * @version v1.0
 */
@Component("mobileViewPageComponent")
public class MobileViewPageComponentImpl implements MobileViewPageComponent {

    @Autowired
    private MobileViewPageDao mobileViewPageDao;


    @Override
    public Integer insertMobileViewPage(MobileViewPageDo mobileViewPageDo){
        return mobileViewPageDao.insert(mobileViewPageDo);
    }

    @Override
    public List<MobileViewPageDo> queryMobileViewPageList(Map<String,Object> selectItem){
        return mobileViewPageDao.queryList(selectItem);
    }

    @Override
    public PageDo<MobileViewPageDo> queryMobileViewPageListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem){
        if(selectItem==null){
            selectItem=new HashMap<String,Object>();
        }
        PageDo<MobileViewPageDo> pageBean=new PageDo<MobileViewPageDo>(pageIndex, pageSize);
        selectItem.put("page", pageBean);
        pageBean.setPage(mobileViewPageDao.queryListPage(selectItem));
        return pageBean;
    }

    @Override
    public Integer updateMobileViewPageById(MobileViewPageDo mobileViewPageDo){
        return mobileViewPageDao.updateById(mobileViewPageDo);
    }

    @Override
    public Integer deleteMobileViewPageById(Long id){
        return mobileViewPageDao.deleteById(id);
    }

    @Override
    public MobileViewPageDo findMobileViewPageById(Long id){
        return mobileViewPageDao.findById(id);
    }


}