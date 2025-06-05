package com.buaa.javahuikao.controller;

import com.buaa.javahuikao.entity.Exam;
import com.buaa.javahuikao.service.ClassService;
import com.buaa.javahuikao.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    private ClassService classService;

    @PostMapping("/exams")
    public Object getStudentExams(@RequestBody Map<String, Object> requestBody) {
        List<Map<String, Object>> results = new ArrayList<>();
        examService.getStudentExams((Integer)requestBody.get("userId"), (String)requestBody.get("status")).forEach(exam -> {
            // 获取考试对应的班级列表
            results.add(Map.of(
                "id", exam.getId(),
                "name", exam.getName(),
                "startTime", exam.getStartTime(),
                "duration", exam.getDuration(),
                "sumScore", exam.getSumScore(),
                "questionCount", exam.getQuestionCount(),
                "classNames", classService.getClassListByExamId(exam.getId())
            ));
        });
        return results;
    }
    @PostMapping("/exam/info")
    public Object getExamInfo(@RequestBody Map<String, Object> requestBody){
        return examService.getExamInfo(Integer.parseInt((String)requestBody.get("exam_id")));
    }
}
