package cn.booktable.modules.entity.mobile;

import org.apache.ibatis.type.Alias;
import java.io.Serializable;
import lombok.Data;

import java.util.Date;


/**
 * 测试-Hello
 * @author ljc
 */
@Alias("helloDo")
@Data
public class HelloDo implements Serializable {

private static final long serialVersionUID = 1L;
 
		private Long id;//主键ID
		private String title;//标题
		private String descs;//备注
		private Date createTime;//创建时间
		private Date updateTime;//更新时间

 
}