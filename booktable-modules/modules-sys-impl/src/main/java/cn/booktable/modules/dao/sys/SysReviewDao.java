package cn.booktable.modules.dao.sys;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.SysReviewDo;
import java.util.Date;

/**
 * 评论
 * @author ljc
 * @version v1.0
 */
@Mapper
public interface SysReviewDao {

    /**
     * 添加评论
     * @param items
     * @return
     */
    public Integer insert(Map<String,Object> items);

    /**
     * 获取评论列表
     * @param selectItem
     * @return
     */
    public List<SysReviewDo> queryList(Map<String,Object> selectItem);

    /**
     * 获取评论分页列表
     * @param selectItem
     * @return
     */
    public List<SysReviewDo> queryListPage(Map<String,Object> selectItem);

    /**
     * 根据id修改评论
     * @param items
     * @return
     */
    public Integer updateById(Map<String,Object> items);

    /**
     * 根据id删除评论
     * @param items
     * @return
     */
    public Integer deleteById(Map<String,Object> items);

    /**
     * 根据id查找评论
     * @param items
     * @return
     */
    public SysReviewDo findById(Map<String,Object> items);

    public Integer addReviewNums(@Param("id") Long id, @Param("num")Integer num,@Param("review_table") String review_table);

}