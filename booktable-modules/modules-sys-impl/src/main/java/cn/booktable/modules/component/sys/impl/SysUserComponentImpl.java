package cn.booktable.modules.component.sys.impl;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.component.sys.SysUserComponent;
import cn.booktable.modules.dao.sys.SysUserDao;

import cn.booktable.modules.entity.sys.SysUserEntity;
import java.util.Date;

/**
 *
 * @author sys
 * @version v1.0
 */
@Component("sysUserComponent")
public class SysUserComponentImpl implements SysUserComponent {

    @Autowired
    private SysUserDao sysUserDao;


    @Override
    public Integer insertSysUser(SysUserEntity sysUserEntity){
        return sysUserDao.insert(sysUserEntity);
    }

    @Override
    public List<SysUserEntity> querySysUserList(Map<String,Object> selectItem){
        return sysUserDao.queryList(selectItem);
    }

    @Override
    public PageDo<SysUserEntity> querySysUserListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem){
        if(selectItem==null){
            selectItem=new HashMap<String,Object>();
        }
        PageDo<SysUserEntity> pageBean=new PageDo<SysUserEntity>(pageIndex, pageSize);
        selectItem.put("page", pageBean);
        pageBean.setPage(sysUserDao.queryListPage(selectItem));
        return pageBean;
    }

    @Override
    public Integer updateSysUserById(SysUserEntity sysUserEntity){
        return sysUserDao.updateById(sysUserEntity);
    }

    @Override
    public Integer deleteSysUserById(Integer id){
        return sysUserDao.deleteById(id);
    }

    @Override
    public SysUserEntity findSysUserById(Integer id){
        return sysUserDao.findById(id);
    }


}