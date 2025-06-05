package com.buaa.javahuikao.service;


import com.buaa.javahuikao.controller.InvigilationController;
import com.buaa.javahuikao.dto.BehaviorDTO;
import com.buaa.javahuikao.dto.QuestionAnswerDTO;
import com.buaa.javahuikao.dto.SingleAnswersContentDTO;
import com.buaa.javahuikao.dto.StudentExamAnswersDTO;
import com.buaa.javahuikao.entity.StudentAnswers;
import com.buaa.javahuikao.entity.StudentAnswersContent;
import com.buaa.javahuikao.mapper.StudentAnswersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @className: StudentAnswersService
 * @author: bxr
 * @date: 2025/5/27 19:43
 * @description:
 */

@Service
public class StudentAnswersService {
    @Autowired
    private StudentAnswersMapper studentAnswersMapper;
    @Autowired
    private StudentAnswersContentService studentAnswersContentService;
    @Autowired
    private InvigilationController invigilationController;


    public int getRealPersonCnt(int examId) {
        return studentAnswersMapper.getRealPersonCnt(examId);
    }

    public int getPrePersonCnt(int examId) {
        return studentAnswersMapper.getPrePersonCnt(examId);
    }


    public void submitExamAnswers(StudentExamAnswersDTO dto){
        //修改studentAnswers表
        int exam_id = dto.getExam_id();
        int student_id = dto.getStudent_id();
        studentAnswersMapper.submitExam(exam_id,student_id);

        //修改答案内容
        for(QuestionAnswerDTO QADTO : dto.getAnswer_list()){
            SingleAnswersContentDTO SACDTO = new SingleAnswersContentDTO();
            SACDTO.setExamId(dto.getExam_id());
            SACDTO.setStudentId(dto.getStudent_id());
            SACDTO.setQuestionId(QADTO.getQuestion_id());
            SACDTO.setAnswer(QADTO.getAnswer());
            studentAnswersContentService.submitAnswer(SACDTO);
        }
        invigilationController.singleStatusNotify(exam_id,student_id,"已交卷", "");

    }

    @Async("statusUpdateExecutor")
    public void updateStatus(BehaviorDTO behaviorDTO){
        int exam_id = behaviorDTO.getExam_id();
        int student_id = behaviorDTO.getStudent_id();
        String status = behaviorDTO.getBehavior_type();
        //更新数据库
        if("考试中".equals(status)){
            studentAnswersMapper.beginExam(exam_id,student_id);
        }
        else if("异常".equals(status)){
            String behavior = behaviorDTO.getDescription();
            studentAnswersMapper.addAbnormalBehavior(exam_id,student_id,behavior);
        }
        //通知教师端
        invigilationController.singleStatusNotify(exam_id,student_id,status, behaviorDTO.getDescription());
    }

}
