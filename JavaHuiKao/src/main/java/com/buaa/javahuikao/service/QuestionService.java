package com.buaa.javahuikao.service;


import com.buaa.javahuikao.entity.Kp;
import com.buaa.javahuikao.entity.Question;
import com.github.pagehelper.PageInfo;

import com.buaa.javahuikao.dto.ObjectiveQuestionDTO;
import com.buaa.javahuikao.dto.SubjectiveQuestionDTO;

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
    Question createQuestion(Question q);
    // 获取所有问题
    PageInfo<Question> getAllQuestions(int page, int size);
    // 根据关键词搜索问题
    PageInfo<Question> searchQuestions(String keyword, int page, int size);

    List<ObjectiveQuestionDTO> getObjectiveQuestions(int examId);

    List<SubjectiveQuestionDTO> getSubjectiveQuestions(int examId);
}
