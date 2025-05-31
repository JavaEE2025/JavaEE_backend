package com.buaa.javahuikao.dto;

/**
 * @Author: sxq
 * @Date: 2025/5/29 20:42
 * @Description:
 */

/**
 * @ClassName: StatusInfoDTO
 * @Author: sxq
 * @Sate: 2025/5/29 20:42
 * @Description:
 */
public class StatusInfoDTO {
    private int studentId;
    private String name;
    private String status;
    private int progress;

    public StatusInfoDTO() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getAbnormalBehaviors() {
        return abnormalBehaviors;
    }

    public void setAbnormalBehaviors(String abnormalBehaviors) {
        this.abnormalBehaviors = abnormalBehaviors;
    }

    private String abnormalBehaviors;
}
