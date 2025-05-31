package com.buaa.javahuikao.dto;

/**
 * @Author: sxq
 * @Date: 2025/5/29 11:09
 * @Description:
 */

/**
 * @ClassName: BehaviorDTO
 * @Author: sxq
 * @Sate: 2025/5/29 11:09
 * @Description: 提交行为请求体映射类
 */
public class BehaviorDTO {
    private int student_id;
    private int exam_id;
    private String behavior_type;
    private String description;

    public BehaviorDTO() {
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public String getBehavior_type() {
        return behavior_type;
    }

    public void setBehavior_type(String behavior_type) {
        this.behavior_type = behavior_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
