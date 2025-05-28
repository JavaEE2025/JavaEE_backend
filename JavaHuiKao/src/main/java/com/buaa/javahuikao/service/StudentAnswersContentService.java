package com.buaa.javahuikao.service;

import com.buaa.javahuikao.dto.AnswerDTO;
import com.buaa.javahuikao.dto.SingleAnswersContentDTO;
import com.buaa.javahuikao.entity.StudentAnswers;
import com.buaa.javahuikao.entity.StudentAnswersContent;
import com.buaa.javahuikao.mapper.StudentAnswersContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName: StudentAnswersContentService
 * @Author: sxq
 * @Sate: 2025/5/26 20:47
 * @Description:
 */
@Service
public class StudentAnswersContentService {
    private final StudentAnswersContentMapper studentAnswersContentMapper;
    private final StudentAnswersService studentAnswersService;

    @Autowired
    public StudentAnswersContentService(
            StudentAnswersContentMapper studentAnswersContentMapper,
            StudentAnswersService studentAnswersService) {
        this.studentAnswersContentMapper = studentAnswersContentMapper;
        this.studentAnswersService = studentAnswersService;
    }

    public int submitAnswer(SingleAnswersContentDTO dto) {
        int studentId =dto.getStudentId();
        int examId = dto.getExamId();
        int studentAnswersId = studentAnswersService.getStudentAnswersId(studentId, examId);

        StudentAnswersContent content=new StudentAnswersContent();
        content.setQuestionId(dto.getQuestionId());
        content.setStudentAnswersId(studentAnswersId);

        AnswerDTO answer= dto.getAnswer();
        content.setTextAnswer(answer.getTextAnswer());
        content.setImgAnswer(answer.getImgAnswer());
        System.out.println("answer.getStringOptAns(): "+answer.getStringOptAns());
        content.setOptionAnswer(answer.getStringOptAns());

        return studentAnswersContentMapper.submitAnswer(content);
    }
}
