package com.buaa.javahuikao.service.impl;


import com.buaa.javahuikao.dto.ProblemMarkDTO;
import com.buaa.javahuikao.entity.Exam;
import com.buaa.javahuikao.mapper.MarkMapper;
import com.buaa.javahuikao.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @className: MarkServiceImpl
 * @author: bxr
 * @date: 2025/5/27 16:03
 * @description:
 */

@Service
public class MarkServiceImpl implements MarkService {
    @Autowired
    private MarkMapper markMapper;

    @Override
    public Exam getExamInfo(int exam_id) {
        return markMapper.getExamInfo(exam_id);
    }

    @Override
    public List<ProblemMarkDTO> genMarkList(int examId, int questionId) {
        return markMapper.getMarkList(examId,questionId);
    }

    @Override
    public Boolean submitScore(int examId, int studentId, int questionId, float score, String comment) {
        return markMapper.submitScore(examId,studentId,questionId,score,comment)>0;
    }

    @Override
    public Boolean checkStillHave(int examId) {
        return markMapper.checkStillHave(examId)>0;
    }

    @Override
    public void updateProcess(int examId, int questionId) {
        markMapper.updateProcess(examId,questionId);
    }

    @Override
    public Map<String, Object> getAnswerBy2Id(int examId, int questionId, int studentId) {
        return markMapper.getAnswerBy2Id(examId,questionId,studentId);
    }

    @Override
    public Map<String, Object> getAnswerBy1Id(int examId, int questionId) {
        return markMapper.getAnswerBy1Id(examId,questionId);
    }

    @Override
    public Map<String, Object> getAnswer(int examId) {
        return markMapper.getAnswer(examId);
    }

    @Override
    public Map<String, Object> getQuestionInfo(int examId, int questionId) {
        return markMapper.getQuestionInfo(examId,questionId);
    }
}
