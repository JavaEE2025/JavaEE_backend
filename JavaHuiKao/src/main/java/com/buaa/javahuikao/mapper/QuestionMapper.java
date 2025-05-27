package com.buaa.javahuikao.mapper;

import com.buaa.javahuikao.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    List<Question> findAllQuestions();

    List<Question> searchByKeyword(@Param("keyword") String keyword);
}
