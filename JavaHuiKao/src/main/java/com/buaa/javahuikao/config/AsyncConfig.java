package com.buaa.javahuikao.config;

/**
 * @Author: sxq
 * @Date: 2025/5/29 10:09
 * @Description: 线程池配置
 */

/**
 * @ClassName: AsyncConfig
 * @Author: sxq
 * @Sate: 2025/5/29 10:09
 * @Description:
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

    /**
     * 单题提交线程池
     */
    @Bean(name = "answerSubmitExecutor")
    public Executor answerSubmitExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(50);  // 较大核心线程数应对IO等待
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(1000); // 缓冲突发流量
        executor.setThreadNamePrefix("AnswerSubmit-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }


    /**
     * 状态更新线程池
     */
    @Bean(name = "statusUpdateExecutor")
    public Executor statusUpdateExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(500); // 适度队列缓冲
        executor.setThreadNamePrefix("IO-Executor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}