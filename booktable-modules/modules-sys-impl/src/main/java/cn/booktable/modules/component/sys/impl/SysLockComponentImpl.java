package cn.booktable.modules.component.sys.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.booktable.modules.entity.sys.SysLockDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.component.sys.SysLockComponent;
import cn.booktable.modules.dao.sys.SysLockDao;

/**
 * 全局业务锁
 * @author ljc
 * @version 1.0
 */
/**
 * @author ljc
 * @version 1.0
 */
@Component("sysLockComponent")
public class SysLockComponentImpl implements SysLockComponent {

	@Autowired
	private SysLockDao sysLockDao;

	@Override
	public SysLockDo findLock(String lockNum) {
		return sysLockDao.findLock(lockNum);
	}

	@Override
	public Integer addLock(SysLockDo lock) {
		lock.setCreateTime(new Date());
		return sysLockDao.addLock(lock);
	}

	@Override
	public Integer deleteLock(String lockNum) {
		return sysLockDao.delLock(lockNum);
	}

	@Override
	public PageDo<SysLockDo> queryLockListPage(Long pageIndex, Integer pageSize, Map<String, Object> selectItem) {

		 if(selectItem==null)
		 {
			 selectItem=new HashMap<String,Object>();
		 }
		 PageDo<SysLockDo> pageBean=new PageDo<SysLockDo>(pageIndex, pageSize);
		 selectItem.put("page", pageBean);
		 pageBean.setPage(sysLockDao.queryListPage(selectItem));
		return pageBean;
	}

	@Override
	public Integer deleteLockByLockNum(String lockNum) {
		return sysLockDao.deleteByLockNum(lockNum);
	}

}
