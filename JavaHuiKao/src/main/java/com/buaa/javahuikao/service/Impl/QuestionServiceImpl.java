package com.buaa.javahuikao.service.Impl;


import com.buaa.javahuikao.dto.ObjectiveQuestionDTO;
import com.buaa.javahuikao.dto.SubjectiveQuestionDTO;
import com.buaa.javahuikao.mapper.QuestionMapper;
import com.buaa.javahuikao.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: QuestionServiceImpl
 * @author: bxr
 * @date: 2025/5/27 20:58
 * @description:
 */

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<ObjectiveQuestionDTO> getObjectiveQuestions(int examId) {
        return questionMapper.getObjectiveQuestions(examId);
    }

    @Override
    public List<SubjectiveQuestionDTO> getSubjectiveQuestions(int examId) {
        return questionMapper.getSubjectiveQuestions(examId);
    }
}
