package cn.booktable.modules.component.sys.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.component.sys.BizLockComponent;
import cn.booktable.modules.dao.sys.LockDao;
import cn.booktable.modules.entity.sys.LockDo;

/**
 * 全局业务锁
 * @author ljc
 * @version 1.0
 */
/**
 * @author ljc
 * @version 1.0
 */
@Component("bizLockComponent")
public class BizLockComponentImpl implements BizLockComponent{

	@Autowired
	private LockDao lockDao;

	@Override
	public LockDo findLock(String lockNum) {
		return lockDao.findLock(lockNum);
	}

	@Override
	public Integer addLock(LockDo lock) {
		lock.setCreateTime(new Date());
		return lockDao.addLock(lock);
	}

	@Override
	public Integer deleteLock(String lockNum) {
		return lockDao.delLock(lockNum);
	}

	@Override
	public PageDo<LockDo> queryLockListPage(Long pageIndex, Integer pageSize, Map<String, Object> selectItem) {

		 if(selectItem==null)
		 {
			 selectItem=new HashMap<String,Object>();
		 }
		 PageDo<LockDo> pageBean=new PageDo<LockDo>(pageIndex, pageSize);
		 selectItem.put("page", pageBean);
		 pageBean.setPage(lockDao.queryListPage(selectItem));
		return pageBean;
	}

	@Override
	public Integer deleteLockByLockNum(String lockNum) {
		return lockDao.deleteByLockNum(lockNum);
	}

}
