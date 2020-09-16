package cn.booktable.modules.entity.sys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Atlantis样式菜单
 * @author ljc
 */
public class AtlantisHtmlMenu implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /** 标题 */
    private String titleHtml;
    private String href;
    private String icon;
    private String title;
    private Long   id;
    private Integer dataType;
    private Long parentId;
    private List<AtlantisHtmlMenu> children;
    private AtlantisHtmlMenu parentMenu;
    /** 当前活动的 */
    private Boolean active=false;

    /**
     * html菜单标签
     * @param titleHtml
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
    public void setChildren(List<AtlantisHtmlMenu> children)
    {
        this.children=children;
    }

    /**
     * 子菜单
     * @return
     */
    public List<AtlantisHtmlMenu> getChildren()
    {
        return this.children;
    }

    /**
     * 添加子菜单
     * @param child
     */
    public void addChildren(AtlantisHtmlMenu child)
    {
        if(this.children==null)
        {
            this.children=new ArrayList<AtlantisHtmlMenu>();
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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public AtlantisHtmlMenu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(AtlantisHtmlMenu parentMenu) {
        this.parentMenu = parentMenu;
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
            String iconStr="";
            if(this.parentMenu==null)
            {
                iconStr="<i class='"+this.icon+"'></i>";
            }

            if(getActive())
            {
                html.append("<li  class=\"nav-item submenu active\" >").append("<a href=\"#subnav_"+this.getId()+"\" data-toggle=\"collapse\" aria-expanded='true'>").append(iconStr).append(this.getTitleHtml()).append("<span class=\"caret\"></span></a>");
                html.append("<div id='subnav_"+this.getId()+"' class='collapse show'>");
                html.append("<ul class=\"nav nav-collapse\">");
            }else{
                html.append("<li  class=\"nav-item submenu\" >").append("<a href=\"#subnav_"+this.getId()+"\" data-toggle=\"collapse\">").append(iconStr).append(this.getTitleHtml()).append("<span class=\"caret\"></span></a>");
                html.append("<div id='subnav_"+this.getId()+"' class='collapse'>");
                html.append("<ul class=\"nav nav-collapse\">");
            }
            for(int i=0,k=this.children.size();i<k;i++)
            {
                AtlantisHtmlMenu child=this.children.get(i);
                String childHtml=child.toHtml();
                html.append(childHtml);
            }
            html.append("</ul></div>");
        }else{
            if(getDataType()!=null ) {
                int datatype=getDataType().intValue();
                if(datatype==3)
                {
                    html.append("<li class='nav-item submenu' >").append("<a  eventdata=\"" + this.getHref() + "\" target='main_frame' href=\"" + this.getHref() + "\">").append(this.getTitleHtml()).append("</a>");
                }else if(datatype==1) {
                    if(parentMenu==null)
                    {
                        html.append("<li class='nav-item submenu' >").append("<a  eventdata=\"" + this.getHref() + "\" target='main_frame' href=\"" + this.getHref() + "\">").append(this.getTitleHtml()).append("</a>");
                    }else {
                        html.append("<li class='menu_link_item' >").append("<a  eventdata=\"" + this.getHref() + "\" target='main_frame' href=\"" + this.getHref() + "\">").append(this.getTitleHtml()).append("</a>");
                    }
                }
            }
        }
        html.append("</li>");
        return html.toString();
    }

}
