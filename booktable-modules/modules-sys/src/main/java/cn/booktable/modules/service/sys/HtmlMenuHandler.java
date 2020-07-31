package cn.booktable.modules.service.sys;


import java.io.Serializable;

import cn.booktable.modules.entity.sys.HtmlMenu;
import cn.booktable.modules.entity.sys.SysPermissionDo;
import cn.booktable.modules.service.sys.MenuListHandler;
import cn.booktable.util.StringUtils;

/**
* Html格式菜单处理
* @author ljc
* @version 1.0
*/
public class HtmlMenuHandler implements Serializable, MenuListHandler<HtmlMenu>{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/** 目录序号	 */
	private Integer menuIndex=0;

	@Override
	public HtmlMenu handler(SysPermissionDo sysPer) {
		HtmlMenu sb=null;
//  String sid = SecurityUtils.getSubject().getSession().getId().toString();
		if(sysPer.getDataType()!=null )
		{
			if(sysPer.getDataType()==1){
				sb=new HtmlMenu();
				String pathStart=sysPer.getUrl().startsWith("http")?"":"..";

				if(StringUtils.isNotEmpty(sysPer.getIcon()))
				{
					sb.setTitleHtml("<a href=\"javascript:;\" eventdata=\""+pathStart+sysPer.getUrl()+"\"><i class=\""+sysPer.getIcon()+"\"></i><span>"+sysPer.getName()+"</span></a>");
				}else{
					sb.setTitleHtml("<a href=\"javascript:;\" eventdata=\""+pathStart+sysPer.getUrl()+"\"><span>"+sysPer.getName()+"</span></a>");
				}
			}else if( sysPer.getDataType()==3){
				sb=new HtmlMenu();
				if(menuIndex==0){
					sb.setActive(true);
				}
				menuIndex++;
				if(StringUtils.isNotEmpty(sysPer.getIcon()))
				{
					sb.setTitleHtml("<a href=\"javascript:;\"><i class=\""+sysPer.getIcon()+"\"></i><span>"+sysPer.getName()+"</span><span class=\"pull-right-container\"><i class=\"fa fa-angle-left pull-right\"></i></span></a>");
				}else{
					sb.setTitleHtml("<a href=\"javascript:;\"><span>"+sysPer.getName()+"</span><span class=\"pull-right-container\"><i class=\"fa fa-angle-left pull-right\"></i></span></a>");
				}
			}
		}

		return sb;
	}

	@Override
	public void linkRelations(HtmlMenu parent, HtmlMenu child) {
		if(child!=null && parent!=null)
		{
		parent.addChildren(child);
		}
	}

}
