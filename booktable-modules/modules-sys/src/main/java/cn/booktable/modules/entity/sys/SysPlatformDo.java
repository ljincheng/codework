package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 系统平台.
 * @author ljc
 * @version  v1.0
 */
@Alias("sysPlatformDo")
public class SysPlatformDo implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 平台ID. */
	private Integer id;

	/** 标题. */
	private String title;

	/** 是否默认. */
	private Integer isDefault;


	/**
	 * 平台ID.
	 * @param id
	 * 平台ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 平台ID.
	 * @return 平台ID
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * 标题.
	 * @param title
	 * 标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 标题.
	 * @return 标题
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * 是否默认.
	 * @param isDefault
	 * 是否默认
	 */
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * 是否默认.
	 * @return 是否默认
	 */
	public Integer getIsDefault() {
		return this.isDefault;
	}


	@Override
	public String toString()
	{
		return "SysPlatformDo ["+",id="+id
+",title="+title
+",isDefault="+isDefault
+"]";
	}

}
