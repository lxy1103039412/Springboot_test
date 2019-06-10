package com.controller;

import com.base.ServiceContain;
import com.pojo.Info;
import com.pojo.Upload;
import com.pojo.other.SiteResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.net.InetAddress;


@RestController
@RequestMapping("/api/file")
public class UploadController extends ServiceContain {
    @RequestMapping(value = "/upload" ,method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse upload(@RequestBody MultipartFile file, Info info)throws Exception{
        System.out.println(info.getName());
        System.out.println(info.getDesc());
      //  获取本机IP地址
        InetAddress ia=null;
        ia=ia.getLocalHost();
        String localip=ia.getHostAddress();
        System.out.println("本机的ip是 ："+localip);
       // 获取文件名
        String fileName=file.getOriginalFilename();
       // 上传文件的路径
        String filePath="E:/upload/";
        //实例化
        Upload upload=new Upload();
        //连接字符串
        String url="http://"+localip+"/"+fileName;
        upload.setUrl(url);
        upload.setName(fileName);
        try {
            file.transferTo(new File(filePath+fileName));
            System.out.println(fileName);
            return uploadService.insert(upload);
        }catch (Exception e){
            System.out.println(e);
            return returnResponse("上传失败",false);
        }

    }
    @RequestMapping(value = "/search" ,method = RequestMethod.GET)
    @ResponseBody
    public SiteResponse search(Upload upload){
        return uploadService.search(upload);
    }
}
