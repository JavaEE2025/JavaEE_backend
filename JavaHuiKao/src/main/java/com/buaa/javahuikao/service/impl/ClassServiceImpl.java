package com.buaa.javahuikao.service.impl;


import com.buaa.javahuikao.entity.Class;
import com.buaa.javahuikao.mapper.ClassesMapper;
import com.buaa.javahuikao.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: ClassServiceImpl
 * @author: bxr
 * @date: 2025/5/27 17:23
 * @description:
 */

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public List<String> getClassListByExamId(int exam_id) {
        return classesMapper.getClassListByExamId(exam_id);
    }

    @Override
    public List<Class> getTeacherClasses(int userId) {
        return classesMapper.getTeacherClasses(userId);
    }
}
