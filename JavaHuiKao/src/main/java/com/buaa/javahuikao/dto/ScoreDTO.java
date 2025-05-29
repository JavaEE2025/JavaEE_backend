package com.buaa.javahuikao.dto;


/**
 * @className: ScoreDTO
 * @author: bxr
 * @date: 2025/5/28 17:02
 * @description:
 */

public class ScoreDTO {
    private int rank;
    private int id;
    private String name;
    private String className;
    private float score;

    public int getRank() {
        return rank;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public float getScore() {
        return score;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
