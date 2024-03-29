package com.example.LearningNavigator.Controller;

import com.example.LearningNavigator.entities.Student;
import com.example.LearningNavigator.entities.Subject;
import com.example.LearningNavigator.service.StudentService;
import com.example.LearningNavigator.service.SubjectService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SubjectControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private SubjectService subjectService;

    @Test
    public void testGetAllSubjects() throws Exception {
        Subject subject1 = new Subject();
        subject1.setSubjectId(1);
        subject1.setName("Mathematics");
        Subject subject2 = new Subject();
        subject2.setSubjectId(2);
        subject2.setName("Science");

        List<Subject> subjects = Arrays.asList(subject1, subject2);
        Mockito.when(subjectService.getAllSubjects()).thenReturn(subjects);

        mockMvc.perform(get("/subjects"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(4)));
    }
}
