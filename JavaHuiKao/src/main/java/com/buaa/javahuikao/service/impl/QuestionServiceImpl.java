package com.buaa.javahuikao.service.impl;

import com.buaa.javahuikao.dto.*;
import com.buaa.javahuikao.entity.Kp;
import com.buaa.javahuikao.entity.Option;
import com.buaa.javahuikao.entity.Question;
import com.buaa.javahuikao.mapper.KpMapper;
import com.buaa.javahuikao.mapper.QuestionMapper;
import com.buaa.javahuikao.service.QuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: bush
 * @date: 2025/5/27 18:11
 * @description:
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private KpMapper kpMapper;

    @Override
    public List<String> getAllSections() {
        return kpMapper.getAllSections();
    }

    @Override
    public List<Kp> getKpsBySection(String section) {
        return kpMapper.getKpsBySection(section);
    }

    @Override
    public NewQuestionDTO createQuestion(NewQuestionDTO q) {
        // 1. 插入 questions 表，生成主键 q.id
        questionMapper.insertQuestion(q);
        // 2. 如果有 kp 关联，批量插入 question_kp
        if (q.getKps() != null && !q.getKps().isEmpty()) {
            questionMapper.insertQuestionKps(q.getId(), q.getKps());
        }
        // 3. 如果有选项，批量插入 options
        if (q.getOptions() != null && !q.getOptions().isEmpty()) {
            questionMapper.insertOptions(q.getId(), q.getOptions());
        }
        return q;
    }

    @Override
    public PageInfo<QuestionDTO> getAllQuestions(int page, int size) {
        PageHelper.startPage(page, size);
        List<QuestionDTO> list = questionMapper.findAllQuestions();
        // 二次填充 kps 列表
        list.forEach(q -> q.setKps(kpMapper.findByQuestionId(q.getId())));
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<QuestionDTO> searchQuestions(String keyword, int page, int size) {
        PageHelper.startPage(page, size);
        List<QuestionDTO> list = questionMapper.searchByKeyword(keyword);
        list.forEach(q -> q.setKps(kpMapper.findByQuestionId(q.getId())));
        return new PageInfo<>(list);
    }

    @Override
    public List<ExamQuestionDTO> getQuestionsByIds(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return new ArrayList<>();
        }
        List<ExamQuestionDTO> result = new ArrayList<>();
        questionMapper.getQuestionsByIds(ids).forEach(
            q -> {
                List<Option> options = new ArrayList<>();
                if (q.getType() == Question.QuestionType.single || q.getType() == Question.QuestionType.multiple) {
                    options = questionMapper.getOptionsByQuestionId(q.getId());
                }
                result.add(
                    new ExamQuestionDTO(
                        q.getId(),
                        q.getTopic(),
                        q.getScore(),
                        q.getType(),
                        options
                    )
                );
            }
        );
        return result;
    }

    @Override
    public List<ObjectiveQuestionDTO> getObjectiveQuestions(int examId) {
        return questionMapper.getObjectiveQuestions(examId);
    }

    @Override
    public List<SubjectiveQuestionDTO> getSubjectiveQuestions(int examId) {
        return questionMapper.getSubjectiveQuestions(examId);
    }
}
