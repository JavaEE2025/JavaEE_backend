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
    private int studentAnswersId;
    private int questionId;
    private String textAnswer;
    private byte[] imgAnswer;
    private String optionAnswer;
    private Double score;
    private int exam_id;
    private int student_id;

    public StudentAnswersContent() {}

    // Getters and Setters
    public int getStudentAnswersId() { return studentAnswersId; }
    public void setStudentAnswersId(int studentAnswersId) { this.studentAnswersId = studentAnswersId; }
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