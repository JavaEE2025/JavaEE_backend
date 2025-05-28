package com.buaa.javahuikao.service;

import com.buaa.javahuikao.dto.ExamDTO;

import java.util.List;

/**
 * @author: bush
 * @date: 2025/5/28 10:50
 * @description:
 */
public interface ExamService {
    /**
     * 获取教师所有班级的所有考试
     * @param userId 教师ID
     * @return 考试列表
     */
    List<ExamDTO> getTeacherExams(int userId);

    ExamDTO createExam(ExamDTO examDTO);
}
