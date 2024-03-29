package com.example.LearningNavigator.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(unique = true, name = "RegistrationID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registrationId;

    @Column(name = "Name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_subjects",
            joinColumns = @JoinColumn(name = "RegistrationID"),
            inverseJoinColumns = @JoinColumn(name = "SubjectID")
    )
    private Set<Subject> enrolledSubjects = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "student_exams",
            joinColumns = @JoinColumn(name = "StudentID"),
            inverseJoinColumns = @JoinColumn(name = "ExamID")
    )
    private Set<Exam> registeredExams = new HashSet<>();
}
