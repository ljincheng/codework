package cn.booktable.modules.service.sys;
import java.util.List;
import java.util.Map;
import java.util.Date;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.sys.SysUserEntity;

/**
 *
 * @author sys
 * @version v1.0
 */
public interface SysUserService {

    /**
     * 添加
     * @param sysUserEntity
     * @return
     */
    public Integer insertSysUser(SysUserEntity sysUserEntity);

    /**
     * 获取列表
     * @param selectItem
     * @return
     */
    public List<SysUserEntity> querySysUserList(Map<String,Object> selectItem);

    /**
     * 获取分页列表
     * @param pageIndex 起始页
     * @param pageSize 每页记录数
     * @param selectItem 过滤条件
     * @return
     */
    public PageDo<SysUserEntity> querySysUserListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem);

    /**
     * 根据id修改
     * @param sysUserEntity
     * @return
     */
    public Integer updateSysUserById(SysUserEntity sysUserEntity);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public Integer deleteSysUserById(Integer id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public SysUserEntity findSysUserById(Integer id);


}