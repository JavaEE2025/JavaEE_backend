package com.buaa.javahuikao.controller;

/**
 * @Author: sxq
 * @Date: 2025/5/26 21:42
 * @Description:
 */

import com.buaa.javahuikao.dto.SingleAnswersContentDTO;
import com.buaa.javahuikao.service.StudentAnswersContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: StudentAnswersContentController
 * @Author: sxq
 * @Sate: 2025/5/26 21:42
 * @Description:
 */
@RestController
public class StudentAnswersContentController {
    private final StudentAnswersContentService studentAnswersContentService;
    @Autowired
    public StudentAnswersContentController(StudentAnswersContentService studentAnswersContentService) {
        this.studentAnswersContentService = studentAnswersContentService;
    }
    @CrossOrigin
    @PostMapping({"/submit/answer"})
    public ResponseEntity<?> submitSingleAnswer(@RequestBody SingleAnswersContentDTO singleAnswersContentDTO) {
        try{
            studentAnswersContentService.submitAnswer(singleAnswersContentDTO);
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
