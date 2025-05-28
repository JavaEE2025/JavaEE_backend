package com.buaa.javahuikao.controller;

import com.buaa.javahuikao.dto.ExamDTO;
import com.buaa.javahuikao.service.ClassService;
import com.buaa.javahuikao.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.List;

/**
 * @author: bush
 * @date: 2025/5/28 10:18
 * @description:
 */
@RestController
public class TeacherExamController {
    @Autowired
    private ClassService classService;

    @Autowired
    private ExamService examService;

    @PostMapping("/teacher/classes")
    public Object getTeacherClasses(@RequestBody Map<String, Integer> requestBody) {
        return classService.getTeacherClasses(requestBody.get("userId"));
    }

    @PostMapping("/teacher/exams")
    public Object getTeacherExams(@RequestBody Map<String, Integer> requestBody) {
        return examService.getTeacherExams(requestBody.get("userId"));
    }

    @PostMapping("/createExam")
    public Map<String, Object> createExam(@RequestBody Map<String, Object> requestBody) {
        ExamDTO examDTO = new ExamDTO();
        examDTO.setName((String) requestBody.get("name"));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        examDTO.setStartTime(LocalDateTime.parse((String) requestBody.get("startTime"), dateTimeFormatter));
        examDTO.setDuration(LocalTime.parse((String) requestBody.get("duration"), timeFormatter));

        examDTO.setClassIds((List<Integer>) requestBody.get("classIds"));
        examDTO.setQuestions((List<Map<String, Number>>) requestBody.get("questions"));

        ExamDTO createdExam = examService.createExam(examDTO);
        return Map.of("result", "考试创建成功", "examId", createdExam.getId());
    }
}
