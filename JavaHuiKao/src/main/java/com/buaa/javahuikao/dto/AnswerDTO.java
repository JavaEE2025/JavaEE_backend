package com.buaa.javahuikao.dto;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: sxq
 * @Date: 2025/5/27 15:54
 * @Description:
 */

public class AnswerDTO{
    private String textAnswer;
    private byte[] imgAnswer;
    private List<String> optionAnswers;

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    public byte[] getImgAnswer() {
        return imgAnswer;
    }

    public void setImgAnswer(byte[] imgAnswer) {
        this.imgAnswer = imgAnswer;
    }

    public List<String> getOptionAnswers() {
        return optionAnswers;
    }

    public void setOptionAnswers(List<String> optionAnswers) {
        this.optionAnswers = optionAnswers;
    }

    public String getStringOptAns(){
        return  String.join(";", optionAnswers);
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "textAnswer='" + textAnswer + '\'' +
                ", imgAnswer=" + Arrays.toString(imgAnswer) +
                ", optionAnswers=" + optionAnswers +
                '}';
    }
}
