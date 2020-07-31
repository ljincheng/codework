package cn.booktable.modules.component.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.SysOperateLogDo;
import cn.booktable.core.page.PageDo;

/**
 * 用户操作日志
 * @author: sungymf
 * @date: 2017年7月14日 上午6:08:17
 */
public interface SysOperateLogComponent {


	/**
	 * 添加.
	 * @param SysOperateLog
	 * @return
	 */
	public Integer insertSysOperateLog(SysOperateLogDo sysOperateLogDo);

	/**
	 * 获取数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysOperateLogDo> querySysOperateLogList(Map<String,Object> selectItem);

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
	public PageDo<SysOperateLogDo> querySysOperateLogListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem);

	/**
	 * 根据Id修改
	 * @param SysOperateLog
	 * @return
	 */
	public Integer updateSysOperateLogById(SysOperateLogDo sysOperateLogDo);

	/**
	 * 根据Id删除
	 * @param id
	 * @return
	 */
	public Integer deleteSysOperateLogById(Long id);

	/**
	 * 根据Id获取
	 * @param id
	 * @return
	 */
	public SysOperateLogDo findSysOperateLogById(Long id);
}
