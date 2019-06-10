package com.mapper;

import com.pojo.Demands;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemandsMapper {
    List<Demands> search(@Param("Pojo")Demands demands);
    void insert(@Param("Pojo")Demands demands);
    void delete(@Param("Pojo")Demands demands);
    void update(@Param("Pojo") Demands demands);
    //批量删除
    void delete_more(@Param("del_more")int demands);
}
