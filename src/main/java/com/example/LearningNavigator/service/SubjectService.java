package com.example.LearningNavigator.service;

import com.example.LearningNavigator.entities.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {
    List<Subject> getAllSubjects();

    Subject getSubjectById(int subjectId);

    Subject createSubject(Subject subject);

    void deleteSubject(int subjectId);
}
