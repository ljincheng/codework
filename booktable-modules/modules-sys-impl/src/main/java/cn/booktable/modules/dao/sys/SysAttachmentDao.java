package cn.booktable.modules.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import cn.booktable.modules.entity.sys.SysAttachmentDo;

/**
 * 附件.
 * @author ljc
 * @version  v1.0
 */
@Mapper
public interface SysAttachmentDao{

	/**
	 * 添加附件.
	 * @param sysAttachment
	 * @return
	 */
	public Integer insert(SysAttachmentDo sysAttachment);

	/**
	 * 获取附件数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysAttachmentDo> queryList(Map<String,Object> selectItem);

	/**
	 * 获取附件数据分页列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysAttachmentDo> queryListPage(Map<String,Object> selectItem);


	/**
	 * 根据Id修改附件.
	 * @param sysAttachment
	 * @return
	 */
	public Integer updateById(SysAttachmentDo sysAttachment);

	/**
	 * 根据Id删除附件.
	 * @param id
	 * @return
	 */
	public Integer deleteById(Long id);

	/**
	 * 根据Id获取附件.
	 * @param id
	 * @return
	 */
	public SysAttachmentDo findById(Long id);

	/**
	 * 更新核对状态
	 * @param id 记录ID
	 * @param checkedStatus 核对状态
	 * @param updateUserId 更新用户者ID
	 * @return
	 */
	public Integer updateCheckedStatus(@Param("id")Long id,@Param("checkedStatus")Integer checkedStatus,@Param("updateUserId")Integer updateUserId);
}
