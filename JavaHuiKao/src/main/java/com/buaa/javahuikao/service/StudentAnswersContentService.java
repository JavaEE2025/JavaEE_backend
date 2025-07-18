package com.buaa.javahuikao.service;

import com.buaa.javahuikao.controller.InvigilationController;
import com.buaa.javahuikao.dto.AnswerDTO;
import com.buaa.javahuikao.dto.SingleAnswersContentDTO;
import com.buaa.javahuikao.entity.StudentAnswers;
import com.buaa.javahuikao.entity.StudentAnswersContent;
import com.buaa.javahuikao.mapper.StudentAnswersContentMapper;
import com.buaa.javahuikao.mapper.StudentAnswersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    private final StudentAnswersMapper studentAnswersMapper;
    private final InvigilationController invigilationController;
    @Autowired
    public StudentAnswersContentService(
            StudentAnswersContentMapper studentAnswersContentMapper,
            StudentAnswersMapper studentAnswersMapper,
            InvigilationController invigilationController
            ) {
        this.studentAnswersContentMapper = studentAnswersContentMapper;
        this.studentAnswersMapper = studentAnswersMapper;
        this.invigilationController = invigilationController;
    }

    @Async("answerSubmitExecutor")
    public void submitAnswer(SingleAnswersContentDTO dto) {
        StudentAnswersContent contentEntity=new StudentAnswersContent();
        contentEntity.setStudentId(dto.getStudentId());
        contentEntity.setExamId(dto.getExamId());
        contentEntity.setQuestionId(dto.getQuestionId());

        AnswerDTO answer= dto.getAnswer();
        contentEntity.setTextAnswer(answer.getTextAnswer());
        contentEntity.setImgAnswer(answer.getImgAnswer());
        System.out.println("answer.getStringOptionAnswer(): "+answer.getStringOptionAnswer());
        contentEntity.setOptionAnswer(answer.getStringOptionAnswer());
        //修改progress
        updateProgress(dto,answer);
        studentAnswersContentMapper.submitAnswer(contentEntity);
    }

    @Async("answerSubmitExecutor")
    public void updateProgress(SingleAnswersContentDTO dto,AnswerDTO newAnswer) {
        //查找总题目数-->有到无or无到有则修改
        int examId=dto.getExamId();
        int studentId=dto.getStudentId();
        int questionId=dto.getQuestionId();
        AnswerDTO preAnswer= getAnswer(examId,studentId,questionId);
        int newProgress;
        if (preAnswer.isVoidAnswer() && !newAnswer.isVoidAnswer()) {
            // 从没有答案变为有答案，进度加1
            studentAnswersMapper.incrementProgress(studentId, examId);
            newProgress = studentAnswersMapper.getProgress(studentId,examId);
            invigilationController.singleProgressNotify(examId,studentId,newProgress);

        } else if (!preAnswer.isVoidAnswer() && newAnswer.isVoidAnswer()) {
            // 从有答案变为没有答案，进度减1
            studentAnswersMapper.decrementProgress(studentId, examId);
            newProgress = studentAnswersMapper.getProgress(studentId,examId);
            invigilationController.singleProgressNotify(examId,studentId,newProgress);

        }
    }

    public AnswerDTO getAnswer(int examId,int studentId, int questionId){
        AnswerDTO answerDTO = studentAnswersContentMapper.getAnswersContent(examId, studentId, questionId);
        System.out.println("answerDTO: "+answerDTO);
        return answerDTO;
    }
}
