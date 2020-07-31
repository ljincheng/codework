package cn.booktable.modules.service.sys.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.booktable.core.page.PageDo;
import cn.booktable.modules.component.sys.SysAttachmentComponent;
import cn.booktable.modules.entity.sys.SysAttachmentDo;
import cn.booktable.modules.service.sys.SysAttachmentService;

/**
 * 附件.
 * @author ljc
 * @version  v1.0
 */
@Service("sysAttachmentService")
public class SysAttachmentServiceImpl  implements SysAttachmentService{

	private SysAttachmentComponent sysAttachmentComponent;

	@Autowired
	public void setSysAttachmentComponent(SysAttachmentComponent sysAttachmentComponent)
	{
		this.sysAttachmentComponent=sysAttachmentComponent;
	}


	@Override
	public Integer insertSysAttachment(SysAttachmentDo sysAttachment)
	{
		Date now=new Date();
		sysAttachment.setCreateTime(now);
		sysAttachment.setUpdateTime(now);
		return sysAttachmentComponent.insertSysAttachment(sysAttachment);
	}

	@Override
	public List<SysAttachmentDo> querySysAttachmentList(Map<String,Object> selectItem)
	{
		return sysAttachmentComponent.querySysAttachmentList(selectItem);
	}

	@Override
	public PageDo<SysAttachmentDo> querySysAttachmentListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem)
	{
		 return sysAttachmentComponent.querySysAttachmentListPage(pageIndex,pageSize,selectItem);
	}


	@Override
	public Integer updateSysAttachmentById(SysAttachmentDo sysAttachment)
	{
		return sysAttachmentComponent.updateSysAttachmentById(sysAttachment);
	}

	@Override
	public Integer deleteSysAttachmentById(Long id)
	{
		return sysAttachmentComponent.deleteSysAttachmentById(id);
	}

	@Override
	public SysAttachmentDo findSysAttachmentById(Long id)
	{
		return sysAttachmentComponent.findSysAttachmentById(id);
	}


	@Override
	public Integer updateCheckedStatus(Long id, Integer checkedStatus, Integer updateUserId) {
		return sysAttachmentComponent.updateCheckedStatus(id, checkedStatus, updateUserId);
	}

	@Override
	public Integer updateCheckedStatusPass(Long id, Integer updateUserId) {

		return updateCheckedStatus(id,SysAttachmentDo.CHECKEDSTATUS_PASS,updateUserId);
	}
}
