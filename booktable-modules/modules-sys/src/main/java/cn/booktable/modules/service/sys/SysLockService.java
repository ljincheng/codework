package cn.booktable.modules.service.sys;

import java.util.Map;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.sys.SysLockDo;

/**
 * 业务锁服务
 * @author ljc
 * @version 1.0
 */
public interface SysLockService {

	/**
	 * 获取锁
	 * @param lockId 锁ID
	 * @param remark 备注
	 * @return
	 */
	public Boolean getLock(String lockId,String remark);

	/**
	 * 解锁
	 * @param lockId 锁ID
	 * @return
	 */
	public Boolean releaseLock(String lockId);

	/**
	 * 获取防止并发锁表数据集
	 * @param pageIndex
	 * 起始页`
	 * @param pageSize
	 * 每页记录数
	 * @param selectItem
	 * 过滤条件
	 * @return
	 */
	public PageDo<SysLockDo> queryLockListPage(Long pageIndex, Integer pageSize, Map<String,Object> selectItem);

	/**
	 * 根据LockNum删除防止并发锁表.
	 * @param lockNum
	 * @return
	 */
	public Integer deleteLockByLockNum(String lockNum);



}
