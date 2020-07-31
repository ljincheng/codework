/**
 * Project Name:jcpt-common <br>
 * File Name:LockDao.java <br>
 * Package Name:com.hehenian.jcpt.dao.biz <br>
 * @author xiezbmf
 * Date:2016年11月14日下午3:31:32 <br>
 * Copyright (c) 2016, 深圳市彩付宝网络技术有限公司 All Rights Reserved.
 */

package cn.booktable.modules.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import cn.booktable.modules.entity.sys.LockDo;

/**
 * ClassName: LockDao <br>
 * Description: TODO
 * @author xiezbmf
 * Date:2016年11月14日下午3:31:32 <br>
 * @version
 * @since JDK 1.6
 */
@Mapper
public interface LockDao {

	Integer	addLock(LockDo lockDo);

	Integer delLock(@Param("lockNum")String lockNum);

	LockDo findLock(String lockNum);

	/**
	 * 获取防止并发锁表数据分页列表.
	 * @param selectItem
	 * @return
	 * @author ljc
	 */
	public List<LockDo> queryListPage(Map<String,Object> selectItem);


	/**
	 * 根据LockNum删除防止并发锁表.
	 * @param lockNum
	 * @return
	 * @author ljc
	 */
	public Integer deleteByLockNum(String lockNum);



}

