package com.example.javahk.entity;

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
}