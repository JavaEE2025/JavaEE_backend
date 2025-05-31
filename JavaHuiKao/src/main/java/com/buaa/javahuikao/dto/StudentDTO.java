package com.buaa.javahuikao.dto;


/**
 * @ClassName: StudentDTO
 * @Author: sxq
 * @Sate: 2025/5/29 21:28
 * @Description: studentId+name
 */
public class StudentDTO {
    private int studentId;
    private String studentName;

    public StudentDTO() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}