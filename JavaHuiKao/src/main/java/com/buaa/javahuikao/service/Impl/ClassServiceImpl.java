package com.buaa.javahuikao.service.Impl;


import com.buaa.javahuikao.mapper.ClassMapper;
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
    private ClassMapper classMapper;

    @Override
    public List<String> getClassListByExamId(int exam_id) {
        return classMapper.getClassListByExamId(exam_id);
    }
}
