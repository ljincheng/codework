package cn.booktable.modules.component.sys.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.modules.component.sys.SysLoginHistoryComponent;
import cn.booktable.modules.dao.sys.SysLoginHistoryDao;
import cn.booktable.modules.entity.sys.SysLoginHistoryDo;
import cn.booktable.core.page.PageDo;

/**
 * 登录历史.
 * @author ljc
 * @version  v1.0
 */
@Component("sysLoginHistoryComponent")
public class SysLoginHistoryComponentImpl  implements SysLoginHistoryComponent{

	@Autowired
	private SysLoginHistoryDao sysLoginHistoryDao;

	/**
	 * 添加登录历史.
	 * @param sysLoginHistory
	 * @return
	 */
	public Integer insertSysLoginHistory(SysLoginHistoryDo sysLoginHistory)
	{
		return sysLoginHistoryDao.insert(sysLoginHistory);
	}

	/**
	 * 获取登录历史数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysLoginHistoryDo> querySysLoginHistoryList(Map<String,Object> selectItem)
	{
		return sysLoginHistoryDao.queryList(selectItem);
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
		 if(selectItem==null)
		 {
			 selectItem=new HashMap<String,Object>();
		 }
		 PageDo<SysLoginHistoryDo> pageBean=new PageDo<SysLoginHistoryDo>(pageIndex, pageSize);
		 selectItem.put("page", pageBean);
		 pageBean.setPage(sysLoginHistoryDao.queryListPage(selectItem));
		return pageBean;
	}


	/**
	 * 根据Id修改登录历史.
	 * @param sysLoginHistory
	 * @return
	 */
	public Integer updateSysLoginHistoryById(SysLoginHistoryDo sysLoginHistory)
	{
		return sysLoginHistoryDao.updateById(sysLoginHistory);
	}

	/**
	 * 根据Id删除登录历史.
	 * @param id
	 * @return
	 */
	public Integer deleteSysLoginHistoryById(Long id)
	{
		return sysLoginHistoryDao.deleteById(id);
	}

	/**
	 * 根据Id获取登录历史.
	 * @param id
	 * @return
	 */
	public SysLoginHistoryDo findSysLoginHistoryById(Long id)
	{
		return sysLoginHistoryDao.findById(id);
	}

	@Override
	public Integer updateStatusById(SysLoginHistoryDo sysLoginHistory) {
		return sysLoginHistoryDao.updateStatusById(sysLoginHistory);
	}
}
