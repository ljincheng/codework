package cn.booktable.modules.component.sys.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.component.sys.SysAttachmentComponent;
import cn.booktable.modules.dao.sys.SysAttachmentDao;
import cn.booktable.modules.entity.sys.SysAttachmentDo;

/**
 * 附件.
 * @author ljc
 * @version  v1.0
 */
@Component("sysAttachmentComponent")
public class SysAttachmentComponentImpl  implements SysAttachmentComponent{

	private SysAttachmentDao sysAttachmentDao;

	@Autowired
	public void setSysAttachmentDao(SysAttachmentDao sysAttachmentDao)
	{
		this.sysAttachmentDao=sysAttachmentDao;
	}


	@Override
	public Integer insertSysAttachment(SysAttachmentDo sysAttachment)
	{
		return sysAttachmentDao.insert(sysAttachment);
	}

	@Override
	public List<SysAttachmentDo> querySysAttachmentList(Map<String,Object> selectItem)
	{
		return sysAttachmentDao.queryList(selectItem);
	}

	@Override
	public PageDo<SysAttachmentDo> querySysAttachmentListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem)
	{
		 if(selectItem==null)
		 {
			 selectItem=new HashMap<String,Object>();
		 }
		 PageDo<SysAttachmentDo> pageBean=new PageDo<SysAttachmentDo>(pageIndex, pageSize);
		 selectItem.put("page", pageBean);
		 pageBean.setPage(sysAttachmentDao.queryListPage(selectItem));
		return pageBean;
	}


	@Override
	public Integer updateSysAttachmentById(SysAttachmentDo sysAttachment)
	{
		return sysAttachmentDao.updateById(sysAttachment);
	}

	@Override
	public Integer deleteSysAttachmentById(Long id)
	{
		return sysAttachmentDao.deleteById(id);
	}

	@Override
	public SysAttachmentDo findSysAttachmentById(Long id)
	{
		return sysAttachmentDao.findById(id);
	}


	@Override
	public Integer updateCheckedStatus(Long id, Integer checkedStatus, Integer updateUserId) {
		return sysAttachmentDao.updateCheckedStatus(id, checkedStatus, updateUserId);
	}
}
