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
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Content-Type", "Authorization")
                .allowCredentials(true)
                .maxAge(3600);
    }
}