package com.controller;

import com.base.ServiceContain;
import com.pojo.User;
import com.pojo.other.SiteResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;


/**
 * Created on 2018.06.11.
 */
// @RequestMapping("/api/user") 和方法的value写在请求的路径,服务器localhost 端口号在target里面找(默认2019)  方法对应method 的get,post,put
@Controller
@RequestMapping("/api/user")
public class UserController extends ServiceContain {

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse search(@RequestBody User user) {
//            user.setName("11111111");
//            user.setPassword("11111111");
            System.out.println("用户名："+user.getUserName()+"密码"+user.getPassword());
            return userService.search(user);
    }
    //注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse insert(@RequestBody User user) {

        String pattern="[0-9]{8,10}";
        String pattern2="[\\u4E00-\\u9FA5]{2,}";
        System.out.println("用户名："+user.getName()+"密码:"+user.getPassword()+"姓名"+user.getName()+"(未判定)");
        if(Pattern.matches(pattern,user.getPassword())==true&&Pattern.matches(pattern,user.getUserName())==true&&Pattern.matches(pattern2,user.getName())==true){
            System.out.println("用户名："+user.getName()+"密码:"+user.getPassword()+"姓名"+user.getName()+"**********************************");
            return userService.insert(user);
        }else {
            return returnResponse("用户名、密码或真实姓名格式不符合规范", false);
        }

    }
    //删除数据
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public SiteResponse delete(@ModelAttribute User user) {
        return userService.delete(user);

    }
    //登出
    @RequestMapping(value = "/loginOut",method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse update(@RequestBody User user) {
        //System.out.println(user.getId());
        return userService.update(user);
    }


}
