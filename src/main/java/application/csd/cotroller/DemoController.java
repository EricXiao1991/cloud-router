package application.csd.cotroller;


import application.csd.service.DemoService;
import cn.hutool.core.io.IoUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import vo.pojo.PageData;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


/****
 * controller示例
 * java -jar path
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoController {


    Gson gson=new Gson();
    @Resource
    DemoService demoService;

    /***
     * 页面跳转
     * @return
     */
    @RequestMapping(value = "/index")
    public String demoIndex(){
        System.out.println("访问页面成功-index.html！！！");
        return "index";
    }


    /***
     * 请求接口（返回json格式）
     * @param mv
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value="/checkUser" ,produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object checkUser(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Map<String,Object> result=new HashMap<String,Object>();
        try{
            //请求处理
            System.out.println("接口请求成功!!!!!!!!!!!");

            String body= IoUtil.read(request.getInputStream(),"utf-8");
            if(StringUtils.isBlank(body)){
                result.put("success", false);
                result.put("message", "登录失败，用户名、密码不正确！");
                return result;
            }

            PageData param=gson.fromJson(body,PageData.class);
            System.out.println("body="+body);

            PageData user=demoService.loadUserByKey(param);
            //结果封装
            if(user==null){
                result.put("success", false);
                result.put("message", "登录失败，用户不存在！");
                return result;
            }
            result.put("user", user);
            result.put("token", user.getString("id"));
            result.put("success", true);
            result.put("message", "登录成功！");
        }catch(Exception e){
            //结果封装
            result.put("success", false);
            result.put("message", "登录失败，系统异常！");
            e.printStackTrace();
        }finally{
            //各种通道关闭

        }
        return result;
    }



    /***
     * 请求接口（返回json格式）
     * @param mv
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value="/loadLogData" ,produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object loadLogData(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Map<String,Object> result=new HashMap<String,Object>();
        try{
            //请求处理
            System.out.println("接口请求成功!!!!!!!!!!!");
            PageData param=new PageData();
            param.put("log_type",request.getParameter("log_type"));
            param.put("username",request.getParameter("username"));
            param.put("log_time_begin",request.getParameter("log_time_begin"));
            param.put("log_time_end",request.getParameter("log_time_end"));
            param.put("xm",request.getParameter("xm"));
            param.put("pageNo",request.getParameter("pageNo"));
            param.put("pageSize",request.getParameter("pageSize"));
            param.put("pageNo",param.getInt("pageNo"));
            param.put("pageSize",param.getInt("pageSize"));
            param.put("start",param.getStartNum(param.getInt("pageNo"),param.getInt("pageSize")));

            PageData data=demoService.loadLogData(param);
            result.put("pageNo",param.getInt("pageNo"));
            result.put("pageSize",param.getInt("pageSize"));
            result.put("list",data.get("list"));
            result.put("resultCount",data.get("resultCount"));
            result.put("success", true);
        }catch(Exception e){
            //结果封装
            result.put("success", false);
            e.printStackTrace();
        }finally{
            //各种通道关闭

        }
        return result;
    }



}


