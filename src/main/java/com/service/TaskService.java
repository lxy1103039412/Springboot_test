package com.service;

import com.base.ServiceContain;
import com.pojo.Task;
import com.pojo.User;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TaskService extends ServiceContain {
    //查询
    public SiteResponse search(Task task){
        List<Task> taskList = taskMapper.search(task);
        return returnResponse(taskList,"查询成功",true);
    }
    //发布
    public SiteResponse insert(Task task){
        //通过session获取id
        HttpSession sessionUser5=request.getSession();
        User user1=(User) sessionUser5.getAttribute("userId");
        String creator=String.valueOf(user1.getId());
        int creator2=Integer.valueOf(creator);
        task.setCreator(creator2);
        //时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=df.format(new Date());
        task.setCreate_time(time);

        taskMapper.insert(task);
        return returnResponse("增加成功",true);
    }
    //删除
    public SiteResponse delete(Task task){
        taskMapper.delete(task);
        return  returnResponse("删除成功",true);
    }
    //修改
    public SiteResponse update(Task task){
        taskMapper.update(task);
        return returnResponse("修改成功",true);
    }

    //接受
    public SiteResponse accept(Task task){
        //通过session获取id
        HttpSession sessionUser4=request.getSession();
        User user1=(User) sessionUser4.getAttribute("userId");
        String creator=String.valueOf(user1.getId());
        int executor=Integer.valueOf(creator);
        task.setExecutor(executor);
        //时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=df.format(new Date());
        task.setStart_time(time);
        taskMapper.accept(task);
        return returnResponse("接受成功",true);
    }
    //个人中心 接受
    public SiteResponse myAccept(Task task){
        //通过session获取id
        HttpSession sessionUser3=request.getSession();
        User user1=(User) sessionUser3.getAttribute("userId");
        String id=String.valueOf(user1.getId());
        int executor=Integer.valueOf(id);
        System.out.println(executor);
        task.setExecutor(executor);

        List <Task> myAccept=taskMapper.myAccept(task);
        return returnResponse(myAccept,"查询成功",true);
    }
    //个人中心 发布
    public SiteResponse myRelease(Task task){
        //通过session获取id
        HttpSession sessionUser2=request.getSession();
        User user1=(User) sessionUser2.getAttribute("userId");
        String creator=String.valueOf(user1.getId());
        int creator2=Integer.valueOf(creator);
        task.setCreator(creator2);

        List <Task> myRelease=taskMapper.myRelease(task);
        return returnResponse(myRelease,"查询成功",true);
    }
    //详情
    public SiteResponse details(Task task){
        List<Task> detailsList=taskMapper.details(task);
        return returnResponse(detailsList,"查询成功",true);
    }
    //分页
    public SiteResponse paging (Task task){
        List<Task> pagingList=taskMapper.paging(task);
        //List<Task> taskList = taskMapper.search(task);
        int length=taskMapper.length(task);
        System.out.println(length);
        //String length=String.valueOf(taskList.size());
        return returnResponse(pagingList,length,"成功",true);
    }
    //长度
    public SiteResponse length(Task task){
        int length=taskMapper.length(task);
//        List<Task> taskList = taskMapper.search(task);
//        int length=taskList.size();
        System.out.println(length);
        return returnResponse(length,"长度",true);
    }
}
