package com.buaa.javahuikao.service;

/**
 * @Author: sxq
 * @Date: 2025/5/26 20:47
 * @Description:
 */

import com.buaa.javahuikao.dto.AnswerDTO;
import com.buaa.javahuikao.dto.SingleAnswersContentDTO;
import com.buaa.javahuikao.entity.StudentAnswers;
import com.buaa.javahuikao.entity.StudentAnswersContent;
import com.buaa.javahuikao.mapper.StudentAnswersContentMapper;
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

//    public int submitAnswer(SingleAnswersContentDTO dto) {
//        StudentAnswersContent studentAnswersContent=new StudentAnswersContent();
//        studentAnswersContent.setQuestionId(dto.getQuestionId());
//        studentAnswersContent.setStudentAnswersId();
//
//        AnswerDTO answer= dto.getAnswer();
//        studentAnswersContent.setTextAnswer(answer.getTextAnswer());
//        studentAnswersContent.setImgAnswer(answer.getImgAnswer());
//        studentAnswersContent.setOptionAnswer(answer.getStringOptAns());
//
//        return studentAnswersContentMapper.submitAnswer(singleAnswersContentDTO);
//    }


}
