package com.example.LearningNavigator.controller;

import com.example.LearningNavigator.ExceptionHandler.SubjectNotFoundException;
import com.example.LearningNavigator.entities.Subject;
import com.example.LearningNavigator.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects(){
        List<Subject> subjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable int subjectId){
        Subject subject = subjectService.getSubjectById(subjectId);
        if(subject == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(subject);
    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject){
        Subject createdSubject = subjectService.createSubject(subject);
        return ResponseEntity.ok(createdSubject);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<Void> deleteSubject(@PathVariable int subjectId){
        try{
            subjectService.deleteSubject(subjectId);
            return ResponseEntity.noContent().build();
        }catch(Exception e){
            throw new SubjectNotFoundException("No such subject with id: " + subjectId);
        }

    }
}
