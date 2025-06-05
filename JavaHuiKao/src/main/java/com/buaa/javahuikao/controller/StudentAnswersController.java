package com.buaa.javahuikao.controller;

import com.buaa.javahuikao.dto.BehaviorDTO;
import com.buaa.javahuikao.dto.StudentExamAnswersDTO;
import com.buaa.javahuikao.service.StudentAnswersContentService;
import com.buaa.javahuikao.service.StudentAnswersService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

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


    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public void messageNotReadable(HttpMessageNotReadableException exception, HttpServletResponse response){
        //调试作用，用来调试前台传递json后台无法正确映射问题
        System.out.println("请求参数不匹配。"+ exception);
    }

    @PostMapping("/submit/exam")
    public ResponseEntity<?> submitExam(@RequestBody StudentExamAnswersDTO dto){
        try{
            dto.getAnswer_list().forEach(answer -> {
                if (answer.getAnswer() != null) {
                    answer.getAnswer().decodeBase64Image();
                }
            });

            studentAnswersService.submitExamAnswers(dto);
            markController.autoMarkObjective(dto.getExam_id());
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
