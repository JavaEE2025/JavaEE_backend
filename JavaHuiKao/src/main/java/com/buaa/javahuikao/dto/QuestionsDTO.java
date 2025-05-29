package com.buaa.javahuikao.dto;


import java.util.List;

/**
 * @className: QuestionDTO
 * @author: bxr
 * @date: 2025/5/28 22:56
 * @description:
 */

public class QuestionsDTO {
    private int id;
    private Boolean hasCorrect;
    private String topic;
    private String comment;
    private String correct_answer;
    private String parse;
    private String image;
    private String type;
    private double score;
    private double totalScore;
    private String answer;  //单选专用
    private List<String> answers; //多选专用
    private List<String> selecteds;  //多选专用
    private String selected; //单选
    private double classRate;
    private double yourRate;
    private List<OptionContent> options;

    public void setId(int id) {
        this.id = id;
    }

    public void setHasCorrect(Boolean hasCorrect) {
        this.hasCorrect = hasCorrect;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public void setSelecteds(List<String> selecteds) {
        this.selecteds = selecteds;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public void setClassRate(double classRate) {
        this.classRate = classRate;
    }

    public void setYourRate(double yourRate) {
        this.yourRate = yourRate;
    }

    public void setOptions(List<OptionContent> options) {
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public Boolean getHasCorrect() {
        return hasCorrect;
    }

    public String getTopic() {
        return topic;
    }

    public String getComment() {
        return comment;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public String getImage() {
        return image;
    }

    public String getType() {
        return type;
    }

    public double getScore() {
        return score;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public List<String> getSelecteds() {
        return selecteds;
    }

    public String getSelected() {
        return selected;
    }

    public double getClassRate() {
        return classRate;
    }

    public double getYourRate() {
        return yourRate;
    }

    public List<OptionContent> getOptions() {
        return options;
    }

    private static class OptionContent{
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
