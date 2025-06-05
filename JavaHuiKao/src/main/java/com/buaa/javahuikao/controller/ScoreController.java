package com.buaa.javahuikao.controller;


import com.buaa.javahuikao.dto.AllScoreDTO;
import com.buaa.javahuikao.dto.QuestionsDTO;
import com.buaa.javahuikao.dto.ReportDTO;
import com.buaa.javahuikao.dto.ScoreDTO;
import com.buaa.javahuikao.service.ScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: ScoreController
 * @author: bxr
 * @date: 2025/5/26 23:19
 * @description:
 */

@RestController
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    private static final Logger log = LoggerFactory.getLogger(ScoreController.class);

    /**
     * @description: 获取成绩总览
     * @date: 2025/5/28 15:53
     **/
    @CrossOrigin
    @PostMapping({"/teacher/getScore"})
    public ResponseEntity<AllScoreDTO> getScoreOverall(@RequestBody Map<String, Object> scoreMap) {
        int exam_id =(int) scoreMap.get("exam_id");
        try{
            //获得优秀标准
            float excellent_line=scoreService.getExcellentLine(exam_id);
            //获得成绩的基本信息
            AllScoreDTO allScoreDTO=scoreService.getScoreInfo(exam_id,excellent_line);
            //获取每个学生的成绩单
            allScoreDTO.setScore(scoreService.getEachScore(exam_id));
            //统计成绩分布
            float pass_line= (float) (excellent_line/0.85*0.6);
            allScoreDTO.setScoreDistributionData(genDistribution(pass_line,excellent_line,allScoreDTO.getScore()));
            //具体获取错题统计
            allScoreDTO.setWrongQuestionData(scoreService.getWrongQuestionData(exam_id));
            return ResponseEntity.ok(allScoreDTO);
        }catch (Exception e){
            log.error("getScoreOverall: ", e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * @description: 获取学生成绩单
     * @date: 2025/5/28 15:53
     **/
    @CrossOrigin
    @PostMapping({"/student/scorelist"})
    public ResponseEntity<ReportDTO> getScoreList(@RequestBody Map<String, Object> scoreMap) {
        int exam_id = Integer.parseInt((String) scoreMap.get("exam_id"));
        int student_id = Integer.parseInt((String) scoreMap.get("student_id"));
        try{
            //获得考试相关信息和学生相关
            ReportDTO reportDTO=scoreService.getDetailInfo(exam_id,student_id);
            double accuracy = reportDTO.getTotalScore() / reportDTO.getSum_score();
            reportDTO.setAccuracy(Math.round(accuracy*100 * 10) / 10.0);
            // 获取questions
            //单选
            List<QuestionsDTO> singleQuestion=scoreService.getSingleQuestion(exam_id,student_id);
            //多选
            List<QuestionsDTO> multipleQuestion=scoreService.getMultipleQuestion(exam_id,student_id);
            //填空
            List<QuestionsDTO> fillQuestion=scoreService.getFillQuestion(exam_id,student_id);
            //大题
            List<QuestionsDTO> answerQuestion=scoreService.getAnswerQuestion(exam_id,student_id);
            singleQuestion.addAll(multipleQuestion);
            singleQuestion.addAll(fillQuestion);
            singleQuestion.addAll(answerQuestion);
            reportDTO.setQuestions(singleQuestion);
            return ResponseEntity.ok(reportDTO);
        }catch (Exception e){
            log.error("getReport: ", e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    public List<Object> genDistribution(float passLine, float excellentLine, List<ScoreDTO> score) {
        List<Object> scoreDistributionData = new ArrayList<>();
        int belowPassCount = 0;
        for (ScoreDTO s : score) {
            if (s.getScore() < passLine) {
                belowPassCount++;
            }
        }
        ScoreDistribution belowPass = new ScoreDistribution(String.format("%.0f以下", passLine), belowPassCount);
        scoreDistributionData.add(belowPass);

        float interval = (excellentLine - passLine) / 3;
        float lowerBound = passLine;
        for (int i = 0; i < 3; i++) {
            float upperBound = lowerBound + interval;
            int count = 0;
            for (ScoreDTO s : score) {
                if (s.getScore() >= lowerBound && s.getScore() < upperBound) {
                    count++;
                }
            }
            ScoreDistribution distribution = new ScoreDistribution(
                    String.format("%.0f - %.0f", lowerBound, upperBound), count);
            scoreDistributionData.add(distribution);
            lowerBound = upperBound;
        }

        int lastIntervalCount = 0;
        for (ScoreDTO s : score) {
            if (s.getScore() >excellentLine) {
                lastIntervalCount++;
            }
        }
        ScoreDistribution lastInterval = new ScoreDistribution(
                String.format("%.0f以上", excellentLine), lastIntervalCount);
        scoreDistributionData.add(lastInterval);

        return scoreDistributionData;
    }

    private static class ScoreDistribution {
        private String distribution;
        private int count;

        public ScoreDistribution(String distribution, int count) {
            this.distribution = distribution;
            this.count = count;
        }

        public String getDistribution() {
            return distribution;
        }

        public void setDistribution(String distribution) {
            this.distribution = distribution;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
