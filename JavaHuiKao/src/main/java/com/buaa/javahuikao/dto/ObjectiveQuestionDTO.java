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

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
