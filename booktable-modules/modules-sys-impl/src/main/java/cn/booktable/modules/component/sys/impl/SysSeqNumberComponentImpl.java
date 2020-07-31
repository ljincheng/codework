package cn.booktable.modules.component.sys.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.modules.component.sys.SysSeqNumberComponent;
import cn.booktable.modules.dao.sys.SysSeqNumberDao;
import cn.booktable.util.StringUtils;

/**
 * 全局唯一ID
 * @author ljc
 * @version 1.0
 */
@Component("sysSeqNumberComponent")
public class SysSeqNumberComponentImpl implements SysSeqNumberComponent{
	private static Logger logger=LoggerFactory.getLogger(SysSeqNumberComponentImpl.class);

	@Autowired
	private SysSeqNumberDao sysSeqNumberDao;

	private Long getDaySeqnumber() {
		try{
			Map<String, Object> opts=new HashMap<String,Object>();
			sysSeqNumberDao.callDaySeqnumber(opts);
			Object idnum=opts.get("idnum");
			logger.debug("数据库每日全局ID自增长值：{}",idnum);
			return idnum==null?null:Long.valueOf(idnum.toString());
		}catch (Exception e) {
			logger.error("获取数据库每日全局ID自增长值异常",e);
		}
		return Long.valueOf(RandomStringUtils.randomNumeric(6));
	}

	@Override
	public Long daySeqnumber() {
		return Long.valueOf(daySeqnumberString());
	}

	@Override
	public String daySeqnumberString() {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyMMdd");
		StringBuffer sb = new StringBuffer();
		sb.append(sfDate.format(new Date()));
		sb.append(String.format("%06d",getDaySeqnumber()));
		return sb.toString();
	}

	@Override
	public String daySeqnumberString(String prefixStr) {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyMMdd");
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isNotBlank(prefixStr))
		{
			sb.append(prefixStr);
		}
		sb.append(sfDate.format(new Date()));
		sb.append(String.format("%06d",getDaySeqnumber()));
		return sb.toString();
	}

	@Override
	public String daySeqnumberString(String prefixStr, int length) {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMdd");
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isNotBlank(prefixStr))
		{
			sb.append(prefixStr);
		}
		sb.append(sfDate.format(new Date()));
		sb.append(String.format("%0"+(length-8)+"d",getDaySeqnumber()));
		return sb.toString();
	}


}
