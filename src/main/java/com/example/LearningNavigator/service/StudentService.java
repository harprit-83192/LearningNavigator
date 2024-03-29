package com.example.LearningNavigator.service;

import com.example.LearningNavigator.entities.Student;
import com.example.LearningNavigator.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> getAllStudents();
    Student getStudentByRegistrationId(int registrationId);
    Student createStudent(Student student);
    Student updateStudent(int registrationId, Student updatedStudent);
    void deleteStudent(int registrationId);
    void enrollStudentInSubject(int registrationId, int subjectId);
    void registerStudentForExam(int registrationId, int examId);
}
