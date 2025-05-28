package com.buaa.javahuikao.entity;
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
    private int classId;
    private LocalDateTime startTime;
    private LocalTime duration;
    private boolean marked = false; //是否批改

    public Exam() {}

    public Exam(int id, String name, int classId, LocalDateTime startTime, LocalTime duration) {
        this.id = id;
        this.name = name;
        this.classId = classId;
        this.startTime = startTime;
        this.duration = duration;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getClassId() { return classId; }
    public void setClassId(int classId) { this.classId = classId; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public LocalTime getDuration() { return duration; }
    public void setDuration(LocalTime duration) { this.duration = duration; }
    public boolean isMarked() { return marked; }
    public void setMarked(boolean marked) { this.marked = marked; }
}
