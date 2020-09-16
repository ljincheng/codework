package cn.booktable.modules.entity.mobile;
import org.apache.ibatis.type.Alias;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * 移动视图页面
 * @author ljc
 * @version v1.0
 */
@Alias("mobileViewPageDo")
@Data
public class MobileViewPageDo implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;
    /** 父结点id */
    private Long parentId;
    /** 名称 */
    private String name;
    /** 视图类型 */
    private Integer viewType;
    /** 视图数据 */
    private String viewData;
    /** 用户id */
    private Integer userId;
    /** 显示顺序权重 */
    private Integer weight;
    /** 状态:1有效，0无效 */
    private Integer status;
    /** 创建时间 */
    private Date createTime;
    /** 最后更新时间 */
    private Date updateTime;

}