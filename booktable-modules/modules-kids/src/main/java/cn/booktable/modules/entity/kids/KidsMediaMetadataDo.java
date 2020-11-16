package cn.booktable.modules.entity.kids;

import org.apache.ibatis.type.Alias;
import java.io.Serializable;
import lombok.Data;

import java.util.Date;


/**
 *
 * @author ljc
 */
@Alias("kidsMediaMetadataDo")
@Data
public class KidsMediaMetadataDo implements Serializable {

private static final long serialVersionUID = 1L;

		private Long id;//主键ID
		private Long categoryId;//类别
		private String title;//名称
		private String imageUrl;//图片地址
		private String mediaType;//媒体类别
		private String mediaUrl;//媒体地址
		private String sourceUrl;//来源
		private String descs;//备注
		private Date createTime;//创建时间
		private Date updateTime;//更新时间

		private KidsMediaCategoryDo category;


}
