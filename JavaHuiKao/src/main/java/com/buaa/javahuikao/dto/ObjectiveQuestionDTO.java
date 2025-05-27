package com.buaa.javahuikao.dto;


import java.util.ArrayList;
import java.util.List;

/**
 * @className: ObjectiveQuestion
 * @author: bxr
 * @date: 2025/5/27 20:24
 * @description:
 */

public class ObjectiveQuestionDTO {
    private int ID;
    private int question_id;
    List<String> tags;

    public ObjectiveQuestionDTO(){
        this.tags=new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public List<String> getTags() {
        return tags;
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

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }
}
