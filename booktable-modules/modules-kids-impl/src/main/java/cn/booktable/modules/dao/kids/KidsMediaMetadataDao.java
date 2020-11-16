package cn.booktable.modules.dao.kids;

import cn.booktable.modules.entity.kids.EsKidsMediaMetadataBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

import cn.booktable.modules.entity.kids.KidsMediaMetadataDo;

/**
 *
 * @author ljc
 */
@Repository("kidsMediaMetadataDao")
public interface KidsMediaMetadataDao {

	/**
	 * @param kidsMediaMetadataDo
	 * @return
	 */
	public Integer insert(KidsMediaMetadataDo kidsMediaMetadataDo);

	/**
	 * 获取列表
	 * @param selectItem
	 * @return
	 */
	public List<KidsMediaMetadataDo> queryList(Map<String,Object> selectItem);

	/**
	 * 获取分页列表
	 * @param selectItem
	 * @return
	 */
	public List<KidsMediaMetadataDo> queryListPage(Map<String,Object> selectItem);

		/**
	 * 根据id修改
	 * @param kidsMediaMetadataDo
	 * @return
	 */
	public Integer updateById(KidsMediaMetadataDo kidsMediaMetadataDo);

	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public Integer deleteById(Long id);

	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public KidsMediaMetadataDo findById(Long id);

	public Integer countRepeatUrl(Map<String,String> selects);


	/**
	 * 带分类的列表
	 * @param selectItem
	 * @return
	 */
	public List<EsKidsMediaMetadataBo> queryEsKidsMetaList(Map<String,Object> selectItem);

	/**
	 * 匹配ES搜索数据
	 * @param data
	 * @return
	 */
	public List<KidsMediaMetadataDo> 	matchEsKidsMetaList(@Param("datalist") List<EsKidsMediaMetadataBo> data);

}
