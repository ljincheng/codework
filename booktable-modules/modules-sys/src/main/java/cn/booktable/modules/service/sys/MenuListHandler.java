package cn.booktable.modules.service.sys;


import cn.booktable.modules.entity.sys.SysPermissionDo;

/**
 * 菜单数据处理
 * @author ljc
 * @version 1.0
 */
public interface MenuListHandler<T> {

	/**
	 * 处理数据列表
	 * @param sysPer
	 * 菜单
	 * @return
	 */
	public T handler(SysPermissionDo sysPer);

	/**
	 * 添加子菜单
	 * @param parent
	 * 父
	 * @param child
	 * 子
	 * @return
	 */
	public void linkRelations(T parent,T child);
}
