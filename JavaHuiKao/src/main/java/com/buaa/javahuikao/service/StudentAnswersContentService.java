package com.example.javahk.service;

/**
 * @Author: sxq
 * @Date: 2025/5/26 20:47
 * @Description:
 */

import com.example.javahk.entity.StudentAnswersContent;
import com.example.javahk.mapper.StudentAnswersContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: StudentAnswersContentService
 * @Author: sxq
 * @Sate: 2025/5/26 20:47
 * @Description:
 */
@Service
public class StudentAnswersContentService {
    private final StudentAnswersContentMapper studentAnswersContentMapper;
    @Autowired
    public StudentAnswersContentService(StudentAnswersContentMapper studentAnswersContentMapper) {
        this.studentAnswersContentMapper = studentAnswersContentMapper;
    }

    public int submitAnswer(StudentAnswersContent studentAnswersContent) {
        return studentAnswersContentMapper.submitAnswer(studentAnswersContent);
    }


}
