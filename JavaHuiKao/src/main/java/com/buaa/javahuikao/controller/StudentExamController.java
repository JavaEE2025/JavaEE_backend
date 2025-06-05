package com.buaa.javahuikao.controller;

import com.buaa.javahuikao.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: bush
 * @date: 2025/5/28 20:35
 * @description:
 */
@RestController
public class StudentExamController {
    @Autowired
    private ExamService examService;

    @PostMapping("/exams")
    public Object getStudentExams(@RequestBody Map<String, Object> requestBody) {
        return examService.getStudentExams(Integer.parseInt((String)requestBody.get("userId")), (String)requestBody.get("status"));
    }
    @PostMapping("/exam/info")
    public Object getExamInfo(@RequestBody Map<String, Object> requestBody){
        return examService.getExamInfo(Integer.parseInt((String)requestBody.get("exam_id")));
    }
}
