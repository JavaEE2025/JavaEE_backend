package com.buaa.javahuikao.mapper;


import com.buaa.javahuikao.dto.ProblemMarkDTO;
import com.buaa.javahuikao.entity.Exam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @className: MarkMapper
 * @author: bxr
 * @date: 2025/5/27 9:55
 * @description:
 */

@Mapper
public interface MarkMapper{
    //获取试卷判分信息
    Exam getExamInfo(int exam_id);

    //获取某道题的判卷信息
    List<ProblemMarkDTO> getMarkList(int examId, int questionId);

    //提交成绩和评语
    int submitScore(int examId, int studentId, int questionId, float score, String comment);

    //检查是否还有没判的卷子
    int checkStillHave(int examId);

    //更新process
    void updateProcess(int examId, int questionId);

    //从特定学生进入
    Map<String, Object> getAnswerBy2Id(int examId, int questionId, int studentId);

    //从特定题目进入
    Map<String, Object> getAnswerBy1Id(int examId, int questionId);

    //从总页面进入
    Map<String, Object> getAnswer(int examId);

    //获取题目信息
    Map<String, Object> getQuestionInfo(int examId, int questionId);
}
