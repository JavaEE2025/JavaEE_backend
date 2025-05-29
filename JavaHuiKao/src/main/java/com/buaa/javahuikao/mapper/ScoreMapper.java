package com.buaa.javahuikao.mapper;


import com.buaa.javahuikao.dto.AllScoreDTO;
import com.buaa.javahuikao.dto.QuestionDTO;
import com.buaa.javahuikao.dto.ReportDTO;
import com.buaa.javahuikao.dto.ScoreDTO;
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

    List<QuestionDTO> getSingleQuestion(int examId, int studentId);

    List<QuestionDTO> getMultipleQuestion(int examId, int studentId);

    List<QuestionDTO> getFillQuestion(int examId, int studentId);

    List<QuestionDTO> getAnswerQuestion(int examId, int studentId);
}
