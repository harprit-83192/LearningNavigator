package com.example.LearningNavigator.service;

import com.example.LearningNavigator.ExceptionHandler.StudentNotFoundException;
import com.example.LearningNavigator.entities.Exam;
import com.example.LearningNavigator.entities.Student;
import com.example.LearningNavigator.entities.Subject;
import com.example.LearningNavigator.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByRegistrationId(int registrationId) {
        try{
            return studentRepository.findByRegistrationId(registrationId);
        }catch(StudentNotFoundException e){
            System.out.println("Student not found with ID: " + registrationId);
        }
        return null;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(int registrationId, Student updatedStudent) {
        Student existingStudent = studentRepository.findByRegistrationId(registrationId);
        if(existingStudent != null){
            updatedStudent.setRegistrationId(existingStudent.getRegistrationId());
            return studentRepository.save(updatedStudent);
        }
        return null;
    }

    @Override
    public void deleteStudent(int registrationId) {
        try{
            Student student = studentRepository.findByRegistrationId(registrationId);
            studentRepository.delete(student);
        }catch(Exception e){
            throw new StudentNotFoundException("No such Student found with id: " + registrationId);
        }
    }

    @Override
    public void enrollStudentInSubject(int registrationId, int subjectId) {
        Student student = studentRepository.findByRegistrationId(registrationId);
        if(student != null){
            Subject subject = new Subject();
            subject.setSubjectId(subjectId);
            student.getEnrolledSubjects().add(subject);
            studentRepository.save(student);
        }else{
            throw new StudentNotFoundException("Student not found with ID: " + registrationId);
        }
    }

    @Override
    public void registerStudentForExam(int registrationId, int examId) {
        Student student = studentRepository.findByRegistrationId(registrationId);
        if(student != null){
            Exam exam = new Exam();
            exam.setExamId(examId);
            student.getRegisteredExams().add(exam);
            studentRepository.save(student);
        }else{
            throw new StudentNotFoundException("Student not found with ID: " + registrationId);
        }
    }
}
