package cn.booktable.modules.service.sys.impl;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.service.sys.SysReviewService;
import cn.booktable.modules.component.sys.SysReviewComponent;

import cn.booktable.modules.entity.sys.SysReviewDo;
import java.util.Date;

/**
 * 评论
 * @author sys
 * @version v1.0
 */
@Service("sysReviewService")
public class SysReviewServiceImpl implements SysReviewService {

    @Autowired
    private SysReviewComponent sysReviewComponent;


    @Override
    public Integer insertSysReview(SysReviewDo sysReviewDo,String reviewTableName){
        return sysReviewComponent.insertSysReview(sysReviewDo,reviewTableName);
    }

    @Override
    public List<SysReviewDo> querySysReviewList(Map<String,Object> selectItem,String reviewTableName){
        return sysReviewComponent.querySysReviewList(selectItem,reviewTableName);
    }

    @Override
    public PageDo<SysReviewDo> querySysReviewListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem,String reviewTableName){
        return sysReviewComponent.querySysReviewListPage(pageIndex,pageSize,selectItem,reviewTableName);
    }

    @Override
    public Integer updateSysReviewById(SysReviewDo sysReviewDo,String reviewTableName){
        return sysReviewComponent.updateSysReviewById(sysReviewDo,reviewTableName);
    }

    @Override
    public Integer deleteSysReviewById(Long id,String reviewTableName){
        return sysReviewComponent.deleteSysReviewById(id,reviewTableName);
    }

    @Override
    public SysReviewDo findSysReviewById(Long id,String reviewTableName){
        return sysReviewComponent.findSysReviewById(id,reviewTableName);
    }

    @Override
    public List<SysReviewDo> suppleChildReview(List<SysReviewDo> reviewList,String reviewTableName) {
        return sysReviewComponent.suppleChildReview(reviewList,reviewTableName);
    }
}