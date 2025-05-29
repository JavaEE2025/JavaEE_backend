package com.buaa.javahuikao.dto;


import java.util.List;
import java.util.Map;

/**
 * @className: AllScoreDTO
 * @author: bxr
 * @date: 2025/5/28 16:59
 * @description:
 */

public class AllScoreDTO {
    private float average;
    private float max_score;
    private float min_score;
    private float excellent_proportion;
    List<Object> scoreDistributionData;
    List<Object> wrongQuestionData;
    List<ScoreDTO> score;

    public float getAverage() {
        return average;
    }

    public float getMax_score() {
        return max_score;
    }

    public float getMin_score() {
        return min_score;
    }

    public float getExcellent_proportion() {
        return excellent_proportion;
    }

    public List<Object> getScoreDistributionData() {
        return scoreDistributionData;
    }

    public List<Object> getWrongQuestionData() {
        return wrongQuestionData;
    }

    public List<ScoreDTO> getScore() {
        return score;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public void setMax_score(float max_score) {
        this.max_score = max_score;
    }

    public void setMin_score(float min_score) {
        this.min_score = min_score;
    }

    public void setExcellent_proportion(float excellent_proportion) {
        this.excellent_proportion = excellent_proportion;
    }

    public void setScoreDistributionData(List<Object> scoreDistributionData) {
        this.scoreDistributionData = scoreDistributionData;
    }

    public void setWrongQuestionData(List<Object> wrongQuestionData) {
        this.wrongQuestionData = wrongQuestionData;
    }

    public void setScore(List<ScoreDTO> score) {
        this.score = score;
    }
}
