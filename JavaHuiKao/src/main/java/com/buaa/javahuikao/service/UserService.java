package com.buaa.javahuikao.service;


import com.buaa.javahuikao.dto.UserInfoDTO;
import com.buaa.javahuikao.entity.User;
import com.buaa.javahuikao.mapper.UserMapper;
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

    public boolean register(int id, String password, String type,String name,String email) {
        return userMapper.register(id,password,type,name,email)>0;
    }
    public UserInfoDTO getUserInfo(int userId) {
        UserInfoDTO userInfo = userMapper.getUserInfo(userId);

        System.out.println("获取的用户信息："+ userInfo);

        if ("teacher".equals(userInfo.getType())) {
            // 查询老师管理的所有班级
            userInfo.setOwnClasses(userMapper.getTeacherClasses(userId));
            userInfo.setJoinClass(null); // 老师没有joinClass
        } else {
            // 学生没有ownClasses
            userInfo.setOwnClasses(null);
        }

        return userInfo;
    }
}
