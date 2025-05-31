package com.buaa.javahuikao.controller;

/**
 * @Author: sxq
 * @Date: 2025/5/30 17:23
 * @Description:
 */

import com.buaa.javahuikao.dto.StudentExamQuestionDTO;
import com.buaa.javahuikao.service.ExamQuestionService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ExamQuestionController
 * @Author: sxq
 * @Sate: 2025/5/30 17:23
 * @Description: 获取某场考试的所有考题
 */
@RestController
public class ExamQuestionController {
    @Autowired
    ExamQuestionService examQuestionService;

    @GetMapping("/exam/{examId}/questions")
    public StudentExamQuestionDTO getExamQuestions(@PathVariable int examId) {
        return examQuestionService.getExamQuestions(examId);
    }
}
