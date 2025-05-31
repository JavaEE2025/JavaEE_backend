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
     * 答题处理专用线程池
     * 适用于CPU密集型任务（核心线程数=CPU核心数）
     */
    @Bean(name = "answerProcessingExecutor")
    public Executor answerProcessingExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 核心配置
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(1000);
        executor.setThreadNamePrefix("AnswerProcessor-");

        // 拒绝策略（由调用者线程直接运行被拒绝的任务）
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 线程保活时间（秒）
        executor.setKeepAliveSeconds(60);

        // 等待所有任务完成后关闭
        executor.setWaitForTasksToCompleteOnShutdown(true);

        executor.initialize();
        return executor;
    }

    /**
     * 可选：IO密集型任务线程池
     */
    @Bean(name = "ioIntensiveExecutor")
    public Executor ioIntensiveExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);  // 更大的核心线程数
        // 其他配置...
        return executor;
    }
}