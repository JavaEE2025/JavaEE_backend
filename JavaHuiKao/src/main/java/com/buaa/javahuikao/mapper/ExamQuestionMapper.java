package com.buaa.javahuikao.mapper;

/**
 * @Author: sxq
 * @Date: 2025/5/30 19:19
 * @Description:
 */

import com.buaa.javahuikao.dto.StudentExamQuestionDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: ExamQuestionMapper
 * @Author: sxq
 * @Sate: 2025/5/30 19:19
 * @Description: 获取学生考试题
 */
@Mapper
public interface ExamQuestionMapper {
    StudentExamQuestionDTO getExamQuestions(int examId);
}
