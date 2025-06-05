package com.buaa.javahuikao.mapper;

import com.buaa.javahuikao.dto.ExamDTO;
import com.buaa.javahuikao.dto.StatusInfoDTO;
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

    // 新建考试后，需要在关于答案的两表中插入初始化记录
    // step1: 获取参考学生id
    List<Integer> getInvolvedStudents(List<Integer> classIds);
    // step2: 初始化student_answers表
    void initStudentAnswers(@Param("examId") Integer examId,
                            @Param("studentIds") List<Integer> studentIds);
    // step3: 初始化student_answer_content表
    void initStudentAnswersContent(@Param("examId") Integer examId,
                                   @Param("questions") List<Map<String, Number>> questions,
                                   @Param("studentIds") List<Integer> studentIds);

    // 查询教师所有班级的所有考试
    List<ExamDTO> getTeacherExams(int userId);

    // 查询学生所有考试
    List<Exam> getStudentExams(int userId);
    // 1. 未开始
    List<Exam> getPendingExams(int userId);
    // 2. 进行中
    List<Exam> getOngoingExams(int userId);
    // 3. 已结束
    List<Exam> getCompletedExams(int userId);

    //获取参考班级
    List<Integer> getClassIdsByExamId(@Param("examId") Integer examId);

    //获取所有参考学生状态
    List<StatusInfoDTO> getAllStudentStatusByExamId(@Param("examId") int examId);

    Exam getExamInfo(int examId);
}
