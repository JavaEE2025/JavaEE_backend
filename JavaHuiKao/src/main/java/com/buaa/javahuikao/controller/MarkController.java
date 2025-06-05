package com.buaa.javahuikao.controller;


import com.buaa.javahuikao.dto.ProblemMarkDTO;
import com.buaa.javahuikao.entity.Exam;
import com.buaa.javahuikao.dto.ObjectiveQuestionDTO;
import com.buaa.javahuikao.dto.SubjectiveQuestionDTO;
import com.buaa.javahuikao.entity.Option;
import com.buaa.javahuikao.entity.Question;
import com.buaa.javahuikao.entity.StudentAnswersContent;
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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<Integer, Double> scoreList;

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
            //初次调用先检查是否判过选择题，如果没判过自动判
            Boolean objectiveMark=markService.getObjectiveMark(exam_id);
            if(!objectiveMark){
                autoMarkObjective(exam_id);
                markService.updateMark(exam_id);
            }
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
                if(processPerson>=exam_real_person){
                    //不可以继续判卷
                    subjectiveQuestionDTO.setAction(false);
                }else{
                    subjectiveQuestionDTO.setAction(true);
                }
                //设置为比例
                subjectiveQuestionDTO.setProcess(processPerson/exam_real_person*100);
            }
            map.put("subjective", subjectiveQuestionDTOS);
            //查询是否还有没判的题
            Boolean stillHave=markService.checkStillHave(exam_id);
            map.put("stillHave",stillHave);
        }catch (Exception e){
            log.error("markOverall: ", e);
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
        int question_id = Integer.parseInt((String) problemMarkMap.get("problem_id"));
        Map<String, Object> map = new HashMap();
        try{
            List<ProblemMarkDTO> markList=markService.genMarkList(exam_id,question_id);
            for(ProblemMarkDTO problemMarkDTO:markList){
                if(problemMarkDTO.getScore()==null){
                    //已经有分数了
                    problemMarkDTO.setMarked(false);
                }else{
                    problemMarkDTO.setMarked(true);
                }
            }
            map.put("result",markList);
        }catch (Exception e){
            log.error("problemMark: ", e);
        }
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
        int question_id = Integer.parseInt((String) submitMap.get("problem_id"));
        int student_id =(int)submitMap.get("student_id");
        float score = ((Number) submitMap.get("score")).floatValue();
        String comment= (String) submitMap.get("comment");
        Map<String, Object> map = new HashMap();
        try{
            //提交成绩
            Boolean result=markService.submitScore(exam_id,student_id,question_id,score,comment);
            map.put("result",result);
            if(result){
                //更新process
                markService.updateProcess(exam_id,question_id);
            }
            //查询是否还有没判的题
            Boolean stillHave=markService.checkStillHave(exam_id);
            map.put("stillHave",stillHave);
            if(!stillHave){
                //没有没判完的题了，修改状态，计算总分
                computeSumScore(exam_id);
            }
        }catch (Exception e){
            log.error("submitScore: ", e);
        }
        return map;
    }

    /**
     * @description: 模糊获取学生作答
     * @date: 2025/5/27 9:58
     **/
    @CrossOrigin
    @PostMapping({"/teacher/getAnswer"})
    public Map<String, Object> getAnswer(@RequestBody Map<String, Object> answerMap) {
        int exam_id = Integer.parseInt((String) answerMap.get("exam_id"));
        int question_id=-1;
        int student_id=-1;
        if(answerMap.containsKey("problem_id")){
            question_id= Integer.parseInt((String) answerMap.get("problem_id"));
        }
        if(answerMap.containsKey("student_id")){
            student_id = Integer.parseInt((String) answerMap.get("student_id"));
        }
        try{
            if(question_id!=-1&&student_id!=-1){
                //获取特定学生的作答
                //先获取题目信息
                Map<String,Object> question_info=markService.getQuestionInfo(exam_id,question_id);
                //再获取作答
                Map<String,Object> answer=markService.getAnswerBy2Id(exam_id,question_id,student_id);
                question_info.putAll(answer);
                //获取题目在本场考试的id
                int id=markService.getId(exam_id,question_id);
                question_info.put("id",id);
                return question_info;
            }else if(question_id != -1) {
                //先检查本题目是否还有没判卷的
                int thisQuestionCount=markService.getThisQuestionCount(exam_id,question_id);
                if(thisQuestionCount!=0){
                    //获取特定题目的作答
                    //先获取题目信息
                    Map<String,Object> question_info=markService.getQuestionInfo(exam_id,question_id);
                    //再获取作答
                    Map<String,Object> answer=markService.getAnswerBy1Id(exam_id,question_id);
                    question_info.putAll(answer);
                    return question_info;
                }
            }
            //模糊获取
            Map<String,Object> answer=markService.getAnswer(exam_id);
            if(answer.containsKey("question_id")){
                int problem_id= (int) answer.get("question_id");
                Map<String,Object> question_info=markService.getQuestionInfo(exam_id,problem_id);
                answer.remove("question_id");
                answer.putAll(question_info);
                return answer;
            }

        }catch (Exception e){
            log.error("getAnswer: ", e);
        }
        return null;
    }

    /**
     * @description: 自动判客观题
     * @date: 2025/5/27 20:27
     **/
    public void autoMarkObjective(int exam_id){
        //TODO:考试结束之后自动调用判客观题
        //单选
        markService.markSingle(exam_id);
        //多选
        List<Question> questions=markService.getAllMultiple(exam_id);
        for(Question question:questions){
            double score=question.getScore();
            int question_id=question.getId();
            List<Option> options=markService.getOption(question_id);
            List<Integer> correctOptionIds = options.stream()
                    .filter(Option::isCorrect)
                    .map(Option::getId)
                    .toList();
            List<StudentAnswersContent> studentAnswersContents=markService.getAnswerList(exam_id,question_id);
            for(StudentAnswersContent studentAnswersContent:studentAnswersContents){
                String optionAnswer=studentAnswersContent.getOptionAnswer();
                double calculatedScore = 0.0;
                if(optionAnswer!=null){
                    List<String> studentAnswer = Arrays.asList(optionAnswer.split(";"));
                    List<Integer> studentSelectedIds = studentAnswer.stream()
                            .map(Integer::valueOf)
                            .toList();


                    boolean hasWrongOption = studentSelectedIds.stream()
                            .anyMatch(id -> !correctOptionIds.contains(id));
                    if (hasWrongOption) {
                        calculatedScore = 0.0;
                    } else if (studentSelectedIds.size() == correctOptionIds.size()) {
                        calculatedScore = score;
                    } else if (studentSelectedIds.size() < correctOptionIds.size()) {
                        calculatedScore = Math.round(score * 2 / 3 * 10) / 10.0;
                    }

                }
                //将得分结果更新到数据库
                markService.updateMultiple(question_id,exam_id,studentAnswersContent.getStudentId(),calculatedScore);
            }
            Boolean stillHave=markService.checkStillHave(exam_id);
            if(!stillHave){
                //没有没判完的题了，修改状态，计算总分
                computeSumScore(exam_id);
            }
        }
    }

    /**
     * @description: 阅卷完成，修改状态，计算总分
     * @date: 2025/5/28 16:01
     **/
    public void computeSumScore(int examId) {
        //修改状态
        markService.updateMarked(examId);
        //计算总分
        markService.computeSumScore(examId);
    }
}
