package com.buaa.javahuikao.service.impl;

import com.buaa.javahuikao.entity.Question;
import com.buaa.javahuikao.entity.Kp;
import com.buaa.javahuikao.mapper.KpMapper;
import com.buaa.javahuikao.mapper.QuestionMapper;
import com.buaa.javahuikao.service.QuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Question createQuestion(Question q) {
        // 1. 插入 questions 表，生成主键 q.id
        questionMapper.insertQuestion(q);
        // 2. 如果有 kp 关联，批量插入 question_kp
        if (q.getKps() != null && !q.getKps().isEmpty()) {
            List<Integer> kpIds = q.getKps()
                    .stream()
                    .map(Kp::getId)
                    .toList();
            questionMapper.insertQuestionKps(q.getId(), kpIds);
        }
        return q;
    }

    @Override
    public PageInfo<Question> getAllQuestions(int page, int size) {
        PageHelper.startPage(page, size);
        List<Question> list = questionMapper.findAllQuestions();
        // 二次填充 kps 列表
        list.forEach(q -> q.setKps(kpMapper.findByQuestionId(q.getId())));
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<Question> searchQuestions(String keyword, int page, int size) {
        PageHelper.startPage(page, size);
        List<Question> list = questionMapper.searchByKeyword(keyword);
        list.forEach(q -> q.setKps(kpMapper.findByQuestionId(q.getId())));
        return new PageInfo<>(list);
    }
}
