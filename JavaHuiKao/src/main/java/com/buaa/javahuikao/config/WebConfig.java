package com.buaa.javahuikao.config;

/**
 * @Author: sxq
 * @Date: 2025/5/29 10:07
 * @Description: 跨域配置
 */

/**
 * @ClassName: WebConfig
 * @Author: sxq
 * @Sate: 2025/5/29 10:07
 * @Description:
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 改为对所有路径生效
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")  // 允许所有头部
                .allowCredentials(true)
                .maxAge(3600);
    }
}