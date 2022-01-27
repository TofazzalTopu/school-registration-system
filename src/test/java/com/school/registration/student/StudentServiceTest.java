package com.school.registration.student;

import com.school.registration.model.Student;
import com.school.registration.repository.StudentRepository;
import com.school.registration.service.StudentService;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@NoArgsConstructor
public class StudentServiceTest {

    @MockBean
    StudentService studentService;

    @MockBean
    StudentRepository studentRepository;

    @Before
    public void setUp() {
        Student alex = new Student();
        alex.setId(1L);
        alex.setName("Alex");
        Mockito.when(studentService.findById(alex.getId()))
                .thenReturn(alex);
    }

    @Test
    public void save() {
        Student student = new Student();
        student.setCode("S001");
        student.setName("Rana");
        Mockito.when(studentService.save(student)).thenReturn(student);
        Assert.assertEquals(student, studentService.save(student));
    }

    @Test
    public void update() {
        Long studentId = 1L;
        Student newStudent = new Student();
        newStudent.setId(studentId);
        newStudent.setCode("S001");
        newStudent.setName("Rana");
        Mockito.when(studentService.save(newStudent)).thenReturn(newStudent);

        Student student = studentService.findById(studentId);
        student.setCode("S099");
        student.setName("Jhon");
        Mockito.when(studentService.save(student)).thenReturn(student);
        Assert.assertEquals(student, studentService.save(student));
    }

    @Test
    public void findById() {
        Long studentId = 1L;
        Student student = new Student();
        student.setCode("1");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);

        Mockito.when(studentService.findById(studentId)).thenReturn(student);
        Assert.assertEquals(student, studentService.findById(studentId));
    }

    @Test
    public void findStudentList() throws Exception {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setId(2L);
        student.setCode("S003");
        student.setName("Peter");
        studentList.add(student);

        Mockito.when(studentRepository.save(student)).thenReturn(student);
        Mockito.when(studentRepository.findAll()).thenReturn(studentList);
        List<Student> students = studentService.findAll();
    }
}
