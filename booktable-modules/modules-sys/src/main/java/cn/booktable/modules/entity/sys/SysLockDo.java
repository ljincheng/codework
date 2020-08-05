package cn.booktable.modules.entity.sys;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

@Alias("sysLockDo")
public class SysLockDo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String lockNum;//需锁定的主键
	private Date createTime;
	private String remark;//备注
	/**
	 * 需锁定的主键.
	 *
	 * @return  the lockNum
	 * @author xiezbmf
	 * Date:2016年11月17日上午9:08:26 <br/>
	 */
	public String getLockNum() {
		return lockNum;
	}
	/**
	 * 需锁定的主键.
	 *
	 * @param   lockNum    the lockNum to set
	 * @author xiezbmf
	 * Date:2016年11月17日上午9:08:26 <br/>
	 */
	public void setLockNum(String lockNum) {
		this.lockNum = lockNum;
	}
	/**
	 * createTime.
	 *
	 * @return  the createTime
	 * @author xiezbmf
	 * Date:2016年11月17日上午9:08:26 <br/>
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * createTime.
	 *
	 * @param   createTime    the createTime to set
	 * @author xiezbmf
	 * Date:2016年11月17日上午9:08:26 <br/>
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 备注.
	 *
	 * @return  the remark
	 * @author xiezbmf
	 * Date:2016年11月17日上午9:08:26 <br/>
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 备注.
	 *
	 * @param   remark    the remark to set
	 * @author xiezbmf
	 * Date:2016年11月17日上午9:08:26 <br/>
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}


}
