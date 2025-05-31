package com.buaa.javahuikao.dto;

/**
 * @Author: sxq
 * @Date: 2025/5/30 19:20
 * @Description:
 */

import com.buaa.javahuikao.entity.Question;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName: StudentExamQuestionDTO
 * @Author: sxq
 * @Sate: 2025/5/30 19:20
 * @Description: 学生获取的考试及考题信息
 */
public class StudentExamQuestionDTO {
    private String name;
    private LocalDateTime start_time;
    private Time duration;
    private List<ExamQuestionDTO> questions;

    public StudentExamQuestionDTO(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public List<ExamQuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<ExamQuestionDTO> questions) {
        this.questions = questions;
    }
}
