package com.buaa.javahuikao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: sxq
 * @Date: 2025/5/27 19:40
 * @Description:
 */
@Mapper
public interface StudentAnswersMapper {
    //查找id
    int getStudentAnswersId(int studentId, int examId);
}
