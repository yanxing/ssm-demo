package com.chzu.controller;

import com.chzu.model.Student;
import com.chzu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.List;

/**
 * @author yanxing on 2015/1/28.
 */
@Controller
public class StudentController {


    //@Resource
    //@Autowired
    @Inject
    private StudentService studentService;

    /**
     * 显示主页
     */
    @RequestMapping("/index")
    public String index(){
        System.out.println("调转index页面");
        return "index";
    }

    /**
     * 显示所有学生
     */
    @RequestMapping("/list")
    public String list(ModelMap model){
        List<Student> list=studentService.getAllStudent();
        for(Student student:list){
            System.out.println(student);
        }
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id")String id){
        studentService.deleteStudent(Integer.valueOf(id));
        return "redirect:/ list ";
    }

}
