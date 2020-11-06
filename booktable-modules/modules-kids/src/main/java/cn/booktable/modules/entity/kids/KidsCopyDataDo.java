package cn.booktable.modules.entity.kids;

import org.apache.ibatis.type.Alias;
import java.io.Serializable;
import lombok.Data;

import java.util.Date;
import java.util.Map;


/**
 * 
 * @author ljc
 */
@Alias("kidsCopyDataDo")
@Data
public class KidsCopyDataDo implements Serializable {

private static final long serialVersionUID = 1L;
 
		private Long id;//主键ID
		private String tableName;//表名
		private String content;//内容
		private Date createTime;//创建时间

		private Map<String,Object> fieldMap;

 
}