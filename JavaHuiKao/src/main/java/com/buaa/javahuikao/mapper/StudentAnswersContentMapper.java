package com.buaa.javahuikao.mapper;

import com.buaa.javahuikao.dto.AnswerDTO;
import com.buaa.javahuikao.entity.StudentAnswersContent;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: sxq
 * @Date: 2025/5/26 20:47
 * @Description:
 */
@Mapper
public interface StudentAnswersContentMapper {
    //提交答案
    void submitAnswer(StudentAnswersContent content);
    //查找提交的答案
    AnswerDTO getAnswersContent(int examId, int studentId, int questionId);
}
