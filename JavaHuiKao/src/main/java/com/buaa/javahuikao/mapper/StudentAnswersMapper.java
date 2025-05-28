package com.buaa.javahuikao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @className: StudentAnswersMapper
 * @author: bxr
 * @date: 2025/5/27 19:43
 * @description:
 */

@Mapper
public interface StudentAnswersMapper {
    //获取实际参加考试的人数
    int getRealPersonCnt(int examId);

    //获取本应参加考试的人数
    int getPrePersonCnt(int examId);

    //查找id
    int getStudentAnswersId(int studentId, int examId);

    void incrementProgress(@Param("studentId") int studentId,
                           @Param("examId") int examId);

    void decrementProgress(@Param("studentId") int studentId,
                           @Param("examId") int examId);

}
