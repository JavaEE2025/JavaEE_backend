package com.buaa.javahuikao.service;

import com.buaa.javahuikao.dto.ExamDTO;
import com.buaa.javahuikao.entity.Exam;

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

    /**
     * 获取学生的考试列表
     * @param userId 学生ID
     * @param status 考试状态（未开始、进行中、已结束、全部）
     * @return 学生考试列表
     */
    List<Exam> getStudentExams(int userId, String status);
    ExamDTO createExam(ExamDTO examDTO);


}
