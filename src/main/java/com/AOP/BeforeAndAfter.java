package com.AOP;



import com.base.ServiceContain;
import com.pojo.Log;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class BeforeAndAfter extends ServiceContain {
//    @AfterReturning(value = "execution(* com.mapper.UserMapper.delete(Object))")     //参数指向的文件是下面执行方法的参照
//    public void after(){
//        System.out.println("已拦截");
//        String info="已删除id：";
//        int id2=arr[0];
//        info=info.concat(String.valueOf(id2));
//        Log log=new Log();
//        logMapper.insert1(log,id2,info);
//
//    }


}

