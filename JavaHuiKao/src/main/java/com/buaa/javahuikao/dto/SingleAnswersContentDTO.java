package com.buaa.javahuikao.dto;

/**
 * @Author: sxq
 * @Date: 2025/5/27 15:51
 * @Description:
 */

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @ClassName: StudentAnswersContentDTO
 * @Author: sxq
 * @Sate: 2025/5/27 15:51
 * @Description: 前端请求映射类
 */
public class SingleAnswersContentDTO {
    @JsonProperty("question_id")
    private int questionId;
    @JsonProperty("student_id")
    private int studentId;
    @JsonProperty("exam_id")
    private int examId;
    private AnswerDTO answer;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public AnswerDTO getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerDTO answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "SingleAnswersContentDTO{" +
                "questionId=" + questionId +
                ", studentId=" + studentId +
                ", examId=" + examId +
                ", answer=" + answer +
                '}';
    }
}

