package com.buaa.javahuikao.service;


import com.buaa.javahuikao.mapper.StudentAnswersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: StudentAnswersService
 * @author: bxr
 * @date: 2025/5/27 19:43
 * @description:
 */

@Service
public class StudentAnswersService {
    @Autowired
    private StudentAnswersMapper studentAnswersMapper;

    public int getRealPersonCnt(int examId) {
        return studentAnswersMapper.getRealPersonCnt(examId);
    }

    public int getStudentAnswersId(int studentId,int examId) {
        System.out.println("studentId" + studentId);
        System.out.println("examId" + examId);
        int ret = studentAnswersMapper.getStudentAnswersId(studentId, examId);
        System.out.println("ret" + ret);
        return studentAnswersMapper.getStudentAnswersId(studentId, examId);
    }

    public int getPrePersonCnt(int examId) {
        return studentAnswersMapper.getPrePersonCnt(examId);
    }
}
