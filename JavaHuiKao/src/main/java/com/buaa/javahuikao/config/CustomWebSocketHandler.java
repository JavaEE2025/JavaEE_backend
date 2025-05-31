package com.buaa.javahuikao.config;

/**
 * @Author: sxq
 * @Date: 2025/5/29 16:48
 * @Description:
 */

/**
 * @ClassName: CustomWebSocketHandler
 * @Author: sxq
 * @Sate: 2025/5/29 16:48
 * @Description: 自定义的WebSocket处理器
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class CustomWebSocketHandler extends TextWebSocketHandler {

    // 用于存储WebSocket会话
    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String sessionId = session.getId();
        sessions.put(sessionId, session);
        log.info("WebSocket连接建立成功：{}", sessionId);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("收到消息：{}", payload);

        // 发送回复消息
        String replyMessage = "服务器收到消息：" + payload;
        session.sendMessage(new TextMessage(replyMessage));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String sessionId = session.getId();
        sessions.remove(sessionId);
        log.info("WebSocket连接关闭：{}", sessionId);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.error("WebSocket传输错误", exception);
    }

    // 广播消息给所有连接的客户端
    public void broadcastMessage(String message) {
        sessions.values().forEach(session -> {
            try {
                session.sendMessage(new TextMessage(message));
            } catch (IOException e) {
                log.error("广播消息失败", e);
            }
        });
    }
}
