package com.buaa.javahuikao.mapper;


import com.buaa.javahuikao.dto.ProblemMarkDTO;
import com.buaa.javahuikao.entity.Exam;
import com.buaa.javahuikao.entity.Option;
import com.buaa.javahuikao.entity.Question;
import com.buaa.javahuikao.entity.StudentAnswersContent;
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

    //更新marked是否批改完成状态
    void updateMarked(int examId);

    //计算总分
    void computeSumScore(int examId);

    //自动判单选
    void markSingle(int examId);

    //获取所有的多选题
    List<Question> getAllMultiple(int examId);

    //获取选项
    List<Option> getOption(int questionId);

    //获取所有学生作答
    List<StudentAnswersContent> getAnswerList(int examId, int questionId);

    //更新多选题分数
    int updateMultiple(Double score,int questionId, int examId,int studentId);

    //获取题目在考试中的题号
    int getId(int examId, int questionId);

    //获取是否还有对应题目的没判的
    int getThisQuestionCount(int examId, int questionId);

    //判断客观题判没判
    Boolean getObjectiveMark(int examId);

    //更新该字段
    void updateMark(int examId);
}
