package cn.booktable.modules.service.sys.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.booktable.core.page.PageDo;
import cn.booktable.modules.component.sys.SysTemplateFileComponent;
import cn.booktable.modules.entity.sys.SysTemplateFileDo;
import cn.booktable.modules.service.sys.SysTemplateFileService;

/**
 * 模板文件.
 * @author ljc
 * @version  v1.0
 */
@Service("sysTemplateFileService")
public class SysTemplateFileServiceImpl  implements SysTemplateFileService{

	private SysTemplateFileComponent sysTemplateFileComponent;

	@Autowired
	public void setSysTemplateFileComponent(SysTemplateFileComponent sysTemplateFileComponent)
	{
		this.sysTemplateFileComponent=sysTemplateFileComponent;
	}


	@Override
	public Integer insertSysTemplateFile(SysTemplateFileDo sysTemplateFile)
	{
		Date now=new Date();
		sysTemplateFile.setCreateTime(now);
		sysTemplateFile.setUpdateTime(now);
		return sysTemplateFileComponent.insertSysTemplateFile(sysTemplateFile);
	}

	@Override
	public List<SysTemplateFileDo> querySysTemplateFileList(Map<String,Object> selectItem)
	{
		return sysTemplateFileComponent.querySysTemplateFileList(selectItem);
	}

	@Override
	public PageDo<SysTemplateFileDo> querySysTemplateFileListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem)
	{
		 return sysTemplateFileComponent.querySysTemplateFileListPage(pageIndex,pageSize,selectItem);
	}


	@Override
	public Integer updateSysTemplateFileById(SysTemplateFileDo sysTemplateFile)
	{
		Date now=new Date();
		sysTemplateFile.setUpdateTime(now);
		return sysTemplateFileComponent.updateSysTemplateFileById(sysTemplateFile);
	}

	@Override
	public Integer deleteSysTemplateFileById(Long id)
	{
		return sysTemplateFileComponent.deleteSysTemplateFileById(id);
	}

	@Override
	public SysTemplateFileDo findSysTemplateFileById(Long id)
	{
		return sysTemplateFileComponent.findSysTemplateFileById(id);
	}

	@Override
	public SysTemplateFileDo findByFixedId(Integer fixedId) {
		return sysTemplateFileComponent.findByFixedId(fixedId);
	}
}
