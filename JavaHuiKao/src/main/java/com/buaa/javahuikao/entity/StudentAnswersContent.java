package com.buaa.javahuikao.entity;

/**
 * @Author: sxq
 * @Date: 2025/5/26 20:40
 * @Description:
 */

/**
 * @ClassName: StudentAnswersContent
 * @Author: sxq
 * @Sate: 2025/5/26 20:40
 * @Description: 某学生对某道题的答题记录
 */
public class StudentAnswersContent {
    private int examId;
    private int studentId;
    private int questionId;
    private String textAnswer;
    private byte[] imgAnswer;
    private String optionAnswer;
    private Double score;


    public StudentAnswersContent() {}

    // Getters and Setters

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getQuestionId() { return questionId; }
    public void setQuestionId(int questionId) { this.questionId = questionId; }
    public String getTextAnswer() { return textAnswer; }
    public void setTextAnswer(String textAnswer) { this.textAnswer = textAnswer; }
    public byte[] getImgAnswer() { return imgAnswer; }
    public void setImgAnswer(byte[] imgAnswer) { this.imgAnswer = imgAnswer; }
    public String getOptionAnswer() { return optionAnswer; }
    public void setOptionAnswer(String optionAnswer) { this.optionAnswer = optionAnswer; }
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public int getExam_id() {
        return exam_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
}