package com.example.LearningNavigator.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "ExamID")
    private int examId;

    @Column(name = "Subject")
    private int subject;

    @JsonIgnore
    @ManyToMany(mappedBy = "registeredExams")
    private Set<Student> registeredStudents = new HashSet<>();
}
