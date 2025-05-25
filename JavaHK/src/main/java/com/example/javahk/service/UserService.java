package com.example.javahk.service;


import com.example.javahk.entity.User;
import com.example.javahk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: UserService
 * @author: bxr
 * @date: 2025/5/24 23:11
 * @description:
 */

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User login(int id,String password,String type){
        return userMapper.login(id,password,type);
    }

    public Boolean findUser(int id){
        return userMapper.findUser(id) != null;
    }

    public boolean register(int id, String password, String type) {
        return userMapper.register(id,password,type)>0;
    }
}
