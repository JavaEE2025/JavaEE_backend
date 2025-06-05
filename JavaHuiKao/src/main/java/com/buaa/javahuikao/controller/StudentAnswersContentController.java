package com.buaa.javahuikao.controller;

/**
 * @Author: sxq
 * @Date: 2025/5/26 21:42
 * @Description:
 */

import com.buaa.javahuikao.dto.SingleAnswersContentDTO;
import com.buaa.javahuikao.service.StudentAnswersContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: StudentAnswersContentController
 * @Author: sxq
 * @Sate: 2025/5/26 21:42
 * @Description:
 */
@RestController
public class StudentAnswersContentController {
    private static final Logger log = LoggerFactory.getLogger(StudentAnswersContentController.class);
    private final StudentAnswersContentService studentAnswersContentService;
    @Autowired
    public StudentAnswersContentController(StudentAnswersContentService studentAnswersContentService) {
        this.studentAnswersContentService = studentAnswersContentService;
    }

    @CrossOrigin
    @PostMapping({"/submit/answer"})
    public void submitSingleAnswer(@RequestBody SingleAnswersContentDTO singleAnswersContentDTO) {
        System.out.println("singleAnswersContentDTO:"+singleAnswersContentDTO);
        try{
            studentAnswersContentService.submitAnswer(singleAnswersContentDTO);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
