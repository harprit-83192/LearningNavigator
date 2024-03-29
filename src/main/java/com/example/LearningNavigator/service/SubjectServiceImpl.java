package com.example.LearningNavigator.service;

import com.example.LearningNavigator.ExceptionHandler.SubjectNotFoundException;
import com.example.LearningNavigator.entities.Subject;
import com.example.LearningNavigator.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubjectById(int subjectId) {
        try{
            return subjectRepository.findBySubjectId(subjectId);
        }catch(SubjectNotFoundException e){
            System.out.println("Subject not found with ID: " + subjectId);
        }
        return null;
    }

    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(int subjectId) {
        try{
            Subject subject = subjectRepository.findBySubjectId(subjectId);
            subjectRepository.delete(subject);
        }catch(Exception e){
            throw new SubjectNotFoundException("No such subject with id: " + subjectId);
        }
    }
}
