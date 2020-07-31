package cn.booktable.modules.service.sys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 权限节点
 * @author ljc
 * @version 1.0
 */
public class PermissionNode implements Serializable{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** 主键. */
	private Long id;

	/** 资源名称. */
	private String name;

	/** 资源类型. */
	private Integer dataType;

	/** 访问url地址. */
	private String url;

	/** 权限代码字符串. */
	private String perCode;

	/** 父结点id. */
	private Long parentId;

	/** 路径. */
	private String path;

	/** 排序. */
	private Integer indexs;

	/** 是否可用. */
	private Integer available;

	/** 创建时间. */
	private Date createTime;

	/** 图标. */
	private String icon;

	/** 是否有权限 */
	private Boolean hasPermission;

	private List<PermissionNode> children;


	/**
	 * 主键.
	 * @param id
	 * 主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 主键.
	 * @return 主键
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * 资源名称.
	 * @param name
	 * 资源名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 资源名称.
	 * @return 资源名称
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 资源类型.
	 * @param dataType
	 * 资源类型
	 */
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

	/**
	 * 资源类型.
	 * @return 资源类型
	 */
	public Integer getDataType() {
		return this.dataType;
	}

	/**
	 * 访问url地址.
	 * @param url
	 * 访问url地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 访问url地址.
	 * @return 访问url地址
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * 权限代码字符串.
	 * @param perCode
	 * 权限代码字符串
	 */
	public void setPerCode(String perCode) {
		this.perCode = perCode;
	}

	/**
	 * 权限代码字符串.
	 * @return 权限代码字符串
	 */
	public String getPerCode() {
		return this.perCode;
	}

	/**
	 * 父结点id.
	 * @param parentId
	 * 父结点id
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 父结点id.
	 * @return 父结点id
	 */
	public Long getParentId() {
		return this.parentId;
	}

	/**
	 * 路径.
	 * @param path
	 * 路径
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * 路径.
	 * @return 路径
	 */
	public String getPath() {
		return this.path;
	}

	/**
	 * 排序.
	 * @param indexs
	 * 排序
	 */
	public void setIndexs(Integer indexs) {
		this.indexs = indexs;
	}

	/**
	 * 排序.
	 * @return 排序
	 */
	public Integer getIndexs() {
		return this.indexs;
	}

	/**
	 * 是否可用.
	 * @param available
	 * 是否可用
	 */
	public void setAvailable(Integer available) {
		this.available = available;
	}

	/**
	 * 是否可用.
	 * @return 是否可用
	 */
	public Integer getAvailable() {
		return this.available;
	}

	/**
	 * 创建时间.
	 * @param createTime
	 * 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 创建时间.
	 * @return 创建时间
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * 图标.
	 * @param icon
	 * 图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 图标.
	 * @return 图标
	 */
	public String getIcon() {
		return this.icon;
	}


	/**
	 * 是否有权限
	 * @return
	 */
	public Boolean getHasPermission() {
		return hasPermission;
	}

	/**
	 * 是否有权限
	 * @param hasPermission 是否有权限
	 */
	public void setHasPermission(Boolean hasPermission) {
		this.hasPermission = hasPermission;
	}

	public void addChildren(PermissionNode node)
	{
		if(children==null)
		{
			this.children=new ArrayList<PermissionNode>();
		}
		this.children.add(node);
	}

	public List<PermissionNode> getChildren()
	{
		return this.children;
	}

	@Override
	public String toString()
	{
		return "SysPermissionDo ["+",id="+id
+",name="+name
+",dataType="+dataType
+",url="+url
+",perCode="+perCode
+",parentId="+parentId
+",path="+path
+",indexs="+indexs
+",available="+available
+",createTime="+createTime
+"]";
	}
}
