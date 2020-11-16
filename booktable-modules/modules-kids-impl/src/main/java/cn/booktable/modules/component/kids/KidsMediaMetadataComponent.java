package cn.booktable.modules.component.kids;
import java.util.List;
import java.util.Map;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.kids.EsKidsMediaMetadataBo;
import cn.booktable.modules.entity.kids.KidsMediaMetadataDo;

/**
 *
 * @author ljc
 */
public interface KidsMediaMetadataComponent {

	/**
	 * 添加
	 * @param kidsMediaMetadataDo
	 * @return
	 */
	public Integer insertKidsMediaMetadata(KidsMediaMetadataDo kidsMediaMetadataDo);

	/**
	 * 获取列表
	 * @param selectItem
	 * @return
	 */
	public List<KidsMediaMetadataDo> queryKidsMediaMetadataList(Map<String,Object> selectItem);

	/**
	 * 获取分页列表
	 * @param pageIndex 起始页
	 * @param pageSize 每页记录数
	 * @param selectItem 过滤条件
	 * @return
	 */
	public PageDo<KidsMediaMetadataDo> queryKidsMediaMetadataListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem);

	/**
	 * 根据id修改
	 * @param kidsMediaMetadataDo
	 * @return
	 */
	public Integer updateKidsMediaMetadataById(KidsMediaMetadataDo kidsMediaMetadataDo);

	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public Integer deleteKidsMediaMetadataById(Long id);

	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public KidsMediaMetadataDo findKidsMediaMetadataById(Long id);


	/**
	 * 带分类的列表
	 * @param selectItem
	 * @return
	 */
	public List<EsKidsMediaMetadataBo> queryEsKidsMetaList(Map<String,Object> selectItem);

	/**
	 * 匹配ES探索数据
	 * @return
	 */
	public List<KidsMediaMetadataDo> 	matchEsKidsMetaList(List<EsKidsMediaMetadataBo> data);


}
