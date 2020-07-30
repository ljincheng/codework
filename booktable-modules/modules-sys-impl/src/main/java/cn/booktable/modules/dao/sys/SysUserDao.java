package cn.booktable.modules.dao.sys;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.sys.SysUserEntity;

/**
 *
 * @author sys
 * @version v1.0
 */
@Mapper
public interface SysUserDao {

    /**
     * 添加
     * @param sysUserEntity
     * @return
     */
    public Integer insert(SysUserEntity sysUserEntity);

    /**
     * 获取列表
     * @param selectItem
     * @return
     */
    public List<SysUserEntity> queryList(Map<String,Object> selectItem);

    /**
     * 获取分页列表
     * @param selectItem
     * @return
     */
    public List<SysUserEntity> queryListPage(Map<String,Object> selectItem);

    /**
     * 根据id修改
     * @param sysUserEntity
     * @return
     */
    public Integer updateById(SysUserEntity sysUserEntity);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public Integer deleteById(Integer id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public SysUserEntity findById(Integer id);


}