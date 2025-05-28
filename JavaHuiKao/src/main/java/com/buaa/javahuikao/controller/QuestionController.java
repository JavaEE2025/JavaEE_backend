package com.buaa.javahuikao.controller;

import com.buaa.javahuikao.dto.QuestionKpDTO;
import com.buaa.javahuikao.entity.Question;
import com.buaa.javahuikao.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: bush
 * @date: 2025/5/27 18:15
 * @description:
 */
@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/sections")
    public Object getAllSections() {
        return questionService.getAllSections();
    }

    @PostMapping("/kps")
    public Object getKpsBySection(@RequestBody Map<String, String> requestBody) {
        return questionService.getKpsBySection(requestBody.get("section"));
    }

    @PostMapping("/questions")
    public Object getQuestions(@RequestBody Map<String, Object> requestBody) {
        int page = Integer.parseInt(requestBody.get("page").toString());
        int size = Integer.parseInt(requestBody.get("size").toString());
        String keyword = requestBody.get("search") != null ? requestBody.get("search").toString() : null;

        if (keyword != null && !keyword.isEmpty()) {
            return questionService.searchQuestions("+" + keyword, page, size);
        } else {
            return questionService.getAllQuestions(page, size);
        }
    }

    @PostMapping("/createQuestion")
    public Map<String, Object> createQuestion(@RequestBody QuestionKpDTO question) {
        Question createdQuestion = questionService.createQuestion(question);
        return Map.of("result", "问题创建成功",
                      "questionId", createdQuestion.getId());
    }
}
