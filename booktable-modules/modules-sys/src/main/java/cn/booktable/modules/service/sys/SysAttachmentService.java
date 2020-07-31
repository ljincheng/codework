package cn.booktable.modules.service.sys;

import java.util.List;
import java.util.Map;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.sys.SysAttachmentDo;

/**
 * 附件.
 * @author ljc
 * @version  v1.0
 */
public interface SysAttachmentService {

	/**
	 * 添加附件.
	 * @param sysAttachment
	 * @return
	 */
	public Integer insertSysAttachment(SysAttachmentDo sysAttachment);

	/**
	 * 获取附件数据列表.
	 * @param selectItem
	 * @return
	 */
	public List<SysAttachmentDo> querySysAttachmentList(Map<String,Object> selectItem);

	/**
	 * 获取附件数据集
	 * @param pageIndex
	 * 起始页
	 * @param pageSize
	 * 每页记录数
	 * @param selectItem
	 * 过滤条件
	 * @return
	 */
	public PageDo<SysAttachmentDo> querySysAttachmentListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem);

	/**
	 * 根据Id修改附件.
	 * @param sysAttachment
	 * @return
	 */
	public Integer updateSysAttachmentById(SysAttachmentDo sysAttachment);

	/**
	 * 根据Id删除附件.
	 * @param id
	 * @return
	 */
	public Integer deleteSysAttachmentById(Long id);

	/**
	 * 根据Id获取附件.
	 * @param id
	 * @return
	 */
	public SysAttachmentDo findSysAttachmentById(Long id);

	/**
	 * 更新核对状态
	 * @param id 记录ID
	 * @param checkedStatus 核对状态
	 * @param updateUserId 更新用户者ID
	 * @return
	 */
	public Integer updateCheckedStatus(Long id,Integer checkedStatus,Integer updateUserId);


	/**
	 * 修改为通过状态
	 * @param id
	 * @param updateUserId
	 * @return
	 */
	public Integer updateCheckedStatusPass(Long id, Integer updateUserId);



}
