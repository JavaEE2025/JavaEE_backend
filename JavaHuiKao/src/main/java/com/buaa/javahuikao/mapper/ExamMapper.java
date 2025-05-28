package com.buaa.javahuikao.mapper;

import com.buaa.javahuikao.dto.ExamDTO;
import com.buaa.javahuikao.entity.Exam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author: bush
 * @date: 2025/5/28 10:30
 * @description:
 */
@Mapper
public interface ExamMapper {
    // 新建考试
    void insertExam(Exam exam);

    // 插入考试与班级关联
    void insertExamClasses(@Param("examId") Integer examId,
                         @Param("classIds") List<Integer> classIds);

    // 插入考试与题目关联
    void insertExamQuestions(@Param("examId") Integer examId,
                             @Param("questions") List<Map<String, Number>> questions);

    // 查询教师所有班级的所有考试
    List<ExamDTO> getTeacherExams(int userId);
}
