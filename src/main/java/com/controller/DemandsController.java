package com.controller;

import com.base.ServiceContain;
import com.pojo.Demands;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/api/demands")
public class DemandsController extends ServiceContain {
    //查询
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public SiteResponse search( Demands demands) {
//        if(demands.getPageNum()==0){
//            return demandsService.search(demands);
//        }else {
//            int number=demands.getPageNum()+demands.getPages();
//            demands.setPageNum(number);
//            return demandsService.search(demands);
//        }
        return demandsService.search(demands);

    }
    //增加
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse insert(@RequestBody Demands demands) {
//        demands.setName("111");
//        demands.setContent("222");
        if(demands.getName().equals("")||demands.getName().equals(null)||
                demands.getContent().equals("")||demands.getContent().equals(null)){
            return returnResponse("请将信息填写完整",false);
        }else {
            return demandsService.insert(demands);
        }
    }
    //修改
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse update(@RequestBody Demands demands){
        System.out.println(demands.getName()+demands.getId()+demands.getContent());
        if(demands.getName()==null||demands.getId()==0||demands.getContent()==null){
            return returnResponse("修改失败",false);
        }else {
            return demandsService.update(demands);
        }
    }
    //删除
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    @ResponseBody
    public SiteResponse delete(@RequestBody Demands demands){
        System.out.println(demands.getId());
        if(demands.getId()==0){
            return returnResponse("删除失败",false);
        }else {
            return demandsService.delete(demands);
        }
    }
    //批量删除
    @RequestMapping(value = "/delMore", method = RequestMethod.DELETE)
    @ResponseBody
    public SiteResponse deleteMore(@RequestBody String arr){
        System.out.println(arr);
        arr=arr.replaceAll("[^\\d,]","");
        System.out.println(arr);
        String id[]=arr.split(",");
        int id2[]=new int[id.length];
        for(int i=0;i<id.length;i++){
            id2[i]=Integer.valueOf(id[i]);
            System.out.print(id2[i]+" ");
        }
        return demandsService.delete_more(id2);
    }

}
