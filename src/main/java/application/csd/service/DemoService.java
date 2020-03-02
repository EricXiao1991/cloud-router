package application.csd.service;


import application.csd.dao.interfaces.com.ComDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vo.pojo.PageData;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService  {



    @Resource
    private ComDao comDao;


    /**
     * 示例
     * @author zbb
     * @return
     * @throws Exception
     */
    public PageData loadUserByKey(PageData param) throws Exception{
        PageData user = comDao.loadUserByKey(param);
        return user;
    }




    /**
     * 示例
     * @author zbb
     * @return
     * @throws Exception
     */
    public PageData loadLogData(PageData param) throws Exception{
        PageData data=new PageData();
        List<PageData> list=null;
        int resultCount=comDao.loadLogDataCount(param   );
        if(resultCount>0){
            list=comDao.loadLogDataList(param    );
            data.put("list",list);
        }
        data.put("resultCount",resultCount);
        return data;
    }

}
