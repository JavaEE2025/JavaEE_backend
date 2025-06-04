package com.buaa.javahuikao.service;


import com.buaa.javahuikao.dto.*;
import com.buaa.javahuikao.entity.Kp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: bush
 * @date: 2025/5/27 17:45
 * @description:
 */
public interface QuestionService {
    // 获取所有章节名
    List<String> getAllSections();
    // 根据章节获取对应的知识点
    List<Kp> getKpsBySection(String section);
    // 创建问题
    NewQuestionDTO createQuestion(NewQuestionDTO q);
    // 获取所有问题
    PageInfo<QuestionDTO> getAllQuestions(int page, int size, String type);
    // 根据关键词搜索问题
    PageInfo<QuestionDTO> searchQuestions(String keyword, int page, int size, String type);
    // 根据题目ID获取题目信息
    List<ExamQuestionDTO> getQuestionsByIds(List<Integer> ids);

    List<ObjectiveQuestionDTO> getObjectiveQuestions(int examId);

    List<SubjectiveQuestionDTO> getSubjectiveQuestions(int examId);

}
