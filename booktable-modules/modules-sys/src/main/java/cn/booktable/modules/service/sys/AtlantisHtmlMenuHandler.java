package cn.booktable.modules.service.sys;

import cn.booktable.util.StringUtils;
import cn.booktable.modules.entity.sys.AtlantisHtmlMenu;
import cn.booktable.modules.entity.sys.HtmlMenu;
import cn.booktable.modules.entity.sys.SysPermissionDo;

import java.io.Serializable;

/**
 * @author ljc
 */
public class AtlantisHtmlMenuHandler implements Serializable, MenuListHandler<AtlantisHtmlMenu>{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /** 目录序号	 */
    private Integer menuIndex=0;

    @Override
    public AtlantisHtmlMenu handler(SysPermissionDo sysPer) {
        AtlantisHtmlMenu  menu=null;



        if(sysPer.getDataType()!=null )
        {
            if(sysPer.getDataType()==1){
                menu=new AtlantisHtmlMenu();
                menu.setIcon(sysPer.getIcon());
                menu.setTitle(sysPer.getName());
                Long nodeId= sysPer.getId();
                menu.setId(nodeId);
                menu.setParentId(sysPer.getParentId());
                menu.setDataType(sysPer.getDataType());
                String pathStart=sysPer.getUrl().startsWith("http")?"":"..";
                menu.setHref(pathStart+sysPer.getUrl());

//                if(StringUtils.isNotEmpty(sysPer.getIcon()) && sysPer.getParentId()==0L)
//                {
//                    menu.setTitleHtml("<a href=\"javascript:;\" eventdata=\""+pathStart+sysPer.getUrl()+"\"><i class=\""+sysPer.getIcon()+"\"></i><span class='sub-item'>"+sysPer.getName()+"</span></a>");
//                }else{
//                    menu.setTitleHtml("<a href=\"javascript:;\" eventdata=\""+pathStart+sysPer.getUrl()+"\"><span class='sub-item'>"+sysPer.getName()+"</span></a>");
//                }
                menu.setTitleHtml("<span class='sub-item'>"+sysPer.getName()+"</span>");
            }else if( sysPer.getDataType()==3){
                menu=new AtlantisHtmlMenu();
                menu.setIcon(sysPer.getIcon());
                menu.setTitle(sysPer.getName());
                menu.setParentId(sysPer.getParentId());
                menu.setDataType(sysPer.getDataType());
                Long nodeId= sysPer.getId();
                menu.setId(nodeId);

                if(menuIndex==0){
                    menu.setActive(true);
                }
                menuIndex++;
                menu.setTitleHtml("<span class='sub-item'>"+sysPer.getName()+"</span>");
//                if(StringUtils.isNotEmpty(sysPer.getIcon()) && sysPer.getParentId()==0L)
//                {
//                    menu.setTitleHtml("<a href=\"#subnav_"+nodeId+"\" data-toggle=\"collapse\"><i class=\""+sysPer.getIcon()+"\"></i><span class='sub-item'>"+sysPer.getName()+"</span><span class=\"caret\"></span></a>");
//                }else{
//                    menu.setTitleHtml("<a href=\"#subnav_"+nodeId+"\"><span class='sub-item'>"+sysPer.getName()+"</span><span class=\"caret\"></span></a>");
//                }
            }
        }

        return menu;
    }

    @Override
    public void linkRelations(AtlantisHtmlMenu parent, AtlantisHtmlMenu child) {
        if(child!=null && parent!=null)
        {
            parent.addChildren(child);
            child.setParentMenu(parent);
        }
    }

}
