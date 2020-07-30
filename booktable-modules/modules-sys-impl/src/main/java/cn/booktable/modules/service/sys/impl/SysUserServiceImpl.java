package cn.booktable.modules.service.sys.impl;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.service.sys.SysUserService;
import cn.booktable.modules.component.sys.SysUserComponent;

import cn.booktable.modules.entity.sys.SysUserEntity;
import java.util.Date;

/**
 *
 * @author sys
 * @version v1.0
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserComponent sysUserComponent;


    @Override
    public Integer insertSysUser(SysUserEntity sysUserEntity){
        return sysUserComponent.insertSysUser(sysUserEntity);
    }

    @Override
    public List<SysUserEntity> querySysUserList(Map<String,Object> selectItem){
        return sysUserComponent.querySysUserList(selectItem);
    }

    @Override
    public PageDo<SysUserEntity> querySysUserListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem){
        return sysUserComponent.querySysUserListPage(pageIndex,pageSize,selectItem);
    }

    @Override
    public Integer updateSysUserById(SysUserEntity sysUserEntity){
        return sysUserComponent.updateSysUserById(sysUserEntity);
    }

    @Override
    public Integer deleteSysUserById(Integer id){
        return sysUserComponent.deleteSysUserById(id);
    }

    @Override
    public SysUserEntity findSysUserById(Integer id){
        return sysUserComponent.findSysUserById(id);
    }


}