package com.buaa.javahuikao.entity;

import java.util.List;

/**
 * @ClassName: Question
 * @Author: sxq
 * @Sate: 2025/5/26 19:44
 * @Description: question类定义
 */
public class Question {
    private int id;
    private String topic; //题面，html格式
    private double score;
    private QuestionType type;
    public enum QuestionType{
        single,
        multiple,
        fill,
        answer
    }
    private List<Kp> kps; //知识点列表
    private String difficulty;
    private String parse;   //解析，html格式
    private String correctAnswer;
    private String method;  //解题方法
    private String source;  //试题来源

    public int getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public double getScore() {
        return score;
    }

    public QuestionType getType() {
        return type;
    }

    public List<Kp> getKps() {
        return kps;
    }

    public void setKps(List<Kp> kps) {
        this.kps = kps;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getParse() {
        return parse;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getMethod() {
        return method;
    }

    public String getSource() {
        return source;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setParse(String parse) {
        this.parse = parse;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setSource(String source) {
        this.source = source;
    }
}


