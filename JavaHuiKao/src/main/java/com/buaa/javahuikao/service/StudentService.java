package com.buaa.javahuikao.service;

/**
 * @Author: sxq
 * @Date: 2025/5/29 21:31
 * @Description:
 */

import com.buaa.javahuikao.dto.StudentDTO;
import com.buaa.javahuikao.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: StudentService
 * @Author: sxq
 * @Sate: 2025/5/29 21:31
 * @Description:
 */
@Service
public class StudentService {
    private final StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    //根据class_id获取所有学生
    public List<StudentDTO> getStudentsByClassId(int classId) {
        return studentMapper.getStudentsByClassId(classId);
    }

}
