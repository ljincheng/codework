package cn.booktable.modules.service.sys;
import java.util.List;
import java.util.Map;
import java.util.Date;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.sys.SysReviewDo;

/**
 * 评论
 * @author ljc
 * @version v1.0
 */
public interface SysReviewService {

    /**
     * 添加评论
     * @param sysReviewDo 评论内容
     * @param reviewTableName 评论表名
     * @return
     */
    public Integer insertSysReview(SysReviewDo sysReviewDo,String reviewTableName);

    /**
     * 获取评论列表
     * @param selectItem
     * @return
     */
    public List<SysReviewDo> querySysReviewList(Map<String,Object> selectItem,String reviewTableName);

    /**
     * 获取评论分页列表
     * @param pageIndex 起始页
     * @param pageSize 每页记录数
     * @param selectItem 过滤条件
     * @return
     */
    public PageDo<SysReviewDo> querySysReviewListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem,String reviewTableName);

    /**
     * 根据id修改评论
     * @param sysReviewDo
     * @return
     */
    public Integer updateSysReviewById(SysReviewDo sysReviewDo,String reviewTableName);

    /**
     * 根据id删除评论
     * @param id
     * @return
     */
    public Integer deleteSysReviewById(Long id,String reviewTableName);

    /**
     * 根据id查找评论
     * @param id
     * @return
     */
    public SysReviewDo findSysReviewById(Long id,String reviewTableName);


    /**
     * 补充子回复
     * @param reviewList
     * @param reviewTableName
     * @return
     */
    public List<SysReviewDo> suppleChildReview(List<SysReviewDo> reviewList,String reviewTableName);
}