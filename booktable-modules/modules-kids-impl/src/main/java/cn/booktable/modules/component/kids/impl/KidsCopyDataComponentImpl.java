package cn.booktable.modules.component.kids.impl;
import java.util.*;

import cn.booktable.util.DateUtils;
import cn.booktable.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.kids.KidsCopyDataDo; 
import cn.booktable.modules.component.kids.KidsCopyDataComponent;
import cn.booktable.modules.dao.kids.KidsCopyDataDao;

/**
 * 
 * @author ljc
 */
@Component("kidsCopyDataComponent")
public class KidsCopyDataComponentImpl implements KidsCopyDataComponent {

	@Autowired 
	private KidsCopyDataDao kidsCopyDataDao;

	@Override
	public Integer insertKidsCopyData(KidsCopyDataDo kidsCopyDataDo){
		int okTotal=0;
		if(kidsCopyDataDo.getCreateTime() ==null){
	 		kidsCopyDataDo.setCreateTime(new Date());
	 	}
		if(StringUtils.isNotBlank(kidsCopyDataDo.getContent())){

			List<Map<String,String>> rows=strToMap(kidsCopyDataDo.getContent());
			if (rows != null && rows.size() > 0) {

				Date now=new Date();
				for(int i=0,k=rows.size();i<k;i++) {
					Map<String,String> row=rows.get(i);

					KidsCopyDataDo rowData=new KidsCopyDataDo();
					rowData.setTableName(kidsCopyDataDo.getTableName());
					Map<String,Object> rowFieldMap=new HashMap<>();
					for(String key:row.keySet()){
						String value=row.get(key);
						if("create_time".equals(key) || "update_time".equals(key)){
							if("now()".equals(value)){
								rowFieldMap.put(key,now);
							}else {
								rowFieldMap.put(key, DateUtils.parse(row.get(key)));
							}
						}else {
							if(value.startsWith("-int-")) {
								Integer intValue=Integer.valueOf(value.substring(5));
								rowFieldMap.put(key, intValue);
							}else if(value.startsWith("-long-")) {
								Long longValue = Long.valueOf(value.substring(6));
								rowFieldMap.put(key, longValue);
							}else if(value.startsWith("-ytb-w-")){
								String url=value.substring(7);
								String vCode=null;
								if(url.indexOf("/watch?v=")>=0){
									String v=url.substring(url.indexOf("/watch?v=")+9);
									vCode=v;
									if(StringUtils.isNotBlank(v)){
										if(v.indexOf("&")>0){
											vCode=v.substring(0,v.indexOf("&"));
										}
									}
								}
								if (StringUtils.isNotBlank(vCode)) {
									rowFieldMap.put(key, "https://www.youtube.com/watch?v="+vCode);
								}
							}else if(value.startsWith("-ytb-e-")){
								String url=value.substring(7);
								String vCode=null;
								if(url.indexOf("/watch?v=")>=0){
									String v=url.substring(url.indexOf("/watch?v=")+9);
									vCode=v;
									if(StringUtils.isNotBlank(v)){
										if(v.indexOf("&")>0){
											vCode=v.substring(0,v.indexOf("&"));
										}
									}
								}
								if (StringUtils.isNotBlank(vCode)) {
									rowFieldMap.put(key, "https://www.youtube.com/embed/"+vCode);
								}
							}else{
								rowFieldMap.put(key, value);
							}
						}
					}
					rowData.setFieldMap(rowFieldMap);
					try {
						kidsCopyDataDao.insertTableData(rowData);
						okTotal++;
					}catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}
			}
		}

		 kidsCopyDataDao.insert(kidsCopyDataDo);
		return okTotal;
	}

	private List<Map<String,String>> strToMap(String content){
		List<Map<String,String>> list=new ArrayList<>();
		 String[] lineList= content.split("\r\n");
		 if(lineList!=null && lineList.length>0)
		 {
		 	for(int i=0,k=lineList.length;i<k;i++)
			{
				String line=lineList[i];
				int startIndex=line.indexOf("@@DATA@@");
				if(startIndex>=0) {
					String context=line.substring(startIndex+8);
					if (StringUtils.isNotBlank(context)) {
						KeyValueReader reader = new KeyValueReader(context);
						Map<String, String> map = reader.toMap();
						if (map != null) {
							list.add(map);
						}
					}
				}
			}
		 }
		return list;
	}

	@Override
	public List<KidsCopyDataDo> queryKidsCopyDataList(Map<String,Object> selectItem){
		return kidsCopyDataDao.queryList(selectItem);
	}

	@Override
	public PageDo<KidsCopyDataDo> queryKidsCopyDataListPage(Long pageIndex,Integer pageSize,Map<String,Object> selectItem){
		if(selectItem==null){
			selectItem=new HashMap<String,Object>();
		}
		PageDo<KidsCopyDataDo> pageBean=new PageDo<KidsCopyDataDo>(pageIndex, pageSize);
		selectItem.put("page", pageBean);
		pageBean.setPage(kidsCopyDataDao.queryListPage(selectItem));
	 	return pageBean;
	}

	@Override
	public Integer updateKidsCopyDataById(KidsCopyDataDo kidsCopyDataDo){
	
		return kidsCopyDataDao.updateById(kidsCopyDataDo);
	}

	@Override
	public Integer deleteKidsCopyDataById(Long id){
		return kidsCopyDataDao.deleteById(id);
	}

	@Override
	public KidsCopyDataDo findKidsCopyDataById(Long id){
		return kidsCopyDataDao.findById(id);
	}
}