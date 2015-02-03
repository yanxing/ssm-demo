package com.chzu.controller;

import com.chzu.model.Student;
import com.chzu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.List;

/**
 * @author yanxing on 2015/1/28.
 */
@Controller
public class StudentController {

    //@Inject
    //@Resource
    @Autowired
    private StudentService studentService;

    @RequestMapping("/index")
    public String index(){
        System.out.println("调转index页面");
        return "index";
    }

    public String list(){
        List<Student> list=studentService.getAllStudent();
        for(Student student:list){
            System.out.println(student);
        }
        return "list";
    }

}
