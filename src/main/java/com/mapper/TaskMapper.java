package com.mapper;

import com.pojo.Task;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {
    List<Task> search(@Param("Pojo") Task task);
    //增加任务
    void insert(@Param("Pojo") Task task);
    //删除
    void delete(@Param("Pojo") Task task);
    //修改
    void update(@Param("Pojo") Task task);
    //接受任务
    void accept(@Param("Pojo") Task task);
    //已接受任务
    List <Task>myAccept(@Param("Pojo") Task task);
    //已发布任务
    List <Task>myRelease(@Param("Pojo") Task task);
    //详情页面
    List <Task>details(@Param("Pojo")Task task);
    //分页
    List <Task>paging(@Param("Pojo")Task task);
    //获取长度
    Integer length(@Param("Pojo")Task task);
}
