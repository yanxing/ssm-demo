package com.chzu.service;

import com.chzu.model.Student;
import com.chzu.service.impl.StudentServiceImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import javax.inject.Inject;
import java.util.List;

/**
 * @author yanxing 2015/2/3.
 *         测试业务逻辑层
 */
public class ServiceTest {
    protected static ApplicationContext context;

    //@Resource(name="studentService")
    //@Autowired
    //@Inject
    private static StudentService studentService;

    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("spring.xml");
        studentService = context.getBean(StudentServiceImpl.class);
    }

    //测试获取所有的学生
    @Test
    public void testGetAllStudent() {
        List<Student> students = studentService.getAllStudent();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
