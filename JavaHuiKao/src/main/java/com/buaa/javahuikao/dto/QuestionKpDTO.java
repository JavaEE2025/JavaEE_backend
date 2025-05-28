package com.buaa.javahuikao.dto;

import com.buaa.javahuikao.entity.Kp;
import com.buaa.javahuikao.entity.Question;

import java.util.List;

/**
 * @author: bush
 * @date: 2025/5/28 11:14
 * @description:
 */
public class QuestionKpDTO extends Question {
    List<Kp> kps;

    public List<Kp> getKps() {
        return kps;
    }

    public void setKps(List<Kp> kps) {
        this.kps = kps;
    }
}
