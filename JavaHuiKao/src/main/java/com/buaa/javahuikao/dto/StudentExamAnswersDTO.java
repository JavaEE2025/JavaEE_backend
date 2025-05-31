package com.buaa.javahuikao.dto;

import ch.qos.logback.core.joran.sanity.Pair;

import java.util.List;

/**
 * @ClassName: StudentExamAnswersDTO
 * @Author: sxq
 * @Sate: 2025/5/29 10:13
 * @Description: 学生提交整张试卷答案
 */
public class StudentExamAnswersDTO {
    private int student_id;
    private int exam_id;
    private List<QuestionAnswerDTO> answer_list;

    public StudentExamAnswersDTO() {
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public List<QuestionAnswerDTO> getAnswer_list() {
        return answer_list;
    }

    public void setAnswer_list(List<QuestionAnswerDTO> answer_list) {
        this.answer_list = answer_list;
    }
}
