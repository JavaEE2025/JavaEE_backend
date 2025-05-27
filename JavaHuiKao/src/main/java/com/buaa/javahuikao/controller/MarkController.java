package com.buaa.javahuikao.controller;


import com.buaa.javahuikao.entity.Exam;
import com.buaa.javahuikao.service.ClassService;
import com.buaa.javahuikao.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: MarkController
 * @author: bxr
 * @date: 2025/5/27 9:52
 * @description:
 */

@RestController
public class MarkController {
    @Autowired
    private MarkService markService;

    @Autowired
    private ClassService classService;

    /**
     * @description: 获取判卷总览（特定考试）
     * @date: 2025/5/27 10:00
     **/
    @CrossOrigin
    @PostMapping({"/teacher/exam_marking_overall"})
    public Map<String, Object> examMarkOverall(@RequestBody Map<String, Object> markMap) {
        int exam_id = Integer.parseInt((String) markMap.get("id"));
        Map<String, Object> map = new HashMap();
        //考试信息
        Exam exam=markService.getExamInfo(exam_id);
        map.put("exam_name",exam.getName());
        map.put("date_time",exam.getStartTime());
        //班级
        List<String> classList=classService.getClassListByExamId(exam_id);
        map.put("class",classList);
        //人数

        //获取题目进度
        return map;
    }

    /**
     * @description: 获取某道题判卷总览
     * @date: 2025/5/27 10:01
     **/
    @CrossOrigin
    @PostMapping({"/teacher/problem_mark"})
    public Map<String, Object> problemMark(@RequestBody Map<String, Object> problemMarkMap) {
        int exam_id = Integer.parseInt((String) problemMarkMap.get("exam_id"));
        int problem_id = Integer.parseInt((String) problemMarkMap.get("problem_id"));
        Map<String, Object> map = new HashMap();
        //TODO
        return map;
    }

    /**
     * @description: 提交成绩
     * @date: 2025/5/27 10:01
     **/
    @CrossOrigin
    @PostMapping({"/teacher/submitScore"})
    public Map<String, Object> submitMark(@RequestBody Map<String, Object> submitMap) {
        int exam_id = Integer.parseInt((String) submitMap.get("exam_id"));
        int problem_id = Integer.parseInt((String) submitMap.get("problem_id"));
        int student_id = Integer.parseInt((String) submitMap.get("student_id"));
        int score = Integer.parseInt((String) submitMap.get("score"));
        String comment= (String) submitMap.get("comment");
        Map<String, Object> map = new HashMap();
        //TODO
        return map;
    }
}
