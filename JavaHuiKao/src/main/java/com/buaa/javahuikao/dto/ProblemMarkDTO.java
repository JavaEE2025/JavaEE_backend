package com.buaa.javahuikao.dto;


/**
 * @className: ProblemMarkDTO
 * @author: bxr
 * @date: 2025/5/27 21:46
 * @description:
 */

public class ProblemMarkDTO {
    private int student_id;
    private String student_name;
    private Float score;
    private Boolean isMarked;

    public int getStudent_id() {
        return student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public Float getScore() {
        return score;
    }

    public Boolean getMarked() {
        return isMarked;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public void setMarked(Boolean marked) {
        isMarked = marked;
    }
}
