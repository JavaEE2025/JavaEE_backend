package com.buaa.javahuikao.mapper;


import com.buaa.javahuikao.entity.Class;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @className: ClassMapper
 * @author: bxr
 * @date: 2025/5/27 17:23
 * @description:
 */

@Mapper
public interface ClassesMapper {
    List<String> getClassListByExamId(int examId);

    // 教师获取班级
    List<Class> getTeacherClasses(int userId);

    //获取所有班级
    List<Class> getAllClass();

    //学生加入班级
    void joinClass(int studentId, int classId);

    Integer newClass(Class newClass);
}
