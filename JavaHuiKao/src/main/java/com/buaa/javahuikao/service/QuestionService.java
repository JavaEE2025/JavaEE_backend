package com.buaa.javahuikao.service;


import com.buaa.javahuikao.dto.ObjectiveQuestionDTO;
import com.buaa.javahuikao.dto.SubjectiveQuestionDTO;

import java.util.List;

/**
 * @className: QuestionService
 * @author: bxr
 * @date: 2025/5/27 20:55
 * @description:
 */

public interface QuestionService {
    List<ObjectiveQuestionDTO> getObjectiveQuestions(int examId);

    List<SubjectiveQuestionDTO> getSubjectiveQuestions(int examId);
}
