package cn.booktable.modules.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.booktable.modules.entity.sys.SysOperateLogDo;

/**
 * 用户操作日志
 * @author: sungymf
 * @date: 2017年7月14日 上午6:39:47
 */
@Mapper
public interface SysOperateLogDao {

	/**
	 * 添加.
	 * @param SysOperateLog
	 * @return
	 */
	public Integer insert(SysOperateLogDo sysOperateLogDo);

	/**
	 * 获取数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysOperateLogDo> queryList(Map<String,Object> selectItem);

	/**
	 * 获取数据集
	 * @param pageIndex
	 * 起始页
	 * @param pageSize
	 * 每页记录数
	 * @param selectItem
	 * 过滤条件
	 * @return
	 */
	public List<SysOperateLogDo> queryListPage(Map<String,Object> selectItem);

	/**
	 * 根据Id修改
	 * @param SysOperateLog
	 * @return
	 */
	public Integer updateById(SysOperateLogDo sysOperateLogDo);

	/**
	 * 根据Id删除
	 * @param id
	 * @return
	 */
	public Integer deleteById(Long id);

	/**
	 * 根据Id获取
	 * @param id
	 * @return
	 */
	public SysOperateLogDo findById(Long id);
}
