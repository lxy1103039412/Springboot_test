package com.AOP;

import com.base.ServiceContain;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Upload_AOP extends ServiceContain{
//    @AfterReturning(value = "execution(* com.controller.UploadController.*(..))")
//    public void after(){
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time=df.format(new Date());
//
//        //String name=super.fileName;
//        fileMapper.insert(file,fileName,time);
//        System.out.println("拦截成功");
//    }
}
