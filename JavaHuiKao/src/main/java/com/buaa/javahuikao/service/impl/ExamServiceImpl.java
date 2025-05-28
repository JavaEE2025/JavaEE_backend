package com.buaa.javahuikao.service.impl;

import com.buaa.javahuikao.dto.ExamDTO;
import com.buaa.javahuikao.mapper.ExamMapper;
import com.buaa.javahuikao.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: bush
 * @date: 2025/5/28 10:51
 * @description:
 */
@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamMapper examMapper;

    @Override
    public List<ExamDTO> getTeacherExams(int userId) {
        return examMapper.getTeacherExams(userId);
    }

    @Override
    public ExamDTO createExam(ExamDTO examDTO) {
        // 1. 插入考试信息
        examMapper.insertExam(examDTO);
        // 2. 插入考试与班级的关联
        if (examDTO.getClassIds() != null && !examDTO.getClassIds().isEmpty()) {
            examMapper.insertExamClasses(examDTO.getId(), examDTO.getClassIds());
        }
        // 3. 插入考试与题目的关联
        if (examDTO.getQuestions() != null && !examDTO.getQuestions().isEmpty()) {
            examMapper.insertExamQuestions(examDTO.getId(), examDTO.getQuestions());
        }
        return examDTO;
    }
}
