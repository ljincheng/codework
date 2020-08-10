package cn.booktable.modules.component.sys.impl;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import cn.booktable.util.AssertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.component.sys.SysReviewComponent;
import cn.booktable.modules.dao.sys.SysReviewDao;

import cn.booktable.modules.entity.sys.SysReviewDo;
import org.springframework.transaction.annotation.Transactional;

/**
 * 评论
 * @author ljc
 * @version v1.0
 */
@Component("sysReviewComponent")
public class SysReviewComponentImpl implements SysReviewComponent {

    @Autowired
    private SysReviewDao sysReviewDao;


    @Override
    @Transactional
    public Integer insertSysReview(SysReviewDo sysReviewDo,String reviewTableName){
        AssertUtils.isNotBlank(reviewTableName,"评论表名不能为空");
        AssertUtils.notNull(sysReviewDo,"评论内容不能为空");
        Date now =new Date();
        if(sysReviewDo.getCreateTime()==null)
        {
            sysReviewDo.setCreateTime(now);
        }
        if(sysReviewDo.getUpdateTime()==null)
        {
            sysReviewDo.setUpdateTime(now);
        }
        Map<String,Object> items=new HashMap();
        items.put("sysReview",sysReviewDo);
        items.put("review_table",reviewTableName);
        if(sysReviewDo.getReviewId()>0)
        {
            Integer updateReviewNumRes=sysReviewDao.addReviewNums(sysReviewDo.getReviewId(),1,reviewTableName);
            AssertUtils.isPositiveNumber(updateReviewNumRes,"更新评论数失败");
        }
        return sysReviewDao.insert(items);
    }

    @Override
    public List<SysReviewDo> querySysReviewList(Map<String,Object> selectItem,String reviewTableName){
        AssertUtils.isNotBlank(reviewTableName,"评论表名不能为空");
        Map<String,Object> queryItems=new HashMap();
        if(selectItem!=null)
        {
            queryItems.putAll(selectItem);
        }
        queryItems.put("review_table",reviewTableName);
        return sysReviewDao.queryList(queryItems);
    }

    @Override
    public PageDo<SysReviewDo> querySysReviewListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem,String reviewTableName){
        AssertUtils.isNotBlank(reviewTableName,"评论表名不能为空");
        if(selectItem==null){
            selectItem=new HashMap<String,Object>();
        }
        PageDo<SysReviewDo> pageBean=new PageDo<SysReviewDo>(pageIndex, pageSize);
        selectItem.put("page", pageBean);
        selectItem.put("review_table",reviewTableName);
        pageBean.setPage(sysReviewDao.queryListPage(selectItem));
        return pageBean;
    }

    @Override
    public Integer updateSysReviewById(SysReviewDo sysReviewDo,String reviewTableName){
        AssertUtils.isNotBlank(reviewTableName,"评论表名不能为空");
        Map<String,Object> items=new HashMap();
        if(sysReviewDo.getUpdateTime()==null)
        {
            Date now =new Date();
            sysReviewDo.setUpdateTime(now);
        }
        items.put("sysReview",sysReviewDo);
        items.put("review_table",reviewTableName);
        return sysReviewDao.updateById(items);
    }

    @Override
    public Integer deleteSysReviewById(Long id,String reviewTableName){
        AssertUtils.isNotBlank(reviewTableName,"评论表名不能为空");
        Map<String,Object> items=new HashMap();
        items.put("id",id);
        items.put("review_table",reviewTableName);
        return sysReviewDao.deleteById(items);
    }

    @Override
    public SysReviewDo findSysReviewById(Long id,String reviewTableName){
        AssertUtils.isNotBlank(reviewTableName,"评论表名不能为空");
        Map<String,Object> items=new HashMap();
        items.put("id",id);
        items.put("review_table",reviewTableName);
        return sysReviewDao.findById(items);
    }

    @Override
    public List<SysReviewDo> suppleChildReview(List<SysReviewDo> reviewList, String reviewTableName) {
        if(reviewList!=null && reviewList.size()>0)
        {
            for(int i=0,k=reviewList.size();i<k;i++)
            {
                SysReviewDo sysReviewDo=reviewList.get(i);
                if(sysReviewDo.getReviewNums()!=null && sysReviewDo.getReviewNums()>0)
                {
                    Map<String,Object>selectItem=new HashMap<>();
                    selectItem.put("reviewId",sysReviewDo.getId());
                    selectItem.put("review_table",reviewTableName);
                    List<SysReviewDo> childReviewList= sysReviewDao.queryList(selectItem);
                    suppleChildReview(childReviewList,reviewTableName);
                   sysReviewDo.setChildReviewList(childReviewList);
                }
            }
        }
        return reviewList;
    }
}