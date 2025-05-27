package com.buaa.javahuikao.mapper;

import com.buaa.javahuikao.entity.Kp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: bush
 * @date: 2025/5/27 16:59
 * @description:
 */
@Mapper
public interface KpMapper {

    // 获取所有章节名
    @Select("SELECT DISTINCT section FROM kps")
    List<String> getAllSections();

    // 查询章节对应的所有知识点
    @Select("SELECT DISTINCT * FROM kps WHERE section = #{section}")
    List<Kp> getKpsBySection(String section);

    // 查询问题的知识点
    @Select("SELECT k.* FROM kps k " +
            "JOIN question_kp qk ON k.id = qk.kp_id " +
            "WHERE qk.question_id = #{questionId}")
    List<Kp> findByQuestionId(Integer questionId);
}
