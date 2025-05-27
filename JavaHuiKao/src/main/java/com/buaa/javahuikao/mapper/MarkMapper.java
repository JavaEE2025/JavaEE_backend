package com.buaa.javahuikao.mapper;


import com.buaa.javahuikao.dto.ProblemMarkDTO;
import com.buaa.javahuikao.entity.Exam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @className: MarkMapper
 * @author: bxr
 * @date: 2025/5/27 9:55
 * @description:
 */

@Mapper
public interface MarkMapper{
    //获取试卷判分信息
    Exam getExamInfo(int exam_id);

    //获取某道题的判卷信息
    List<ProblemMarkDTO> getMarkList(int examId, int questionId);
}
