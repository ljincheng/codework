package cn.booktable.modules.dao.sys;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


/**
 * 系统全局唯一ID
 * @author ljc
 * @version 1.0
 */
@Mapper
public interface SysSeqNumberDao {

	public Long callDaySeqnumber(Map<String, Object> parameterMap);
}

