package cn.booktable.modules.component.sys.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.component.sys.SysTemplateFileComponent;
import cn.booktable.modules.dao.sys.SysTemplateFileDao;
import cn.booktable.modules.entity.sys.SysTemplateFileDo;

/**
 * 模板文件.
 * @author ljc
 * @version  v1.0
 */
@Component("sysTemplateFileComponent")
public class SysTemplateFileComponentImpl  implements SysTemplateFileComponent{

	private SysTemplateFileDao sysTemplateFileDao;

	@Autowired
	public void setSysTemplateFileDao(SysTemplateFileDao sysTemplateFileDao)
	{
		this.sysTemplateFileDao=sysTemplateFileDao;
	}


	@Override
	public Integer insertSysTemplateFile(SysTemplateFileDo sysTemplateFile)
	{
		return sysTemplateFileDao.insert(sysTemplateFile);
	}

	@Override
	public List<SysTemplateFileDo> querySysTemplateFileList(Map<String,Object> selectItem)
	{
		return sysTemplateFileDao.queryList(selectItem);
	}

	@Override
	public PageDo<SysTemplateFileDo> querySysTemplateFileListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem)
	{
		 if(selectItem==null)
		 {
			 selectItem=new HashMap<String,Object>();
		 }
		 PageDo<SysTemplateFileDo> pageBean=new PageDo<SysTemplateFileDo>(pageIndex, pageSize);
		 selectItem.put("page", pageBean);
		 pageBean.setPage(sysTemplateFileDao.queryListPage(selectItem));
		return pageBean;
	}


	@Override
	public Integer updateSysTemplateFileById(SysTemplateFileDo sysTemplateFile)
	{
		return sysTemplateFileDao.updateById(sysTemplateFile);
	}

	@Override
	public Integer deleteSysTemplateFileById(Long id)
	{
		return sysTemplateFileDao.deleteById(id);
	}

	@Override
	public SysTemplateFileDo findSysTemplateFileById(Long id)
	{
		return sysTemplateFileDao.findById(id);
	}

	@Override
	public SysTemplateFileDo findByFixedId(Integer fixedId) {
		return sysTemplateFileDao.findByFixedId(fixedId);
	}
}
