package com.buaa.javahuikao.dto;

import com.buaa.javahuikao.entity.Option;
import com.buaa.javahuikao.entity.Question;

import java.util.List;

/**
 * @author: bush
 * @date: 2025/5/28 18:02
 * @description: 不包含答案、解析，包含选项，用于考试展示的DTO
 */
public class ExamQuestionDTO {
    private int id;
    private String topic; //题面，html格式
    private double score;
    private Question.QuestionType type;
    private List<Option> options; //选项列表，仅客观题有

    public ExamQuestionDTO(int id, String topic, double score, Question.QuestionType type, List<Option> options) {
        this.id = id;
        this.topic = topic;
        this.score = score;
        this.type = type;
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Question.QuestionType getType() {
        return type;
    }

    public void setType(Question.QuestionType type) {
        this.type = type;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
