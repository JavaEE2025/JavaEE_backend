package com.buaa.javahuikao.entity;


/**
 * @className: User
 * @author: bxr
 * @date: 2025/5/24 22:57
 * @description:
 */

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private Type type;
    private int student_class_id;

    public User() {
    }

    public enum Type {
        teacher("teacher"),
        student("student");

        private final String description;

        Type(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type.getDescription();
    }

    public int getStudent_class_id() {
        return student_class_id;
    }
}
