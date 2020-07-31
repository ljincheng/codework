package cn.booktable.modules.service.sys.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.modules.component.sys.SysLoginHistoryComponent;
import cn.booktable.modules.dao.sys.SysLoginHistoryDao;
import cn.booktable.modules.entity.sys.SysLoginHistoryDo;
import cn.booktable.modules.service.sys.SysLoginHistoryService;
import cn.booktable.core.page.PageDo;

/**
 * 登录历史.
 * @author ljc
 * @version  v1.0
 */
@Component("sysLoginHistoryService")
public class SysLoginHistoryServiceImpl  implements SysLoginHistoryService{

	@Autowired
	private SysLoginHistoryComponent sysLoginHistoryComponent;

	/**
	 * 添加登录历史.
	 * @param sysLoginHistory
	 * @return
	 */
	public Integer insertSysLoginHistory(SysLoginHistoryDo sysLoginHistory)
	{
		return sysLoginHistoryComponent.insertSysLoginHistory(sysLoginHistory);
	}

	/**
	 * 获取登录历史数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysLoginHistoryDo> querySysLoginHistoryList(Map<String,Object> selectItem)
	{
		return sysLoginHistoryComponent.querySysLoginHistoryList(selectItem);
	}

	/**
	 * 获取登录历史数据集
	 * @param pageIndex
	 * 起始页
	 * @param pageSize
	 * 每页记录数
	 * @param selectItem
	 * 过滤条件
	 * @return
	 */
	public PageDo<SysLoginHistoryDo> querySysLoginHistoryListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem)
	{
		 return sysLoginHistoryComponent.querySysLoginHistoryListPage(pageIndex,pageSize,selectItem);
	}


	/**
	 * 根据Id修改登录历史.
	 * @param sysLoginHistory
	 * @return
	 */
	public Integer updateSysLoginHistoryById(SysLoginHistoryDo sysLoginHistory)
	{
		return sysLoginHistoryComponent.updateSysLoginHistoryById(sysLoginHistory);
	}

	/**
	 * 根据Id删除登录历史.
	 * @param id
	 * @return
	 */
	public Integer deleteSysLoginHistoryById(Long id)
	{
		return sysLoginHistoryComponent.deleteSysLoginHistoryById(id);
	}

	/**
	 * 根据Id获取登录历史.
	 * @param id
	 * @return
	 */
	public SysLoginHistoryDo findSysLoginHistoryById(Long id)
	{
		return sysLoginHistoryComponent.findSysLoginHistoryById(id);
	}

	@Override
	public Integer updateStatusById(SysLoginHistoryDo sysLoginHistory) {
		return sysLoginHistoryComponent.updateSysLoginHistoryById(sysLoginHistory);
	}
}
