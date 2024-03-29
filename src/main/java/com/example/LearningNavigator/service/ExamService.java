package com.example.LearningNavigator.service;

import com.example.LearningNavigator.entities.Exam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamService {

    List<Exam> getAllExams();

    Exam getExamById(int examId);

    Exam createExam(Exam exam);

    void deleteExam(int examId);

    void registerStudentForExam(int examId, int registrationId);
}
