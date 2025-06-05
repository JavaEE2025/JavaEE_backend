package com.buaa.javahuikao.controller;

import com.buaa.javahuikao.dto.BehaviorDTO;
import com.buaa.javahuikao.dto.StudentExamAnswersDTO;
import com.buaa.javahuikao.service.StudentAnswersContentService;
import com.buaa.javahuikao.service.StudentAnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: StudentAnswersController
 * @Author: sxq
 * @Sate: 2025/5/28 23:05
 * @Description:
 */
@RestController
public class StudentAnswersController {
    @Autowired
    private StudentAnswersService studentAnswersService;
    @Autowired
    private StudentAnswersContentService studentAnswersContentService;
    @Autowired
    private MarkController markController;

    @PostMapping("/submit/exam")
    public ResponseEntity<?> submitExam(@RequestBody StudentExamAnswersDTO dto){
        try{
            studentAnswersService.submitExamAnswers(dto);
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/exam/behavior")
    public ResponseEntity<?> updateStatus(@RequestBody BehaviorDTO dto){
        try{
            studentAnswersService.updateStatus(dto);
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
