package cn.booktable.modules.component.sys.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.modules.component.sys.SysPermissionComponent;
import cn.booktable.modules.dao.sys.SysPermissionDao;
import cn.booktable.modules.entity.sys.SysPermissionDo;
import cn.booktable.core.page.PageDo;

/**
 * 权限资源.
 * @author ljc
 * @version  v1.0
 */
@Component("sysPermissionComponent")
public class SysPermissionComponentImpl  implements SysPermissionComponent{

	@Autowired
	private SysPermissionDao sysPermissionDao;

	/**
	 * 添加权限资源.
	 * @param sysPermission
	 * @return
	 */
	public Integer insertSysPermission(SysPermissionDo sysPermission)
	{
		sysPermission.setCreateTime(new Date());
		if(sysPermission.getId()==null)
		{
			sysPermission.setId(sysPermissionDao.getMaxId()+1);
		}
		if(sysPermission.getParentId()!=null && sysPermission.getParentId()>0)
		{
			SysPermissionDo parentSysPer=findSysPermissionById(sysPermission.getParentId());
			sysPermission.setPath(parentSysPer.getPath()+"-"+sysPermission.getId());
		}else{
			sysPermission.setPath("-"+sysPermission.getId());
		}
		return sysPermissionDao.insert(sysPermission);
	}

	/**
	 * 获取权限资源数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysPermissionDo> querySysPermissionList(Map<String,Object> selectItem)
	{
		return sysPermissionDao.queryList(selectItem);
	}


	/**
	 * 根据Id修改权限资源.
	 * @param sysPermission
	 * @return
	 */
	public Integer updateSysPermissionById(SysPermissionDo sysPermission)
	{
		return sysPermissionDao.updateById(sysPermission);
	}

	@Override
	public Integer updateSysPermissionBaseInfoById(SysPermissionDo sysPermission) {
		return sysPermissionDao.updateBaseInfoById(sysPermission);
	}

	/**
	 * 根据Id删除权限资源.
	 * @param id
	 * @return
	 */
	public Integer deleteSysPermissionById(Long id)
	{
		SysPermissionDo sysPermission=sysPermissionDao.findById(id);
		if(sysPermission!=null)
		{
			return sysPermissionDao.deleteByPath(sysPermission.getPath());
		}
		return 0;
	}

	/**
	 * 根据Id获取权限资源.
	 * @param id
	 * @return
	 */
	public SysPermissionDo findSysPermissionById(Long id)
	{
		return sysPermissionDao.findById(id);
	}

	@Override
	public List<SysPermissionDo> getMenuListByUserId(Integer userId) {
		return sysPermissionDao.getMenuListByUserId(userId);
	}

	@Override
	public List<SysPermissionDo> getCodeListByUserId(Integer userId) {
		return sysPermissionDao.getCodeListByUserId(userId);
	}

	@Override
	public List<String> getCodeStrListByUserId(Integer userId) {
		return sysPermissionDao.getCodeStrListByUserId(userId);
	}

	@Override
	public PageDo<SysPermissionDo> queryPermissionListPage(Long pageIndex, Integer pageSize,
			Map<String, Object> selectItem) {
		if(selectItem==null)
		 {
			 selectItem=new HashMap<String,Object>();
		 }
		 PageDo<SysPermissionDo> pageBean=new PageDo<SysPermissionDo>(pageIndex,pageSize);
		 selectItem.put("page", pageBean);
		 pageBean.setPage(sysPermissionDao.queryListPage(selectItem));
		return pageBean;
	}

	@Override
	public List<SysPermissionDo> findChildMenuList(Long id) {
		return sysPermissionDao.findChildMenuList(id);
	}
}
