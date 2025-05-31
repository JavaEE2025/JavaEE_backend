package com.buaa.javahuikao.dto;

/**
 * @Author: sxq
 * @Date: 2025/5/29 10:26
 * @Description:
 */

/**
 * @ClassName: QuestionAnswerDTO
 * @Author: sxq
 * @Sate: 2025/5/29 10:26
 * @Description: questionID + answerDTO
 */
public class QuestionAnswerDTO {
    private int question_id;
    private AnswerDTO answer;

    public QuestionAnswerDTO() {
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public AnswerDTO getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerDTO answer) {
        this.answer = answer;
    }
}
