package cn.booktable.modules.service.sys.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.booktable.modules.component.sys.SysSeqNumberComponent;
import cn.booktable.modules.service.sys.SysSeqNumberService;

/**
 * 全局唯一ID
 * @author ljc
 * @version 1.0
 */
@Service("sysSeqNumberService")
public class SysSeqNumberServiceImpl implements SysSeqNumberService{

	private static Logger logger=LoggerFactory.getLogger(SysSeqNumberServiceImpl.class);

	@Autowired
	private SysSeqNumberComponent sysSeqNumberComponent;

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@Override
	public Long daySeqnumber() {
		Long seqnum=sysSeqNumberComponent.daySeqnumber();
		logger.debug("生成每日全局ID={}",seqnum);
		return seqnum;
	}

	@Override
	public String daySeqnumberString() {
		return sysSeqNumberComponent.daySeqnumberString();
	}

	@Override
	public String daySeqnumberString(String prefixStr) {
		return sysSeqNumberComponent.daySeqnumberString(prefixStr);
	}

}
