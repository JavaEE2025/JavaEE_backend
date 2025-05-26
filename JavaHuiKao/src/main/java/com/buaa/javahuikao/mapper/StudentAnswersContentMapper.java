package com.buaa.javahuikao.mapper;

import com.buaa.javahuikao.entity.StudentAnswersContent;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: sxq
 * @Date: 2025/5/26 20:47
 * @Description:
 */
@Mapper
public interface StudentAnswersContentMapper {
    //提交答案，返回1则成功插入，返回2则成功更新
    int submitAnswer(StudentAnswersContent content);
    //查找提交的答案
    StudentAnswersContent getContentById(int studentAnswersId, int questionId);

}
