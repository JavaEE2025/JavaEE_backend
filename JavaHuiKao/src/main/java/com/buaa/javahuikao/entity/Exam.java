package com.buaa.javahuikao.entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author: sxq
 * @Date: 2025/5/26 20:38
 * @Description:
 */

/**
 * @ClassName: Exam
 * @Author: sxq
 * @Sate: 2025/5/26 20:38
 * @Description: Exam 实体类
 */

public class Exam {
    private int id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    private LocalTime duration;
    private boolean marked = false; //是否批改
    private double sumScore; // 考试总分

    public Exam() {}

    public Exam(int id, String name, LocalDateTime startTime, LocalTime duration) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.duration = duration;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public LocalTime getDuration() { return duration; }
    public void setDuration(LocalTime duration) { this.duration = duration; }
    public boolean isMarked() { return marked; }
    public void setMarked(boolean marked) { this.marked = marked; }

    public double getSumScore() {
        return sumScore;
    }

    public void setSumScore(double sumScore) {
        this.sumScore = sumScore;
    }
}
