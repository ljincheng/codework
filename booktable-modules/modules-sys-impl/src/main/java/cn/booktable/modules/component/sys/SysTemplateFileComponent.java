package cn.booktable.modules.component.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.sys.SysTemplateFileDo;

/**
 * 模板文件.
 * @author ljc
 * @version  v1.0
 */
public interface SysTemplateFileComponent {

	/**
	 * 添加模板文件.
	 * @param sysTemplateFile
	 * @return
	 */
	public Integer insertSysTemplateFile(SysTemplateFileDo sysTemplateFile);

	/**
	 * 获取模板文件数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysTemplateFileDo> querySysTemplateFileList(Map<String, Object> selectItem);

	/**
	 * 获取模板文件数据集
	 * @param pageIndex
	 * 起始页
	 * @param pageSize
	 * 每页记录数
	 * @param selectItem
	 * 过滤条件
	 * @return
	 */
	public PageDo<SysTemplateFileDo> querySysTemplateFileListPage(Long pageIndex, Integer pageSize, Map<String, Object> selectItem);

	/**
	 * 根据Id修改模板文件.
	 * @param sysTemplateFile
	 * @return
	 */
	public Integer updateSysTemplateFileById(SysTemplateFileDo sysTemplateFile);

	/**
	 * 根据Id删除模板文件.
	 * @param id
	 * @return
	 */
	public Integer deleteSysTemplateFileById(Long id);

	/**
	 * 根据Id获取模板文件.
	 * @param id
	 * @return
	 */
	public SysTemplateFileDo findSysTemplateFileById(Long id);

	/**
	 * 根据固定ID获取模板
	 * @param fixedId 固定ID
	 * @return
	 */
	public SysTemplateFileDo findByFixedId(Integer fixedId);
}
