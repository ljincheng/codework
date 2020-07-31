package cn.booktable.modules.service.sys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.booktable.modules.entity.sys.SysPermissionDo;
import cn.booktable.modules.service.sys.MenuListHandler;

/**
 *权限节点处理
 * @author ljc
 * @version 1.0
 */
public class PermissionNodeHandler implements MenuListHandler<PermissionNode>,Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private List<PermissionNode> root=new ArrayList<PermissionNode>();
	private List<SysPermissionDo> permissionList;


	@Override
	public PermissionNode handler(SysPermissionDo sysPer) {
		PermissionNode node=new PermissionNode();
		node.setId(sysPer.getId());
		node.setName(sysPer.getName());
		node.setDataType(sysPer.getDataType());
		node.setIcon(sysPer.getIcon());
		node.setIndexs(sysPer.getIndexs());
		node.setUrl(sysPer.getUrl());
		node.setPerCode(sysPer.getPerCode());
		node.setParentId(sysPer.getParentId());
		node.setPath(sysPer.getPath());
		node.setAvailable(sysPer.getAvailable());
		resetHasPermission(node);
		if(node.getParentId()==null || node.getParentId().longValue()==0L)
		{
			root.add(node);
		}
		return node;
	}

	@Override
	public void linkRelations(PermissionNode parent, PermissionNode child) {
		 parent.addChildren(child);

	}

	/**
	 * 根节点
	 * @return
	 */
	public List<PermissionNode> getRoot()
	{
		return this.root;
	}

	public void setPermissionList(List<SysPermissionDo> permissionList)
	{
		this.permissionList=permissionList;
	}

	private void resetHasPermission(PermissionNode node)
	{
		if(this.permissionList==null || this.permissionList.size()==0)
		{
			node.setHasPermission(false);
		}else{

			for(SysPermissionDo permission:permissionList)
			{
				if(permission!=null && permission.getId()!=null && permission.getId().equals(node.getId()))
				{
					node.setHasPermission(true);
					break;
				}
			}
		}

	}
}
