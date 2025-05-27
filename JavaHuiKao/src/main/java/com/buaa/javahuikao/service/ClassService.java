package com.buaa.javahuikao.service;


import java.util.List;

/**
 * @className: ClassService
 * @author: bxr
 * @date: 2025/5/27 17:20
 * @description:
 */

public interface ClassService {
    List<String> getClassListByExamId(int exam_id);
}
