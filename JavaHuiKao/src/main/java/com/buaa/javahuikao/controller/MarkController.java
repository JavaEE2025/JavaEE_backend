package com.buaa.javahuikao.controller;


import com.buaa.javahuikao.entity.Exam;
import com.buaa.javahuikao.dto.ObjectiveQuestionDTO;
import com.buaa.javahuikao.dto.SubjectiveQuestionDTO;
import com.buaa.javahuikao.service.ClassService;
import com.buaa.javahuikao.service.MarkService;
import com.buaa.javahuikao.service.QuestionService;
import com.buaa.javahuikao.service.StudentAnswersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: MarkController
 * @author: bxr
 * @date: 2025/5/27 9:52
 * @description:
 */

@RestController
public class MarkController {
    private static final Logger log = LoggerFactory.getLogger(MarkController.class);
    @Autowired
    private MarkService markService;

    @Autowired
    private ClassService classService;

    @Autowired
    private StudentAnswersService studentAnswersService;

    @Autowired
    private QuestionService questionService;

    /**
     * @description: 获取判卷总览（特定考试）
     * @date: 2025/5/27 10:00
     **/
    @CrossOrigin
    @PostMapping({"/teacher/exam_marking_overall"})
    public Map<String, Object> examMarkOverall(@RequestBody Map<String, Object> markMap) {
        int exam_id = Integer.parseInt((String) markMap.get("id"));
        Map<String, Object> map = new HashMap();
        try{
            //考试信息
            Exam exam=markService.getExamInfo(exam_id);
            map.put("exam_name",exam.getName());
            map.put("date_time",exam.getStartTime());
            //班级
            List<String> classList=classService.getClassListByExamId(exam_id);
            map.put("class",classList);
            //人数
            int exam_real_person=studentAnswersService.getRealPersonCnt(exam_id);
            int exam_predict_person=studentAnswersService.getPrePersonCnt(exam_id);
            map.put("exam_real_person",exam_real_person);
            map.put("exam_predict_person",exam_predict_person);
            //获取题目进度
            List<ObjectiveQuestionDTO> objectiveQuestionDTOS = questionService.getObjectiveQuestions(exam_id);
            map.put("objective", objectiveQuestionDTOS);
            List<SubjectiveQuestionDTO> subjectiveQuestionDTOS = questionService.getSubjectiveQuestions(exam_id);
            for(SubjectiveQuestionDTO subjectiveQuestionDTO:subjectiveQuestionDTOS){
                int processPerson=subjectiveQuestionDTO.getProcess();
                if(processPerson==exam_real_person){
                    //不可以继续判卷
                    subjectiveQuestionDTO.setAction(false);
                }else{
                    subjectiveQuestionDTO.setAction(true);
                }
                //设置为比例
                subjectiveQuestionDTO.setProcess(processPerson/exam_real_person);
            }
            map.put("subjective", subjectiveQuestionDTOS);
        }catch (Exception e){
            log.error("e: ", e);
        }
        return map;
    }

    /**
     * @description: 获取某道题判卷总览
     * @date: 2025/5/27 10:01
     **/
    @CrossOrigin
    @PostMapping({"/teacher/problem_mark"})
    public Map<String, Object> problemMark(@RequestBody Map<String, Object> problemMarkMap) {
        int exam_id = Integer.parseInt((String) problemMarkMap.get("exam_id"));
        int problem_id = Integer.parseInt((String) problemMarkMap.get("problem_id"));
        Map<String, Object> map = new HashMap();
        //TODO
        return map;
    }

    /**
     * @description: 提交成绩
     * @date: 2025/5/27 10:01
     **/
    @CrossOrigin
    @PostMapping({"/teacher/submitScore"})
    public Map<String, Object> submitMark(@RequestBody Map<String, Object> submitMap) {
        int exam_id = Integer.parseInt((String) submitMap.get("exam_id"));
        int problem_id = Integer.parseInt((String) submitMap.get("problem_id"));
        int student_id = Integer.parseInt((String) submitMap.get("student_id"));
        int score = Integer.parseInt((String) submitMap.get("score"));
        String comment= (String) submitMap.get("comment");
        Map<String, Object> map = new HashMap();
        //TODO
        return map;
    }

    /**
     * @description: 自动判客观题
     * @date: 2025/5/27 20:27
     **/
    public void autoMarkObjective(int exam_id){
        //TODO
    }
}
