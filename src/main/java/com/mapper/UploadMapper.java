package com.mapper;


import com.pojo.Upload;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UploadMapper {
    void insert(@Param("Pojo")Upload upload);
    List<Upload> search(@Param("Pojo")Upload upload);
}
