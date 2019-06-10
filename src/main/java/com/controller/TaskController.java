package com.controller;

import com.base.ServiceContain;
import com.pojo.Task;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Character.getType;


@Controller
@RequestMapping("/api/task")
public class TaskController extends ServiceContain {
    //查询
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public SiteResponse search(Task task) {
        return taskService.search(task);
    }
    //发布
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse insert(@RequestBody Task task){
        if(task.getName()==null||task.getContent()==null){
            return returnResponse("增加失败",false);
        }else {
            return taskService.insert(task);
        }
    }
    //删除
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    @ResponseBody
    public SiteResponse delete(@RequestBody Task task){
        if(task.getId()==0){
            return returnResponse("删除失败",false);
        }else {
            if (task.getState() == 1) {
                return returnResponse("无法删除已完成的任务", false);
            }else {
                return taskService.delete(task);
            }
        }
    }
    //修改
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse update(@RequestBody Task task){
        System.out.println("状态："+task.getState()+"名字"+task.getName()+"内容"+task.getContent());
        if(task.getName()==null||task.getContent()==null){
            return  returnResponse("修改失败",false);
        }else {
            if(task.getExecutor()==0&&task.getState()==1){
                return returnResponse("当前任务还未接受,无法修改为已完成",false);
            }else {
                if (task.getState() == 0) {
                    task.setFinish_time(null);
                    return taskService.update(task);
                } else {
                    if(task.getState()!=0&&task.getState()!=1){
                        return returnResponse("修改失败，状态必须为0或1",false);
                    }else {
                        System.out.println("执行");
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String time = df.format(new Date());
                        task.setFinish_time(time);
                        return taskService.update(task);
                    }
                }
            }
        }
    }
    //接受
    @RequestMapping(value = "/accept", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse accept(@RequestBody Task task){
        System.out.println("任务："+task.getId()+"执行人："+task.getExecutor());
        if(task.getExecutor()==0){
            return taskService.accept(task);
        }else {
            return returnResponse("该任务已被接受或已完成，请重新选择任务",false);
        }
    }
    //个人中心 接受
    @RequestMapping(value = "/myAccept", method = RequestMethod.GET)
    @ResponseBody
    public SiteResponse myAccept(Task task){
        return taskService.myAccept(task);
    }
    //个人中心 发布
    @RequestMapping(value = "/myRelease", method = RequestMethod.GET)
    @ResponseBody
    public SiteResponse myRelease(Task task){
        return taskService.myRelease(task);
    }
    //详情
    @RequestMapping(value = "/details", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse details(@RequestBody Task task){
        System.out.println("任务："+task.getId());
        return taskService.details(task);
    }
    //分页
    @RequestMapping(value = "/paging", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse paging(@RequestBody Task task){
        System.out.println(task.getPagNum()+"   "+task.getPagSize());
        if(task.getPagNum()==0){
            return taskService.paging(task);
        }else {
            int number=task.getPagNum()*task.getPagSize();
            task.setPagNum(number);
            return taskService.paging(task);
        }
    }
    //长度
    @RequestMapping(value = "/length", method = RequestMethod.GET)
    @ResponseBody
    public SiteResponse length(Task task){
        return taskService.length(task);
    }
}
