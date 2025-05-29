package com.buaa.javahuikao.dto;

import com.buaa.javahuikao.entity.Kp;
import com.buaa.javahuikao.entity.Question;

import java.util.List;

/**
 * @author: bush
 * @date: 2025/5/28 11:14
 * @description: 带知识点和答案解析的题库数据，用于教师端展示题库
 * 【注意】考试展示给学生用的请用 ExamQuestionDTO
 */
public class QuestionDTO extends Question {
    List<Kp> kps;

    public List<Kp> getKps() {
        return kps;
    }

    public void setKps(List<Kp> kps) {
        this.kps = kps;
    }
}
