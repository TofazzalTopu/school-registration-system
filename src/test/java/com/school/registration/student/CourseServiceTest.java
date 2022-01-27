package com.school.registration.student;

import com.school.registration.model.Course;
import com.school.registration.model.Student;
import com.school.registration.repository.CourseRepository;
import com.school.registration.repository.StudentRepository;
import com.school.registration.service.CourseService;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
public class CourseServiceTest {

    @MockBean
    CourseService courseService;

    @MockBean
    CourseRepository courseRepository;

    @Before
    public void setUp() {
        Course cse = new Course();
        cse.setId(1L);
        cse.setName("CSE");
        Mockito.when(courseService.findById(cse.getId()))
                .thenReturn(cse);
    }

    @Test
    public void save() {
        Course course = new Course();
        course.setCode("C001");
        course.setName("Math");
        Mockito.when(courseService.save(course)).thenReturn(course);
        Assert.assertEquals(course, courseService.save(course));
    }

    @Test
    public void update() {
        Long id = 1L;
        Course newCourse = new Course();
        newCourse.setId(id);
        newCourse.setCode("C001");
        newCourse.setName("Algebra");
        Mockito.when(courseService.save(newCourse)).thenReturn(newCourse);

        Course course = courseService.findById(id);
        course.setCode("C099");
        course.setName("Physics");
        Mockito.when(courseService.save(course)).thenReturn(course);
        Assert.assertEquals(course, courseService.save(course));
    }

    @Test
    public void findById() {
        Long id = 1L;
        Course course = new Course();
        course.setCode("1");
        List<Course> courseList = new ArrayList<>();
        courseList.add(course);

        Mockito.when(courseService.findById(id)).thenReturn(course);
        Assert.assertEquals(course, courseService.findById(id));
    }

    @Test
    public void findCourseList() throws Exception {
        List<Course> courseList = new ArrayList<>();
        Course course = new Course();
        course.setId(2L);
        course.setCode("C0088");
        course.setName("Chemistry");
        courseList.add(course);

        Mockito.when(courseRepository.save(course)).thenReturn(course);
        Mockito.when(courseRepository.findAll()).thenReturn(courseList);
        List<Course> students = courseService.findAll();
    }
}
