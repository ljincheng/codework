package cn.booktable.modules.service.mobile.impl;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.service.mobile.MobileViewPageService;
import cn.booktable.modules.component.mobile.MobileViewPageComponent;

import cn.booktable.modules.entity.mobile.MobileViewPageDo;

/**
 * 移动视图页面
 * @author ljc
 * @version v1.0
 */
@Service("mobileViewPageService")
public class MobileViewPageServiceImpl implements MobileViewPageService {

    @Autowired
    private MobileViewPageComponent mobileViewPageComponent;


    @Override
    public Integer insertMobileViewPage(MobileViewPageDo mobileViewPageDo){
        if(mobileViewPageDo.getCreateTime()==null)
        {
            mobileViewPageDo.setCreateTime(new Date());
        }
        if(mobileViewPageDo.getUpdateTime()==null)
        {
            mobileViewPageDo.setUpdateTime(new Date());
        }
        if(mobileViewPageDo.getStatus()==null)
        {
            mobileViewPageDo.setStatus(1);
        }
        if(mobileViewPageDo.getWeight()==null)
        {
            mobileViewPageDo.setWeight(0);
        }
        return mobileViewPageComponent.insertMobileViewPage(mobileViewPageDo);
    }

    @Override
    public List<MobileViewPageDo> queryMobileViewPageList(Map<String,Object> selectItem){
        return mobileViewPageComponent.queryMobileViewPageList(selectItem);
    }

    @Override
    public PageDo<MobileViewPageDo> queryMobileViewPageListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem){
        return mobileViewPageComponent.queryMobileViewPageListPage(pageIndex,pageSize,selectItem);
    }

    @Override
    public Integer updateMobileViewPageById(MobileViewPageDo mobileViewPageDo){
        return mobileViewPageComponent.updateMobileViewPageById(mobileViewPageDo);
    }

    @Override
    public Integer deleteMobileViewPageById(Long id){
        return mobileViewPageComponent.deleteMobileViewPageById(id);
    }

    @Override
    public MobileViewPageDo findMobileViewPageById(Long id){
        return mobileViewPageComponent.findMobileViewPageById(id);
    }


}