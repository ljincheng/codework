package cn.booktable.modules.component.sys;


/**
 * 全局唯一ID
 * @author ljc
 * @version 1.0
 */
public interface SysSeqNumberComponent {


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

	/**
	 * 每日自增长字符串
	 * @param prefixStr 前缀
	 * @param length 长度
	 * @return
	 */
	public String daySeqnumberString(String prefixStr,int length);

}
