package com.base;


import com.mapper.DemandsMapper;
import com.mapper.TaskMapper;
import com.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by li on 2017/11/27.
 */
@Mapper
public class MapperContain {
    //用户
    @Autowired
    public UserMapper userMapper;
    @Autowired
    public DemandsMapper demandsMapper;
    @Autowired
    public TaskMapper taskMapper;
    @Autowired
    public ApplicationContext applicationContext;

}
