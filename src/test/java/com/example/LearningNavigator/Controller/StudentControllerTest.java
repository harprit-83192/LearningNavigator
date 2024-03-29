package com.example.LearningNavigator.Controller;

import com.example.LearningNavigator.entities.Student;
import com.example.LearningNavigator.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private StudentService studentService;

    @Test
    public void testGetStudentById() throws Exception {
        Student student = new Student();
        student.setRegistrationId(1);
        student.setName("Govind");

        Mockito.when(studentService.getStudentByRegistrationId(1)).thenReturn(student);

        mockMvc.perform(get("/students/{id}",1))
                .andExpect(status().isOk());
    }
}
