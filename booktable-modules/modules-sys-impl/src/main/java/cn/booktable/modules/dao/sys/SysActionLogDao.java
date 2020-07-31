package cn.booktable.modules.dao.sys;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import cn.booktable.modules.entity.sys.SysActionLogDo;

/**
 * 用户活动日志.
 * @author ljc
 * @version  v1.0
 */
@Mapper
public interface SysActionLogDao{

	/**
	 * 添加用户活动日志.
	 * @param sysActionLog
	 * @return
	 */
	public Integer insert(SysActionLogDo sysActionLog);

	/**
	 * 获取用户活动日志数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysActionLogDo> queryList(Map<String, Object> selectItem);

	/**
	 * 获取用户活动日志数据分页列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysActionLogDo> queryListPage(Map<String, Object> selectItem);


	/**
	 * 根据Id修改用户活动日志.
	 * @param sysActionLog
	 * @return
	 */
	public Integer updateById(SysActionLogDo sysActionLog);

	/**
	 * 根据Id删除用户活动日志.
	 * @param id
	 * @return
	 */
	public Integer deleteById(Long id);

	/**
	 * 根据Id获取用户活动日志.
	 * @param id
	 * @return
	 */
	public SysActionLogDo findById(Long id);


}
