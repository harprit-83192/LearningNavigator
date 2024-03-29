package com.example.LearningNavigator.service;

import com.example.LearningNavigator.ExceptionHandler.ExamNotFoundException;
import com.example.LearningNavigator.ExceptionHandler.StudentNotFoundException;
import com.example.LearningNavigator.ExceptionHandler.SubjectNotFoundException;
import com.example.LearningNavigator.entities.Exam;
import com.example.LearningNavigator.entities.Student;
import com.example.LearningNavigator.entities.Subject;
import com.example.LearningNavigator.repository.ExamRepository;
import com.example.LearningNavigator.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService{

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public Exam getExamById(int examId) {
        try{
            return examRepository.findByExamId(examId);
        }catch(ExamNotFoundException e){
            System.out.println("Exam not Found with ID: " + examId);
        }
        return null;
    }

    @Override
    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public void deleteExam(int examId) {
        try{
            examRepository.delete(examRepository.findByExamId(examId));
        }catch (Exception e){
            throw new ExamNotFoundException("No such exam existed with id: " + examId);
        }

    }

    @Override
    public void registerStudentForExam(int examId, int registrationId) {
        Exam exam = getExamById(examId);
        Student student = studentService.getStudentByRegistrationId(registrationId);
        if(student != null && exam != null){
            for(Subject subject:student.getEnrolledSubjects()){
                if(subject.getSubjectId() == exam.getSubject()){
                    exam.getRegisteredStudents().add(student);
                    examRepository.save(exam);
                }else{
                    throw new SubjectNotFoundException("Student is not enrolled in Subject ID: " + exam.getSubject());
                }
            }
        }else{
            throw new StudentNotFoundException("Student not found with Registration ID: " + registrationId);
        }
    }
}
