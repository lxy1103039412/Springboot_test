package com.service;

import com.base.ServiceContain;
import com.pojo.Upload;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadService extends ServiceContain {
    public SiteResponse insert(Upload upload){
        System.out.println(upload.getName()+"  "+upload.getUrl());
        uploadMapper.insert(upload);
        return returnResponse("插入成功",true);
    }
    public SiteResponse search(Upload upload){
        List<Upload> uploadList = uploadMapper.search(upload);
        return returnResponse(uploadList,"查询成功",true);
    }
}
