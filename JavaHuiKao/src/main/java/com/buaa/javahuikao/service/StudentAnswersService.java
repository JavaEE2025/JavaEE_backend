package com.buaa.javahuikao.service;

import com.buaa.javahuikao.mapper.StudentAnswersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: StudentAnswersService
 * @Author: sxq
 * @Sate: 2025/5/27 19:42
 * @Description:
 */
@Service
public class StudentAnswersService {
    private final StudentAnswersMapper studentAnswersMapper;
    @Autowired
    public StudentAnswersService(StudentAnswersMapper studentAnswersMapper) {
        this.studentAnswersMapper = studentAnswersMapper;
    }

    public int getStudentAnswersId(int studentId,int examId){
        System.out.println("studentId"+studentId);
        System.out.println("examId"+examId);
        int ret = studentAnswersMapper.getStudentAnswersId(studentId,examId);
        System.out.println("ret"+ret);
        return studentAnswersMapper.getStudentAnswersId(studentId,examId);
    }
}
