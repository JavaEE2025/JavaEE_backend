package com.example.javahk.entity;

/**
 * @Author: sxq
 * @Date: 2025/5/26 20:40
 * @Description:
 */

/**
 * @ClassName: QuestionKp
 * @Author: sxq
 * @Sate: 2025/5/26 20:40
 * @Description:
 */
public class QuestionKp {
    private int questionId;
    private int kpId;

    public QuestionKp() {}

    public QuestionKp(int questionId, int kpId) {
        this.questionId = questionId;
        this.kpId = kpId;
    }

    // Getters and Setters
    public int getQuestionId() { return questionId; }
    public void setQuestionId(int questionId) { this.questionId = questionId; }
    public int getKpId() { return kpId; }
    public void setKpId(int kpId) { this.kpId = kpId; }
}
