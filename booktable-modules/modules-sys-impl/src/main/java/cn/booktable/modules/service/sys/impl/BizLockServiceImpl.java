package cn.booktable.modules.service.sys.impl;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.component.sys.BizLockComponent;
import cn.booktable.modules.entity.sys.LockDo;
import cn.booktable.modules.service.sys.BizLockService;

/**
 * 全局业务锁服务
 * @author ljc
 * @version 1.0
 */
@Service("bizLockService")
public class BizLockServiceImpl implements BizLockService{
	private static Logger logger=LoggerFactory.getLogger(BizLockServiceImpl.class);

	@Autowired
	private BizLockComponent bizLockComponent;

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Boolean getLock(String lockId, String remark) {
		LockDo lockDo=bizLockComponent.findLock(lockId);
		if(lockDo!=null)
		{
			return false;
		}else{
			try{
				lockDo=new LockDo();
				lockDo.setLockNum(lockId);
				lockDo.setRemark(remark);
				lockDo.setCreateTime(new Date());
				Integer dbResult= bizLockComponent.addLock(lockDo);
				return (dbResult!=null && dbResult.intValue()>0);
			}catch (Exception e) {
				logger.error("添加全局锁异常",e);
				return false;
			}
		}

	}


	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Boolean releaseLock(String lockId) {
		Integer dbResult=bizLockComponent.deleteLock(lockId);
		return (dbResult!=null && dbResult.intValue()>0);
	}


	@Override
	public PageDo<LockDo> queryLockListPage(Long pageIndex, Integer pageSize, Map<String, Object> selectItem) {
		return bizLockComponent.queryLockListPage(pageIndex, pageSize, selectItem);
	}


	@Override
	public Integer deleteLockByLockNum(String lockNum) {
		return bizLockComponent.deleteLockByLockNum(lockNum);
	}

}
