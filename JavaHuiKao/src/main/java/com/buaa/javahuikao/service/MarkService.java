package com.buaa.javahuikao.service;


import com.buaa.javahuikao.entity.Exam;
import com.buaa.javahuikao.mapper.MarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: MarkService
 * @author: bxr
 * @date: 2025/5/27 9:53
 * @description:
 */


public interface MarkService {

    Exam getExamInfo(int exam_id);
}
