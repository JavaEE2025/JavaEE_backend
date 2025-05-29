package com.buaa.javahuikao.service.impl;


import com.buaa.javahuikao.dto.AllScoreDTO;
import com.buaa.javahuikao.dto.QuestionDTO;
import com.buaa.javahuikao.dto.ReportDTO;
import com.buaa.javahuikao.dto.ScoreDTO;
import com.buaa.javahuikao.mapper.ScoreMapper;
import com.buaa.javahuikao.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @className: ScoreServiceImpl
 * @author: bxr
 * @date: 2025/5/28 17:16
 * @description:
 */

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public ReportDTO getDetailInfo(int examId, int studentId) {
        return scoreMapper.getDetailInfo(examId,studentId);
    }

    @Override
    public AllScoreDTO getScoreInfo(int examId, float excellent_line) {
        return scoreMapper.getScoreInfo(examId,excellent_line);
    }

    @Override
    public List<ScoreDTO> getEachScore(int examId) {
        return scoreMapper.getEachScore(examId);
    }

    @Override
    public List<Object> getWrongQuestionData(int examId) {
        return scoreMapper.getWrongQuestionData(examId);
    }

    @Override
    public float getExcellentLine(int examId) {
        return scoreMapper.getExcellentLine(examId);
    }

    @Override
    public List<QuestionDTO> getSingleQuestion(int examId, int studentId) {
        return scoreMapper.getSingleQuestion(examId,studentId);
    }

    @Override
    public List<QuestionDTO> getMultipleQuestion(int examId, int studentId) {
        return scoreMapper.getMultipleQuestion(examId,studentId);
    }

    @Override
    public List<QuestionDTO> getFillQuestion(int examId, int studentId) {
        return scoreMapper.getFillQuestion(examId,studentId);
    }

    @Override
    public List<QuestionDTO> getAnswerQuestion(int examId, int studentId) {
        return scoreMapper.getAnswerQuestion(examId,studentId);
    }
}
