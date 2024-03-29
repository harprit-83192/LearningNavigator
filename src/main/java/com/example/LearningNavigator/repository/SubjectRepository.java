package com.example.LearningNavigator.repository;

import com.example.LearningNavigator.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Subject findBySubjectId(int subjectId);
}
