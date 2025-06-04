package com.buaa.javahuikao.config;

/**
 * @Author: sxq
 * @Date: 2025/6/4 17:13
 * @Description:
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @ClassName: JacksonConfig
 * @Author: sxq
 * @Sate: 2025/6/4 17:13
 * @Description: jackson配置类，主要适配时间
 */
@Configuration
public class JacksonConfig {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // 注册Java 8日期时间模块
        objectMapper.registerModule(new JavaTimeModule());
        // 禁用日期作为时间戳
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // 设置全局日期格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return objectMapper;
    }
}
