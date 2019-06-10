package com.mapper;

import com.pojo.Log;

import org.apache.ibatis.annotations.Param;

public interface LogMapper {
    void insert1(@Param("Pojo") Log log,@Param("Del") int id,@Param("info") String info);
}
