package com.buaa.javahuikao.entity;

/**
 * @Author: sxq
 * @Date: 2025/5/26 20:41
 * @Description:
 */

/**
 * @ClassName: StudentAnswers
 * @Author: sxq
 * @Sate: 2025/5/26 20:41
 * @Description: 某学生对某考试的答题记录
 */
public class StudentAnswers {
    private int id;
    private int studentId;
    private int examId;
    private boolean isFinal = false;
    private Double progress;
    private Double sumScore;
    private String status;
    private String abnormalBehaviors;

    public StudentAnswers() {}

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public int getExamId() { return examId; }
    public void setExamId(int examId) { this.examId = examId; }
    public boolean isFinal() { return isFinal; }
    public void setFinal(boolean aFinal) { isFinal = aFinal; }
    public Double getProgress() { return progress; }
    public void setProgress(Double progress) { this.progress = progress; }
    public Double getSumScore() { return sumScore; }
    public void setSumScore(Double sumScore) { this.sumScore = sumScore; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAbnormalBehaviors() {
        return abnormalBehaviors;
    }

    public void setAbnormalBehaviors(String abnormalBehaviors) {
        this.abnormalBehaviors = abnormalBehaviors;
    }
}
