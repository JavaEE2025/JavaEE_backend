package com.buaa.javahuikao.mapper;


import com.buaa.javahuikao.entity.Exam;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: MarkMapper
 * @author: bxr
 * @date: 2025/5/27 9:55
 * @description:
 */

@Mapper
public interface MarkMapper{
    Exam getExamInfo(int exam_id);
}
