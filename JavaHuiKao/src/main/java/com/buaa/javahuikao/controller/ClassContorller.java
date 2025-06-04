package com.buaa.javahuikao.controller;

/**
 * @Author: sxq
 * @Date: 2025/5/31 22:30
 * @Description:
 */

import com.buaa.javahuikao.entity.Class;
import com.buaa.javahuikao.mapper.ClassesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ClassContorller
 * @Author: sxq
 * @Sate: 2025/5/31 22:30
 * @Description: 管理个人中心和班级相关的内容
 */
@RestController
public class ClassContorller {

    @Autowired
    private ClassesMapper classesMapper;

    @GetMapping("/all/class")
    public List<Class> getAllClass(){
        return classesMapper.getAllClass();
    }

    @PostMapping("/join/class")
    public void joinClass(@RequestBody Map<String,Object> requestBody){
        int studentId = Integer.parseInt((String)requestBody.get("student_id"));
        int classId = Integer.parseInt((String)requestBody.get("class_id"));
        classesMapper.joinClass(studentId,classId);
    }

    //新建班级
    @PostMapping("/new/class")
    public Integer newClass(@RequestBody Map<String, Object> requestBody) {
        int teacherId = Integer.parseInt((String) requestBody.get("teacher_id"));
        String className = (String)requestBody.get("class_name");
        Class newClass = new Class();
        newClass.setName(className);
        newClass.setTeacherId(teacherId);
        classesMapper.newClass(newClass);

        return newClass.getId();

    }
}
