package com.buaa.javahuikao.dto;


import java.util.List;

/**
 * @className: ReportDTO
 * @author: bxr
 * @date: 2025/5/28 22:54
 * @description:
 */

public class ReportDTO {
    private String exam_name;
    private String exam_time;
    private double accuracy;
    private String exam_duration;
    private String student_name;
    private double totalScore;
    private double sum_score; // 满分
    List<QuestionDTO> questions;

    public double getSum_score(){
        return this.sum_score;
    }

    public void setSum_score(double sum_score) {
        this.sum_score = sum_score;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public void setExam_time(String exam_time) {
        this.exam_time = exam_time;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public void setExam_duration(String exam_duration) {
        this.exam_duration = exam_duration;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public String getExam_name() {
        return exam_name;
    }

    public String getExam_time() {
        return exam_time;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public String getExam_duration() {
        return exam_duration;
    }

    public String getStudent_name() {
        return student_name;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }
}
