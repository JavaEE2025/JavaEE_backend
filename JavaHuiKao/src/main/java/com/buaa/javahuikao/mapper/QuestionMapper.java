package com.buaa.javahuikao.mapper;

import com.buaa.javahuikao.entity.Question;
import com.buaa.javahuikao.dto.ObjectiveQuestionDTO;
import com.buaa.javahuikao.dto.SubjectiveQuestionDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: sxq
 * @Date: 2025/5/26 20:30
 * @Description:
 */
@Mapper
public interface QuestionMapper {
    // 新建题目
    Question newQuestion();

    //获取客观题信息
    List<ObjectiveQuestionDTO> getObjectiveQuestions(int examId);

    //获取主观题信息
    List<SubjectiveQuestionDTO> getSubjectiveQuestions(int examId);
}
