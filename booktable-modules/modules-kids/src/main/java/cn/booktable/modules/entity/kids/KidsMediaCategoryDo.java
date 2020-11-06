package cn.booktable.modules.entity.kids;

import org.apache.ibatis.type.Alias;
import java.io.Serializable;
import lombok.Data;

import java.util.Date;


/**
 * 
 * @author ljc
 */
@Alias("kidsMediaCategoryDo")
@Data
public class KidsMediaCategoryDo implements Serializable {

private static final long serialVersionUID = 1L;
 
		private Long id;//主键ID
		private String title;//名称
		private String imageUrl;//图片地址
		private String descs;//备注
		private Long pid;//父类ID
		private Date createTime;//创建时间
		private Date updateTime;//更新时间

 
}