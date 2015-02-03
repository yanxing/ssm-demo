package com.chzu.service;

import com.chzu.model.Student;
import com.chzu.service.impl.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.inject.Inject;
import java.util.List;

/**
 * @author yanxing 2015/2/3.
 * 测试业务逻辑层
 */
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class ServiceTest {

    @Inject
    //@Resource(name="studentService")
    //@Autowired
    private StudentServiceImpl studentService;

    //测试获取所有的学生
    @Test
    public void testGetAllStudent(){
        List<Student> students=studentService.getAllStudent();
        for(Student student:students){
            System.out.println(student);
        }
    }
}
