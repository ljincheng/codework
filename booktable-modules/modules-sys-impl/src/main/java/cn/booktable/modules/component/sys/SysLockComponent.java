package cn.booktable.modules.component.sys;

import java.util.Map;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.sys.SysLockDo;

/**
 * 业务锁
 * @author ljc
 * @version 1.0
 */
public interface SysLockComponent {

	/**
	 * 查找锁
	 * @param lockNum 锁编号
	 * @return
	 */
	SysLockDo findLock(String lockNum);

	/**
	 * 增加一条记录锁
	 * @param lock
	 * @return
	 */
	Integer addLock(SysLockDo lock);

	/**
	 * 删除一条记录锁
	 * @param lockNum
	 * @return
	 */
	Integer deleteLock(String lockNum);

	/**
	 * 获取防止并发锁表数据集
	 * @param pageIndex
	 * 起始页
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
