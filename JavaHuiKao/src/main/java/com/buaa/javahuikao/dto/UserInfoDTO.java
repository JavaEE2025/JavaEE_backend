package com.buaa.javahuikao.dto;

/**
 * @Author: sxq
 * @Date: 2025/5/31 22:08
 * @Description:
 */

/**
 * @ClassName: UserInfoDTO
 * @Author: sxq
 * @Sate: 2025/5/31 22:08
 * @Description: 个人中心返回信息用
 */
import lombok.Data;
import java.util.List;

@Data
public class UserInfoDTO {
    private String username;
    private String email;
    private String type; // "student" or "teacher"
    private JoinClass joinClass; // 学生所属班级(可能为null)
    private List<OwnClass> ownClasses; // 老师管理的班级列表

    @Data
    public static class JoinClass {
        private String classId;
        private String className;
        private String teacherName;
    }

    @Data
    public static class OwnClass {
        private String classId;
        private String className;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", joinClass=" + joinClass +
                ", ownClasses=" + ownClasses +
                '}';
    }
}
