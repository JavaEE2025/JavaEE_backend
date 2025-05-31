package com.buaa.javahuikao.config;



/**
 * @ClassName: WebSocketConfig
 * @Author: sxq
 * @Sate: 2025/5/29 16:36
 * @Description:
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // 客户端订阅地址前缀
        config.setApplicationDestinationPrefixes("/app"); // 服务端接收消息地址前缀
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws") // WebSocket连接端点
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }
}
