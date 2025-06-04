package com.buaa.javahuikao.dto;

import com.buaa.javahuikao.entity.Exam;

import java.util.List;
import java.util.Map;

/**
 * @author: bush
 * @date: 2025/5/28 11:05
 * @description:
 */
public class ExamDTO extends Exam {
    private int classId;
    private String className;

    private List<Integer> classIds;

    private List<Map<String, Number>> questions;

    private List<Integer> questionIds;

    public int getClassId() { return classId; }
    public void setClassId(int classId) { this.classId = classId; }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Integer> getClassIds() {
        return classIds;
    }

    public void setClassIds(List<Integer> classIds) {
        this.classIds = classIds;
    }

    public List<Map<String, Number>> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Map<String, Number>> questions) {
        this.questions = questions;
    }

    public List<Integer> getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(List<Integer> questionIds) {
        this.questionIds = questionIds;
    }
}
