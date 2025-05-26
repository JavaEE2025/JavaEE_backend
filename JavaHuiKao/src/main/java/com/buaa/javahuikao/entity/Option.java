package com.buaa.javahuikao.entity;

/**
 * @Author: sxq
 * @Date: 2025/5/26 20:39
 * @Description:
 */

/**
 * @ClassName: Option
 * @Author: sxq
 * @Sate: 2025/5/26 20:39
 * @Description:
 */
public class Option {
    private int id;
    private String option;
    private boolean isCorrect;
    private int questionId;

    public Option() {}

    public Option(int id, String option, boolean isCorrect, int questionId) {
        this.id = id;
        this.option = option;
        this.isCorrect = isCorrect;
        this.questionId = questionId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getOption() { return option; }
    public void setOption(String option) { this.option = option; }
    public boolean isCorrect() { return isCorrect; }
    public void setCorrect(boolean correct) { isCorrect = correct; }
    public int getQuestionId() { return questionId; }
    public void setQuestionId(int questionId) { this.questionId = questionId; }
}