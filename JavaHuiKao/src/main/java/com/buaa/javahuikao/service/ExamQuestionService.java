package com.buaa.javahuikao.service;

/**
 * @Author: sxq
 * @Date: 2025/5/30 19:16
 * @Description:
 */

import com.buaa.javahuikao.dto.StudentExamQuestionDTO;
import com.buaa.javahuikao.mapper.ExamQuestionMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ExamQuestionService
 * @Author: sxq
 * @Sate: 2025/5/30 19:16
 * @Description: 学生获取考题
 */
@Service
public class ExamQuestionService {
    private static final String EXAM_QUESTIONS_KEY_PREFIX = "exam:questions:";
    private static final long CACHE_EXPIRE_HOURS = 3; // 缓存过期时间(小时)

    @Autowired
    private ExamQuestionMapper examQuestionMapper;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ObjectMapper objectMapper; //json处理器

    public StudentExamQuestionDTO getExamQuestions(int examId){
        String cacheKey = EXAM_QUESTIONS_KEY_PREFIX + examId;
        //尝试从缓存获取
        try{
            String cachedData = (String) redisTemplate.opsForValue().get(cacheKey);
            if(cachedData != null) {
                return objectMapper.readValue(cachedData,StudentExamQuestionDTO.class);
            }
        }
        catch(Exception e){
            System.out.println("redis缓存错误："+ e);
        }

        //缓存未命中
        StudentExamQuestionDTO questions = examQuestionMapper.getExamQuestions(examId);
        //写入缓存
        if (questions!=null){
            try{
                String jsonData = objectMapper.writeValueAsString(questions);
                redisTemplate.opsForValue().set(
                        cacheKey,
                        jsonData,
                        CACHE_EXPIRE_HOURS,
                        TimeUnit.HOURS
                );
            }
            catch(JsonProcessingException e){
                System.out.println("写入缓存错误："+ e);
            }
        }
        return questions;
    }

}

