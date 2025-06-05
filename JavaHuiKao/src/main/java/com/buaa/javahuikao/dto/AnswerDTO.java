package com.buaa.javahuikao.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String imgBase64;

    @JsonIgnore
    private byte[] imgAnswer;



    @JsonProperty("option_answers")
    private List<String> optionAnswers = new ArrayList<>();;
    //string版本
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String stringOptionAnswer;
    @JsonInclude(JsonInclude.Include.NON_NULL)
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

    public void decodeBase64Image() {
        if (this.imgBase64 != null && !this.imgBase64.isEmpty()) {
            this.imgAnswer = Base64.getDecoder().decode(this.imgBase64.split(",")[1]);
        }
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
