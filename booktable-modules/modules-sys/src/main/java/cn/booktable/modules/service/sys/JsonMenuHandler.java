package cn.booktable.modules.service.sys;

import java.io.Serializable;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import cn.booktable.modules.entity.sys.SysPermissionDo;
import cn.booktable.modules.service.sys.MenuListHandler;

/**
 * JSON格式菜单处理
 * @author ljc
 * @version 1.0
 */
public final class JsonMenuHandler  implements MenuListHandler<JSONObject>,Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public JSONObject handler(SysPermissionDo sysPer) {
		 JSONObject obj=new JSONObject();
		 obj.put("id", sysPer.getId());
		 obj.put("title", sysPer.getName());
		 obj.put("dataType", sysPer.getDataType());
		 obj.put("icon", sysPer.getIcon());

		 if(sysPer.getDataType()!=null && sysPer.getDataType()==1)
		 {
			 obj.put("dataUrl", sysPer.getUrl());
		 }else{
			 obj.put("open", true);
		 }
		 obj.put("url", "javascript:menuUrl("+sysPer.getId()+")");
		return obj;
	}

	@Override
	public void linkRelations(JSONObject parent, JSONObject child) {
		  Object children=parent.get("children");
		  JSONArray array=null;
		  if(children!=null)
		  {
			 array=(JSONArray)children;
		  }else{
			  array=new JSONArray();
		  }
		  array.add(child);
		  parent.put("children", array);

	}

}
