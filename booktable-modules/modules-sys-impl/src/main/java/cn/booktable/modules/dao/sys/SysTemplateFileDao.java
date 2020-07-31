package cn.booktable.modules.dao.sys;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import cn.booktable.modules.entity.sys.SysTemplateFileDo;

/**
 * 模板文件.
 * @author ljc
 * @version  v1.0
 */
@Mapper
public interface SysTemplateFileDao{

	/**
	 * 添加模板文件.
	 * @param sysTemplateFile
	 * @return
	 */
	public Integer insert(SysTemplateFileDo sysTemplateFile);

	/**
	 * 获取模板文件数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysTemplateFileDo> queryList(Map<String, Object> selectItem);

	/**
	 * 获取模板文件数据分页列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysTemplateFileDo> queryListPage(Map<String, Object> selectItem);


	/**
	 * 根据Id修改模板文件.
	 * @param sysTemplateFile
	 * @return
	 */
	public Integer updateById(SysTemplateFileDo sysTemplateFile);

	/**
	 * 根据Id删除模板文件.
	 * @param id
	 * @return
	 */
	public Integer deleteById(Long id);

	/**
	 * 根据Id获取模板文件.
	 * @param id
	 * @return
	 */
	public SysTemplateFileDo findById(Long id);

	/**
	 * 根据固定ID获取模板
	 * @param fixedId 固定ID
	 * @return
	 */
	 public SysTemplateFileDo findByFixedId(Integer fixedId);
}
