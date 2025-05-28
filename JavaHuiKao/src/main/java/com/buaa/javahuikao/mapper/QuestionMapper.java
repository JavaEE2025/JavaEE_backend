package com.buaa.javahuikao.mapper;

import com.buaa.javahuikao.dto.ObjectiveQuestionDTO;
import com.buaa.javahuikao.dto.QuestionDTO;
import com.buaa.javahuikao.dto.SubjectiveQuestionDTO;
import com.buaa.javahuikao.entity.Option;
import com.buaa.javahuikao.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author: bush
 * @date: 2025/5/27 16:10
 * @description:
 */
@Mapper
public interface QuestionMapper {

    void insertQuestion(Question q);
    void insertQuestionKps(@Param("questionId") Integer questionId,
                          @Param("kpIds") List<Integer> kpIds);

    List<QuestionDTO> findAllQuestions();

    List<QuestionDTO> searchByKeyword(@Param("keyword") String keyword);

    //获取客观题信息
    List<ObjectiveQuestionDTO> getObjectiveQuestions(int examId);

    //获取主观题信息
    List<SubjectiveQuestionDTO> getSubjectiveQuestions(int examId);

    //根据题目ID获取题目信息
    List<Question> getQuestionsByIds(List<Integer> ids);

    //获取选择题选项
    List<Option> getOptionsByQuestionId(int questionId);
}
