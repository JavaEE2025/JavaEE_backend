package com.example.javahk.entity;

/**
 * @Author: sxq
 * @Date: 2025/5/26 20:36
 * @Description:
 */

/**
 * @ClassName: Class
 * @Author: sxq
 * @Sate: 2025/5/26 20:36
 * @Description:
 */
public class Class {
    private int id;
    private String name;
    private int teacherId; // 关联用户表中的教师ID

    public Class() {}

    public Class(int id, String name, int teacherId) {
        this.id = id;
        this.name = name;
        this.teacherId = teacherId;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getTeacherId() { return teacherId; }
    public void setTeacherId(int teacherId) { this.teacherId = teacherId; }
}
