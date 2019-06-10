package com.service;

import com.base.ServiceContain;
import com.pojo.Demands;
import com.pojo.User;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DemandsService  extends ServiceContain {
    //查询
    public SiteResponse search(Demands demands){
        List<Demands> demandsList = demandsMapper.search(demands);
        return returnResponse(demandsList,"查询成功",true);
    }
    //插入
    public SiteResponse insert(Demands demands){
        //获取id
        HttpSession sessionUser1=request.getSession();
        User user1=(User) sessionUser1.getAttribute("userId");
        //System.out.println(user1);

        String creator=String.valueOf(user1.getId());
        int creator2=Integer.valueOf(creator);
        System.out.println(creator2);
        demands.setCreator(creator2);
        //插入日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=df.format(new Date());
        demands.setCreate_time(time);
        demandsMapper.insert(demands);
        return returnResponse("增加成功",true);
    }
    //修改
    public SiteResponse update(Demands demands){
        demandsMapper.update(demands);
        return returnResponse("修改成功",true);
    }
    //删除
    public SiteResponse delete (Demands demands){
        demandsMapper.delete(demands);
        return returnResponse("删除成功",true);
    }
    //批量删除
    public SiteResponse delete_more(int[] arr){
        for(int i=0;i<arr.length;i++){
            demandsMapper.delete_more(arr[i]);
        }
        return returnResponse("删除成功",true);
    }
}
