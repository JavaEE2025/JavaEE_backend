package com.buaa.javahuikao.controller;


import com.buaa.javahuikao.entity.User;
import com.buaa.javahuikao.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: ScoreController
 * @author: bxr
 * @date: 2025/5/26 23:19
 * @description:
 */

@RestController
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @CrossOrigin
    @PostMapping({"/teacher/getScore"})
    public Map<String, Object> getScoreOverall(@RequestBody Map<String, Object> scoreMap) {
        int exam_id = Integer.parseInt((String) scoreMap.get("exam_id"));
        Map<String, Object> map = new HashMap();
        //TODO
        return map;
    }

    @CrossOrigin
    @PostMapping({"/student/scorelist"})
    public Map<String, Object> getScoreList(@RequestBody Map<String, Object> scoreMap) {
        int exam_id = Integer.parseInt((String) scoreMap.get("exam_id"));
        int student_id = Integer.parseInt((String) scoreMap.get("student_id"));
        Map<String, Object> map = new HashMap();
        //TODO
        return map;
    }
}
