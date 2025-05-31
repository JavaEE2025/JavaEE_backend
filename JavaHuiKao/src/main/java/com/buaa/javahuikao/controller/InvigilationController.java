package com.buaa.javahuikao.controller;

import com.buaa.javahuikao.dto.StatusInfoDTO;
import com.buaa.javahuikao.dto.StudentDTO;
import com.buaa.javahuikao.service.ExamStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: InvigilationController
 * @Author: sxq
 * @Sate: 2025/5/29 16:58
 * @Description: 教师监考部分的控制器
 */
@RestController
public class InvigilationController {
    //websocket
    private final SimpMessagingTemplate messagingTemplate;
    @Autowired
    public InvigilationController(SimpMessagingTemplate messagingTemplate) {this.messagingTemplate = messagingTemplate;}
    // 单个学生状态变更
    public void singleStatusNotify(int examId,int studentId,String status, String description) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("examId", examId);
        payload.put("studentId", studentId);
        payload.put("status", status);
        payload.put("description", description);
        messagingTemplate.convertAndSend("/topic/exam/" + examId + "/status", payload);
    }
    // 单个学生进度变更
    public void singleProgressNotify(int examId,int studentId,int progress) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("examId", examId);
        payload.put("studentId", studentId);
        payload.put("progress", progress);
        messagingTemplate.convertAndSend("/topic/exam/" + examId + "/progress", payload);
    }

    //获取所有学生答题状态
    @Autowired
    private ExamStatusService examStatusService;

    //获取所有考试状态
    @GetMapping("/invigilation/exam/status")
    public ResponseEntity<?> getAllStatus(@RequestBody Map<String, Integer> requestBody) {
        try{
            int examId = requestBody.get("exam_id");
            return ResponseEntity.ok(examStatusService.getAllStatus(examId));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("获取考试状态失败: " + e.getMessage());
        }
    }

    //获取参考学生列表
    @GetMapping("/invigilation/student_list")
    public List<StudentDTO> getStudentList(@RequestBody Map<String, Integer> requestBody) {
        int examId = requestBody.get("exam_id");
        return examStatusService.getStudentList(examId);
    }



}