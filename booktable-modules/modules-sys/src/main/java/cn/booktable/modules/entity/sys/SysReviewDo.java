package cn.booktable.modules.entity.sys;
import org.apache.ibatis.type.Alias;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * 评论
 * @author ljc
 * @version v1.0
 */
@Alias("sysReviewDo")
@Data
public class SysReviewDo implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;
    /** 主题ID */
    private Long subjectId;
    /** 被评论ID */
    private Long reviewId;
    /** 用户ID */
    private Integer userId;
    /** 评论内容 */
    private String content;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
    /** 状态：1有效，0无效 */
    private Integer status;
    /** 回复数 **/
    private Integer reviewNums;

    private SysUserDo user;

    private List<SysReviewDo> childReviewList;

}