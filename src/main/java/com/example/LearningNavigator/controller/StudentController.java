package com.example.LearningNavigator.controller;

import com.example.LearningNavigator.ExceptionHandler.StudentNotFoundException;
import com.example.LearningNavigator.ExceptionHandler.SubjectNotFoundException;
import com.example.LearningNavigator.entities.Student;
import com.example.LearningNavigator.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{registrationId}")
    public ResponseEntity<Student> getStudentByRegistrationId(@PathVariable int registrationId){
        Student student = studentService.getStudentByRegistrationId(registrationId);
        if(student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PutMapping("/{registrationId}")
    public ResponseEntity<Student> updateStudent(@PathVariable int registrationId, @RequestBody Student student){
        Student updatedStudent = studentService.updateStudent(registrationId,student);
        if(updatedStudent == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{registrationId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int registrationId){
        try{
            studentService.deleteStudent(registrationId);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            throw new StudentNotFoundException("No such Student found with id: " + registrationId);
        }

    }

    @PostMapping("/{registrationId}/enroll/{subjectId}")
    public ResponseEntity<Void> enrollStudentInSubject(@PathVariable int registrationId, @PathVariable int subjectId){
        studentService.enrollStudentInSubject(registrationId, subjectId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{registrationId}/register/{examId}")
    public ResponseEntity<Void> registerStudentForExam(@PathVariable int registrationId, @PathVariable int examId){
        try {
            studentService.registerStudentForExam(registrationId, examId);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            throw new SubjectNotFoundException("Student is not enrolled in Subject for Exam: " + examId);
        }
    }

}
