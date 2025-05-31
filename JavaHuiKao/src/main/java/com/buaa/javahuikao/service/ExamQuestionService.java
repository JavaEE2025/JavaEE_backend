package com.buaa.javahuikao.service;

/**
 * @Author: sxq
 * @Date: 2025/5/30 19:16
 * @Description:
 */

import com.buaa.javahuikao.dto.StudentExamQuestionDTO;
import com.buaa.javahuikao.mapper.ExamQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ExamQuestionService
 * @Author: sxq
 * @Sate: 2025/5/30 19:16
 * @Description: 学生获取考题
 */
@Service
public class ExamQuestionService {
    @Autowired
    private ExamQuestionMapper examQuestionMapper;
    public StudentExamQuestionDTO getExamQuestions(int examId){
        return examQuestionMapper.getExamQuestions(examId);
    }

}
