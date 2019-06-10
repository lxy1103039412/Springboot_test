package com.base;

import com.mapper.LogMapper;
import com.mapper.UploadMapper;
import com.pojo.other.SiteResponse;
import com.service.DemandsService;
import com.service.TaskService;
import com.service.UploadService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by li on 2017/11/27.
 */
public class ServiceContain extends MapperContain {
    //用户
    @Autowired
    public UserService userService;
    @Autowired
    public DemandsService demandsService;
    @Autowired
    public TaskService taskService;
    @Autowired
    public UploadService uploadService;
    @Autowired
    public HttpSession session;
    @Autowired
    public HttpServletRequest request;
    @Autowired
    public ApplicationContext applicationContext;
    @Autowired
    public LogMapper logMapper;
    @Autowired
    public static int arr[]=new int[20];
    @Autowired
    public UploadMapper uploadMapper;



    //返回前端数据
    public SiteResponse returnResponse(Object data, String msg, Boolean state) {
        SiteResponse siteResponse = new SiteResponse();
        siteResponse.map.put("data", data);
        siteResponse.setMsg(msg);
        siteResponse.setState(state);
        return siteResponse;
    }
    //重写
    public SiteResponse returnResponse( String msg, Boolean state) {
        SiteResponse siteResponse = new SiteResponse();
        siteResponse.setMsg(msg);
        siteResponse.setState(state);
        return siteResponse;
    }
    //返回两个data
    public SiteResponse returnResponse(Object data1,Object data2,String msg,Boolean state){
        SiteResponse siteResponse = new SiteResponse();
        siteResponse.map.put("data1", data1);
        siteResponse.map.put("data2", data2);
        siteResponse.setMsg(msg);
        siteResponse.setState(state);
        return siteResponse;
    }
}
