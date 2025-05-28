package com.buaa.javahuikao.service;


import com.buaa.javahuikao.dto.ProblemMarkDTO;
import com.buaa.javahuikao.entity.Exam;
import com.buaa.javahuikao.mapper.MarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @className: MarkService
 * @author: bxr
 * @date: 2025/5/27 9:53
 * @description:
 */


public interface MarkService {

    Exam getExamInfo(int exam_id);

    List<ProblemMarkDTO> genMarkList(int examId, int questionId);

    Boolean submitScore(int examId, int studentId, int questionId, float score, String comment);

    Boolean checkStillHave(int examId);

    void updateProcess(int examId, int questionId);

    Map<String, Object> getAnswerBy2Id(int examId, int questionId, int studentId);

    Map<String, Object> getAnswerBy1Id(int examId, int questionId);

    Map<String, Object> getAnswer(int examId);

    Map<String, Object> getQuestionInfo(int examId, int questionId);
}
