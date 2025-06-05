package com.buaa.javahuikao.service.impl;

import com.buaa.javahuikao.dto.ExamDTO;
import com.buaa.javahuikao.entity.Exam;
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
        List<ExamDTO> examDTOS = examMapper.getTeacherExams(userId);
        examDTOS.forEach(examDTO -> {
            // 获取考试对应的班级ID列表
            examDTO.setClassIds(examMapper.getClassIdsByExamId(examDTO.getId()));
            // 获取考试对应的题目ID列表
            examDTO.setQuestionIds(examMapper.getQuestionIdsByExamId(examDTO.getId()));
        });
        return examDTOS;
    }

    @Override
    public List<Exam> getStudentExams(int userId, String status) {
        return switch (status) {
            case "pending" -> examMapper.getPendingExams(userId);
            case "ongoing" -> examMapper.getOngoingExams(userId);
            case "completed" -> examMapper.getCompletedExams(userId);
            default -> examMapper.getStudentExams(userId);
        };
    }
    @Override
    public ExamDTO createExam(ExamDTO examDTO) {
        examDTO.setSumScore(examDTO.getQuestions().stream()
                .mapToDouble(q -> q.get("score").doubleValue())
                .sum());
        examDTO.setQuestionCount(examDTO.getQuestions().size());
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
        // 4. 获取参与考试的学生列表
        List<Integer> studentIds = examMapper.getInvolvedStudents(examDTO.getClassIds());
        if (studentIds.isEmpty()) { return examDTO; } // 如果没有学生参与考试，直接返回
        // 5. 初始化学生答案表
        examMapper.initStudentAnswers(examDTO.getId(), studentIds);
        // 6. 初始化学生答案内容表
        if (examDTO.getQuestions() != null && !examDTO.getQuestions().isEmpty()) {
            examMapper.initStudentAnswersContent(examDTO.getId(), examDTO.getQuestions(), studentIds);
        }
        return examDTO;
    }

    @Override
    public Exam getExamInfo(int examId){
        return examMapper.getExamInfo(examId);
    }

    @Override
    public void editExam(ExamDTO examDTO) {
        // 先删除考试
        examMapper.deleteExam(examDTO.getId());
        // 再重新创建考试
        examDTO.setSumScore(examDTO.getQuestions().stream()
                .mapToDouble(q -> q.get("score").doubleValue())
                .sum());
        // 1. 插入考试信息
        examMapper.editExam(examDTO);
        // 2. 插入考试与班级的关联
        if (examDTO.getClassIds() != null && !examDTO.getClassIds().isEmpty()) {
            examMapper.insertExamClasses(examDTO.getId(), examDTO.getClassIds());
        }
        // 3. 插入考试与题目的关联
        if (examDTO.getQuestions() != null && !examDTO.getQuestions().isEmpty()) {
            examMapper.insertExamQuestions(examDTO.getId(), examDTO.getQuestions());
        }
        // 4. 获取参与考试的学生列表
        List<Integer> studentIds = examMapper.getInvolvedStudents(examDTO.getClassIds());
        if (studentIds.isEmpty()) { return; } // 如果没有学生参与考试，直接返回
        // 5. 初始化学生答案表
        examMapper.initStudentAnswers(examDTO.getId(), studentIds);
        // 6. 初始化学生答案内容表
        if (examDTO.getQuestions() != null && !examDTO.getQuestions().isEmpty()) {
            examMapper.initStudentAnswersContent(examDTO.getId(), examDTO.getQuestions(), studentIds);
        }
    }

    @Override
    public void deleteExam(int examId) {
        // 删除考试
        examMapper.deleteExam(examId);
    }
}
