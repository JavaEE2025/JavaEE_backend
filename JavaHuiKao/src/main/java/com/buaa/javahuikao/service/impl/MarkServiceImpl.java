package com.buaa.javahuikao.service.Impl;


import com.buaa.javahuikao.dto.ProblemMarkDTO;
import com.buaa.javahuikao.entity.Exam;
import com.buaa.javahuikao.mapper.MarkMapper;
import com.buaa.javahuikao.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
