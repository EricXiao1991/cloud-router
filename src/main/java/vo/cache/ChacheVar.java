package vo.cache;


import vo.pojo.PageData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/***
 * 数据字典缓存
 * 系统启动时由DictionaryCacheListener进行初始化加载到内存
 * @author fk
 *
 */
public class ChacheVar {
	
	//缓存任意对象
	public static Map<String ,Object> chacheObject = new HashMap<String, Object>();
	//缓存字符串对象
	public static Map<String ,String> chacheString = new HashMap<String, String>();
	
	//缓存Map对象
	public static Map<String ,Map<String,Object>> chacheMap = new HashMap<String, Map<String,Object>>();
	//缓存PageData对象
	public static Map<String , PageData> chachePageData = new HashMap<String, PageData>();
	
	//缓存Map对象集合
	public static Map<String ,List<Map<String,Object>>> chacheMapList = new HashMap<String, List<Map<String,Object>>>();
	//缓存PageData对象集合
	public static Map<String ,List<PageData>> chachePageDataList = new HashMap<String, List<PageData>>();
	

	
}
