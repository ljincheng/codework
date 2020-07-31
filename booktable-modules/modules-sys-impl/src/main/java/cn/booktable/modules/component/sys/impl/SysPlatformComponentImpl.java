package cn.booktable.modules.component.sys.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.modules.component.sys.SysPlatformComponent;
import cn.booktable.modules.dao.sys.SysPlatformDao;
import cn.booktable.modules.entity.sys.SysPermissionDo;
import cn.booktable.modules.entity.sys.SysPlatformDo;
import cn.booktable.modules.entity.sys.SysPlatformMenuDo;
import cn.booktable.core.page.PageDo;

/**
 * 系统平台.
 * @author ljc
 * @version  v1.0
 */
@Component("sysPlatformComponent")
public class SysPlatformComponentImpl  implements SysPlatformComponent{

	private SysPlatformDao sysPlatformDao;

	@Autowired
	public void setSysPlatformDao(SysPlatformDao sysPlatformDao)
	{
		this.sysPlatformDao=sysPlatformDao;
	}


	@Override
	public Integer insertSysPlatform(SysPlatformDo sysPlatform)
	{
		return sysPlatformDao.insert(sysPlatform);
	}

	@Override
	public List<SysPlatformDo> querySysPlatformList(Map<String,Object> selectItem)
	{
		return sysPlatformDao.queryList(selectItem);
	}

	@Override
	public PageDo<SysPlatformDo> querySysPlatformListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem)
	{
		 if(selectItem==null)
		 {
			 selectItem=new HashMap<String,Object>();
		 }
		 PageDo<SysPlatformDo> pageBean=new PageDo<SysPlatformDo>(pageIndex, pageSize);
		 selectItem.put("page", pageBean);
		 pageBean.setPage(sysPlatformDao.queryListPage(selectItem));
		return pageBean;
	}


	@Override
	public Integer updateSysPlatformById(SysPlatformDo sysPlatform)
	{
		return sysPlatformDao.updateById(sysPlatform);
	}

	@Override
	public Integer deleteSysPlatformById(Integer id)
	{
		return sysPlatformDao.deleteById(id);
	}

	@Override
	public SysPlatformDo findSysPlatformById(Integer id)
	{
		return sysPlatformDao.findById(id);
	}


	@Override
	public List<SysPermissionDo> getMenuListByUserId(Integer userId, Integer platformId) {
		return sysPlatformDao.getMenuListByUserId(userId, platformId);
	}


	@Override
	public List<SysPermissionDo> getChildMenuListByPlatformId(Integer platformId,Long menuId) {
		return sysPlatformDao.getChildMenuListByPlatformId(platformId,menuId);
	}

	@Override
	public List<SysPermissionDo> getAllMenuListByPlatformId(Integer platformId) {
		return sysPlatformDao.getAllMenuListByPlatformId(platformId);
	}

	@Override
	public Integer addPlatformMenu(Integer platformId, Long menuId) {
		SysPlatformMenuDo platformMenu=new SysPlatformMenuDo();
		platformMenu.setMenuId(menuId);
		platformMenu.setPlatformId(platformId);
		List<SysPlatformMenuDo> menuList=sysPlatformDao.queryPlatformMenuList(platformMenu);
		if(menuList!=null && menuList.size()>0)
		{
			return menuList.size();
		}else {
			return sysPlatformDao.addPlatformMenu(platformMenu);
		}
	}


	@Override
	public Integer deletePlatformMenu(Long menuId, Integer platformId) {
		return sysPlatformDao.deletePlatformMenu(menuId, platformId);
	}
}
