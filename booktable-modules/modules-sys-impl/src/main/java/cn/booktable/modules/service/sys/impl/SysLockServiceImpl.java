package cn.booktable.modules.service.sys.impl;

import java.util.Date;
import java.util.Map;

import cn.booktable.modules.entity.sys.SysLockDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.component.sys.SysLockComponent;
import cn.booktable.modules.service.sys.SysLockService;

/**
 * 全局业务锁服务
 * @author ljc
 * @version 1.0
 */
@Service("bizLockService")
public class SysLockServiceImpl implements SysLockService {
	private static Logger logger=LoggerFactory.getLogger(SysLockServiceImpl.class);

	@Autowired
	private SysLockComponent sysLockComponent;

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Boolean getLock(String lockId, String remark) {
		SysLockDo sysLockDo = sysLockComponent.findLock(lockId);
		if(sysLockDo !=null)
		{
			return false;
		}else{
			try{
				sysLockDo =new SysLockDo();
				sysLockDo.setLockNum(lockId);
				sysLockDo.setRemark(remark);
				sysLockDo.setCreateTime(new Date());
				Integer dbResult= sysLockComponent.addLock(sysLockDo);
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
		Integer dbResult= sysLockComponent.deleteLock(lockId);
		return (dbResult!=null && dbResult.intValue()>0);
	}


	@Override
	public PageDo<SysLockDo> queryLockListPage(Long pageIndex, Integer pageSize, Map<String, Object> selectItem) {
		return sysLockComponent.queryLockListPage(pageIndex, pageSize, selectItem);
	}


	@Override
	public Integer deleteLockByLockNum(String lockNum) {
		return sysLockComponent.deleteLockByLockNum(lockNum);
	}

}
