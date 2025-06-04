package com.buaa.javahuikao.dto;

import com.buaa.javahuikao.entity.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: bush
 * @date: 2025/6/4 13:47
 * @description:
 */
public class NewQuestionDTO extends Question {
    List<Integer> kps;  // 知识点ID列表
    // 选项
    // "content": "选项内容",
    // "isCorrect": true/false  // 是否为正确答案
    List<Map<String, Object>> options;

    public List<Integer> getKps() {
        return kps;
    }

    public void setKps(List<Integer> kps) {
        this.kps = kps;
    }

    public List<Map<String, Object>> getOptions() {
        return options;
    }

    public void setOptions(List<Map<String, Object>> options) {
        this.options = options;
    }
}
