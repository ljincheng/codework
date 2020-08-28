package cn.booktable.modules.entity.shop;
import org.apache.ibatis.type.Alias;
import java.io.Serializable;
import lombok.Data;

/**
 * 商品分类
 * @author ljc
 * @version v1.0
 */
@Alias("shopCategoryDo")
@Data
public class ShopCategoryDo implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;
    /** 分类名称 */
    private String name;
    /** 父结点id */
    private Long parentId;
    /** 状态:1有效，0无效 */
    private Integer status;

}