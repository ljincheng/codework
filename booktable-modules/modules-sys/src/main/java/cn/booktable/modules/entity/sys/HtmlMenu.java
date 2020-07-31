package cn.booktable.modules.entity.sys;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * html格式菜单
 * @author ljc
 * @version 1.0
 */
public class HtmlMenu implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** 标题 */
	private String titleHtml;
	private List<HtmlMenu> children;
	/** 当前活动的 */
	private Boolean active=false;

	/**
	 * html菜单标签
	 * @param html
	 */
	public void setTitleHtml(String titleHtml)
	{
		this.titleHtml=titleHtml;
	}

	/**
	 * html菜单标签
	 * @return
	 */
	public String getTitleHtml()
	{
		return this.titleHtml;
	}

	/**
	 * 子菜单
	 * @param children
	 */
	public void setChildren(List<HtmlMenu> children)
	{
		this.children=children;
	}

	/**
	 * 子菜单
	 * @return
	 */
	public List<HtmlMenu> getChildren()
	{
		return this.children;
	}

	/**
	 * 添加子菜单
	 * @param child
	 */
	public void addChildren(HtmlMenu child)
	{
		if(this.children==null)
		{
			this.children=new ArrayList<HtmlMenu>();
		}
		this.children.add(child);
	}


	/**
	 * 当前活动的
	 * @return
	 */
	public Boolean getActive() {
		return active;
	}


	/**
	 * 当前活动的
	 * @param active 当前活动的
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}


	/**
	 * 转换为html标签
	 * @return
	 */
	public String toHtml()
	{
		StringBuilder html=new StringBuilder();

		if(this.children!=null && this.children.size()>0)
		{

			if(getActive())
			{
				html.append("<li  class=\"treeview submenu active\" >").append(this.getTitleHtml());
				html.append("<ul  class=\"treeview-menu\" style=\"display: block;\">");
			}else{
				html.append("<li  class=\"treeview submenu\" >").append(this.getTitleHtml());
				html.append("<ul  class=\"treeview-menu\" style=\"display: none;\">");
			}
			for(int i=0,k=this.children.size();i<k;i++)
			{
				HtmlMenu child=this.children.get(i);
				String childHtml=child.toHtml();
				html.append(childHtml);
			}
			html.append("</ul>");
		}else{
			html.append("<li>").append(this.getTitleHtml());
		}
		html.append("</li>");
		return html.toString();
	}

}
