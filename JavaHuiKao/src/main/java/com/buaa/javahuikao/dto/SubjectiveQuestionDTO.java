package com.buaa.javahuikao.dto;


import java.util.List;

/**
 * @className: SubjectiveQuestion
 * @author: bxr
 * @date: 2025/5/27 20:29
 * @description:
 */

public class SubjectiveQuestionDTO {
    private int ID;
    private int question_id;
    private List<String> tags;
    private int process;
    private Boolean action;

    public int getID() {
        return ID;
    }

    public List<String> getTags() {
        return tags;
    }

    public int getProcess() {
        return process;
    }

    public Boolean getAction() {
        return action;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    public void setAction(Boolean action) {
        this.action = action;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }
}
