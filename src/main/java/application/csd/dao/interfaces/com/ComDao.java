package application.csd.dao.interfaces.com;


import vo.pojo.PageData;

import java.util.List;


public interface ComDao{



	/***
	 *
	 */
	PageData loadUserByKey(PageData param) throws Exception;




	/***
	 *
	 */
	List<PageData> loadLogDataList(PageData param) throws Exception;



	/***
	 *
	 */
	int loadLogDataCount(PageData param) throws Exception;




}