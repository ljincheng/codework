package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 后台菜单.
 * @author ljc
 * @version  v1.0
 */
@Alias("sysPlatformMenuDo")
public class SysPlatformMenuDo implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 平台ID. */
	private Integer platformId;

	/** 菜单ID. */
	private Long menuId;


	/**
	 * 平台ID.
	 * @param platformId
	 * 平台ID
	 */
	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}

	/**
	 * 平台ID.
	 * @return 平台ID
	 */
	public Integer getPlatformId() {
		return this.platformId;
	}

	/**
	 * 菜单ID.
	 * @param menuId
	 * 菜单ID
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * 菜单ID.
	 * @return 菜单ID
	 */
	public Long getMenuId() {
		return this.menuId;
	}


	@Override
	public String toString()
	{
		return "SysPlatformMenuDo ["+",platformId="+platformId
+",menuId="+menuId
+"]";
	}

}
