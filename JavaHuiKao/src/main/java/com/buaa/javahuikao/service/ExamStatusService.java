package com.buaa.javahuikao.service;

/**
 * @Author: sxq
 * @Date: 2025/5/29 20:48
 * @Description:
 */

import com.buaa.javahuikao.dto.StatusInfoDTO;
import com.buaa.javahuikao.dto.StudentDTO;
import com.buaa.javahuikao.mapper.ExamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: ExamStatusService
 * @Author: sxq
 * @Sate: 2025/5/29 20:48
 * @Description:
 */
@Service
public class ExamStatusService {
    private final ExamMapper examMapper;
    private final StudentService studentService;


    @Autowired
    public ExamStatusService(ExamMapper examMapper,StudentService studentService) {
        this.studentService = studentService;
        this.examMapper = examMapper;
    }

    public List<StatusInfoDTO> getAllStatus(int examId) {
        return examMapper.getAllStudentStatusByExamId(examId);
    }

    public List<StudentDTO> getStudentList(int examId) {
        // 1. 获取所有关联的classId
        List<Integer> classIds = examMapper.getClassIdsByExamId(examId);

        // 2. 查询所有班级的学生并去重
        return classIds.stream()
                .flatMap(classId ->
                        studentService.getStudentsByClassId(classId).stream())
                .collect(Collectors.toList());
    }

}