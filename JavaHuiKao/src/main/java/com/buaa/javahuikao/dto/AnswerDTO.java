package com.buaa.javahuikao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: sxq
 * @Date: 2025/5/27 15:54
 * @Description:
 */

public class AnswerDTO{
    @JsonProperty("text_answer")
    private String textAnswer;
    @JsonProperty("img_answer")
    private byte[] imgAnswer;
    @JsonProperty("option_answers")
    private List<String> optionAnswers;
    //string版本
    private String stringOptionAnswer;

    private Integer recordExists; // 用于标记记录存在

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
        this.stringOptionAnswer = String.join(";", optionAnswers);
    }

    public void setStringOptionAnswer(String stringOptionAnswer) {
        this.stringOptionAnswer = stringOptionAnswer;
        this.optionAnswers = Arrays.asList(stringOptionAnswer.split(";"));
    }

    public String getStringOptionAnswer() {
        return stringOptionAnswer;
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "textAnswer='" + textAnswer + '\'' +
                ", imgAnswer=" + Arrays.toString(imgAnswer) +
                ", optionAnswers=" + optionAnswers +
                ", stringOptionAnswer='" + stringOptionAnswer + '\'' +
                '}';
    }

    public boolean isVoidAnswer(){
        return (textAnswer == null || textAnswer.length() == 0)
                && (imgAnswer == null || imgAnswer.length == 0)
                && (stringOptionAnswer == null || stringOptionAnswer.length() == 0);
    }
}
