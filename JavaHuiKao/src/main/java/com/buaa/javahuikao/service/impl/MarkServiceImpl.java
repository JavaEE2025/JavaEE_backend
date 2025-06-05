package com.buaa.javahuikao.service.impl;


import com.buaa.javahuikao.dto.ProblemMarkDTO;
import com.buaa.javahuikao.entity.Exam;
import com.buaa.javahuikao.entity.Option;
import com.buaa.javahuikao.entity.Question;
import com.buaa.javahuikao.entity.StudentAnswersContent;
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

    @Override
    public void updateMarked(int examId) {
        markMapper.updateMarked(examId);
    }

    @Override
    public void computeSumScore(int examId) {
        markMapper.computeSumScore(examId);
    }

    @Override
    public void markSingle(int examId) {
        markMapper.markSingle(examId);
    }

    @Override
    public List<Question> getAllMultiple(int examId) {
        return markMapper.getAllMultiple(examId);
    }

    @Override
    public List<Option> getOption(int questionId) {
        return markMapper.getOption(questionId);
    }

    @Override
    public List<StudentAnswersContent> getAnswerList(int examId, int questionId) {
        return markMapper.getAnswerList(examId,questionId);
    }

    @Override
    public void updateMultiple(int questionId, int examId,int studentId,Double score) {
        int row=markMapper.updateMultiple(score,questionId,examId,studentId);
        if(row>0){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
    }

    @Override
    public int getId(int examId, int questionId) {
        return markMapper.getId(examId,questionId);
    }

    @Override
    public int getThisQuestionCount(int examId, int questionId) {
        return markMapper.getThisQuestionCount(examId,questionId);
    }

    @Override
    public Boolean getObjectiveMark(int examId) {
        return markMapper.getObjectiveMark(examId);
    }

    @Override
    public void updateMark(int examId) {
        markMapper.updateMark(examId);
    }
}
