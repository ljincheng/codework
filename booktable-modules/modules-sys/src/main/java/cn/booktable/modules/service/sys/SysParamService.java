package cn.booktable.modules.service.sys;

import java.util.Map;

import cn.booktable.modules.entity.sys.SysParamDo;
import cn.booktable.core.page.PageDo;

/**
 * 系统参数
 */
public interface SysParamService {

	Integer insert(SysParamDo sysParamDo);

	Integer update(SysParamDo sysParamDo);

	Integer delete(String paramId);

	SysParamDo queryById(String paramId);

	/**
	 * 根据编号找参数
	 * @param paramCode
	 * @return
	 */
	SysParamDo queryByCode(String paramCode);

	PageDo<SysParamDo> queryListPage(Map<String, Object> selectItem);

	String queryValueByCode(String paramCode);
}

