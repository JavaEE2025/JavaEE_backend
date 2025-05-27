package com.buaa.javahuikao.service;


import com.buaa.javahuikao.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: ScoreService
 * @author: bxr
 * @date: 2025/5/26 23:20
 * @description:
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
}
