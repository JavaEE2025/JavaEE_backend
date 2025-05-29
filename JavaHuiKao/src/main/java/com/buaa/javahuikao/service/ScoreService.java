package com.buaa.javahuikao.service;


import com.buaa.javahuikao.dto.*;

import java.util.List;
import java.util.Map;

/**
 * @className: ScoreService
 * @author: bxr
 * @date: 2025/5/26 23:20
 * @description:
 */

public interface ScoreService {

    ReportDTO getDetailInfo(int examId, int studentId);

    AllScoreDTO getScoreInfo(int examId, float excellent_line);

    List<ScoreDTO> getEachScore(int examId);

    List<Object> getWrongQuestionData(int examId);

    float getExcellentLine(int examId);

    List<QuestionsDTO> getSingleQuestion(int examId, int studentId);

    List<QuestionsDTO> getMultipleQuestion(int examId, int studentId);

    List<QuestionsDTO> getFillQuestion(int examId, int studentId);

    List<QuestionsDTO> getAnswerQuestion(int examId, int studentId);
}
