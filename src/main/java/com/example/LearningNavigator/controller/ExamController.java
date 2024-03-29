package com.example.LearningNavigator.controller;

import com.example.LearningNavigator.ExceptionHandler.ExamNotFoundException;
import com.example.LearningNavigator.entities.Exam;
import com.example.LearningNavigator.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping
    public ResponseEntity<List<Exam>> getAllExams(){
        try {
            List<Exam> exams = examService.getAllExams();
            return ResponseEntity.ok(exams);
        }catch (Exception e){
            throw new ExamNotFoundException("No Exams found yet!");
        }
    }

    @GetMapping("/{examId}")
    public ResponseEntity<Exam> getExamById(@PathVariable int examId){
        Exam exam = examService.getExamById(examId);
        if(exam == null){
            throw new ExamNotFoundException("Exam with ID: " + examId + " not found!");
        }
        return ResponseEntity.ok(exam);
    }

    @PostMapping
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam){
        Exam createdExam = examService.createExam(exam);
        return ResponseEntity.ok(createdExam);
    }

    @DeleteMapping("/{examId}")
    public ResponseEntity<Void> deleteExam(@PathVariable int examId){
        try{
            Exam exam = examService.getExamById(examId);
            examService.deleteExam(examId);
            return ResponseEntity.noContent().build();
        }catch(Exception e){
            throw new ExamNotFoundException("No such exam existed with id: " + examId);
        }
    }

    @PostMapping("/{examId}/registerStudent/{registrationId}")
    public ResponseEntity<Void> registerStudentForExam(@PathVariable int examId, @PathVariable int registrationId){
        examService.registerStudentForExam(examId, registrationId);
        return ResponseEntity.ok().build();
    }
}
