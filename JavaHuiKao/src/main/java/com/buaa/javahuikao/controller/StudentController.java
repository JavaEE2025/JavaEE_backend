package com.buaa.javahuikao.controller;

/**
 * @Author: sxq
 * @Date: 2025/5/29 21:36
 * @Description:
 */

/**
 * @ClassName: StudentController
 * @Author: sxq
 * @Sate: 2025/5/29 21:36
 * @Description:
 */
import com.buaa.javahuikao.dto.StudentDTO;
import com.buaa.javahuikao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //获取班级所有学生
    @PostMapping("/student/in/class")
    public List<StudentDTO> getClassStudents(@RequestBody Map<String, Integer> requestBody) {
            int classId = requestBody.get("class_id");
            return studentService.getStudentsByClassId(classId);
    }


}
