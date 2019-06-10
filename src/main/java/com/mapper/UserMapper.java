package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created on 2018.08.14.
 */
public interface UserMapper {
    List<User> search(@Param("Pojo") User user);
    void insert(@Param("Pojo") User user);
    void delete(@Param("Pojo") Object object);
    void update(@Param("Pojo") User user);
    void loginOut(@Param("Pojo")User user);
    List<User>register(@Param("Pojo")User user);
}
