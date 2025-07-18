package com.buaa.javahuikao.controller;


import com.buaa.javahuikao.dto.UserInfoDTO;
import com.buaa.javahuikao.entity.Class;
import com.buaa.javahuikao.entity.User;
import com.buaa.javahuikao.mapper.ClassesMapper;
import com.buaa.javahuikao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: UserController
 * @author: bxr
 * @date: 2025/5/24 23:14
 * @description:
 */


@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @CrossOrigin
    @PostMapping({"/login"})
    public Map<String, Object> userLogin(@RequestBody Map<String, Object> loginMap) {
        int id = Integer.parseInt((String) loginMap.get("id"));
        String password = loginMap.get("password").toString();
        String type=loginMap.get("identification").toString();
        Map<String, Object> map = new HashMap();
        if (!this.userService.findUser(id)) {
            map.put("message", "用户未注册");
            map.put("result", false);
        } else {
            User loginuser = this.userService.login(id, password,type);
            if (loginuser != null) {
                map.put("message", "登录成功:)");
                map.put("result", true);
            } else {
                map.put("message", "密码错误");
                map.put("result", false);
            }
        }
        return map;
    }

    @CrossOrigin
    @PostMapping({"/register"})
    public Map<String,Object> userRegister(@RequestBody Map<String,Object> registerMap){
        int id=Integer.parseInt((String) registerMap.get("id"));
        String password=registerMap.get("password").toString();
        String type=registerMap.get("identification").toString();
        String name=registerMap.get("name").toString();
        String email=registerMap.get("email").toString();
        Map<String, Object> map = new HashMap();
        if(!this.userService.findUser(id)){
            if(this.userService.register(id,password,type,name,email)){
                map.put("result",true);
                map.put("message","注册成功:)");
            }else{
                map.put("result",false);
                map.put("message","注册失败");
            }
        }else{
            map.put("result",false);
            map.put("message","用户已注册");
        }
        return map;
    }

    @CrossOrigin
    @PostMapping({"/user/info"})
    public UserInfoDTO getUserInfo(@RequestBody Map<String,Object> registerMap){
        int userId = Integer.parseInt((String) registerMap.get("user_id"));
        return userService.getUserInfo(userId);
    }


}
