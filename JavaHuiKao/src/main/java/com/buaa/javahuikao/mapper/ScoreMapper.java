package com.buaa.javahuikao.mapper;


import com.buaa.javahuikao.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @className: ScoreMapper
 * @author: bxr
 * @date: 2025/5/26 23:21
 * @description:
 */

@Mapper
public interface ScoreMapper {
    AllScoreDTO getScoreInfo(int examId,float excellentLine);

    List<ScoreDTO> getEachScore(int examId);

    List<Object> getWrongQuestionData(int examId);

    float getExcellentLine(int examId);

    ReportDTO getDetailInfo(int examId, int studentId);

    List<QuestionsDTO> getSingleQuestion(int examId, int studentId);

    List<QuestionsDTO> getMultipleQuestion(int examId, int studentId);

    List<QuestionsDTO> getFillQuestion(int examId, int studentId);

    List<QuestionsDTO> getAnswerQuestion(int examId, int studentId);
}
