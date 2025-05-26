package com.example.javahk.controller;

/**
 * @Author: sxq
 * @Date: 2025/5/26 21:42
 * @Description:
 */

import com.example.javahk.service.StudentAnswersContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
//    @CrossOrigin
//    @PostMapping({"/???"})

}
