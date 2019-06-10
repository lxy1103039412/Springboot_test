package com.service;

import com.base.ServiceContain;
import com.pojo.User;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created on 2018.06.11.
 */
@Service
public class UserService extends ServiceContain {


    //登录
    public SiteResponse search(User user) {

        List<User> userList = userMapper.search(user);
        if (userList.size() == 0) {
            return returnResponse("用户名或密码错误", false);
        } else {
            for (User user2 :userList) {
                user.setId(user2.getId());
            }
            //使用session设置用户id
            HttpSession sessionUser=request.getSession();
            sessionUser.setAttribute("userId",user);
//            Object userId2=session.getAttribute("userId");
//            System.out.println(userId2);
//            String id1=String.valueOf(userId2.getId());
//            int id=Integer.valueOf(id1);
//            System.out.println(id);
            //设置状态
            userMapper.update(user);
            return returnResponse(userList, "登陆成功", true);
        }
    }

    //注册
    public SiteResponse insert(User user) {
        //判断密码是否合格
//        String pattern="[0-9]{8,10}";
//        if(Pattern.matches(pattern,pwd)==false&&Pattern.matches(pattern,name)==false){
//            return returnResponse("用户名或密码格式不符合规范", true);
//        }else {
//            List<User> userList = userMapper.search(user);
//            if(userList.size()==0){
//                userMapper.insert(user);
//                return returnResponse("注册成功", true);
//            }else {
//                return returnResponse("用户名已存在", true);
//            }
//        }
        List<User> userList = userMapper.register(user);
        if(userList.size()==0){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time=df.format(new Date());
            user.setCreate_time(time);
            userMapper.insert(user);
            return returnResponse("注册成功", true);
        }else {
            return returnResponse("用户名已存在", false);
        }
    }

    //删
   public SiteResponse delete(User user) {
        int id1=1;
        user.setId((long)id1);
        arr[0]=id1;
       userMapper.delete(user);
       return returnResponse("删除了id为1的记录", "删除成功", true);

   }
    //登出
    public SiteResponse update (User user) {
        HttpSession session1=request.getSession();
        session1.removeAttribute("userId");
        userMapper.loginOut(user);
        return returnResponse( "登出成功", true);
    }






}
