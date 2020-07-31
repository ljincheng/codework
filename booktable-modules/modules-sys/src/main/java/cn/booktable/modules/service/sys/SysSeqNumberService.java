package cn.booktable.modules.service.sys;

/**
 * 全局唯一ID
 * @author ljc
 * @version 1.0
 */
public interface SysSeqNumberService {

	/**
	 * 每日自增长值
	 * @return
	 */
	public Long daySeqnumber();

	/**
	 * 每日自增长值字符串
	 * @return
	 */
	public String daySeqnumberString();

	/**
	 * 每日自增长值字符串
	 * @param prefixStr 前缀
	 * @return
	 */
	public String daySeqnumberString(String prefixStr);
}
