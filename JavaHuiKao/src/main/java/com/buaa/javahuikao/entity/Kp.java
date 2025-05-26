package com.buaa.javahuikao.entity;

/**
 * @Author: sxq
 * @Date: 2025/5/26 20:40
 * @Description:
 */

/**
 * @ClassName: Kp
 * @Author: sxq
 * @Sate: 2025/5/26 20:40
 * @Description:
 */
public class Kp {
    private int id;
    private String name;
    private String section;

    public Kp() {}

    public Kp(int id, String name, String section) {
        this.id = id;
        this.name = name;
        this.section = section;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }
}