package com.buaa.javahuikao.mapper;


import com.buaa.javahuikao.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: UserMapper
 * @author: bxr
 * @date: 2025/5/24 23:00
 * @description:
 */

@Mapper
public interface UserMapper {
    //通过用户名查找id
    User findUser(int id);
    //登录
    User login(int id, String password, String type);
    //注册
    int register(int id,String password,String type,String name,String email);
}
