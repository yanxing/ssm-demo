package com.chzu.controller;

import com.chzu.model.Student;
import com.chzu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.validation.Valid;
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
        model.addAttribute("list",list);
        return "list";
    }

    /**
     * 删除学生，重定向list
     */
    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id")String id){
        studentService.deleteStudent(Integer.valueOf(id));
        return "redirect:/ list ";
    }

    /**
     * 加载学生信息
     */
    @RequestMapping("/update-view")
    public String updateView(@RequestParam("id") String id,ModelMap model){
        Student student=studentService.getStudent(Integer.valueOf(id));
        model.addAttribute("student",student);
        return "update";
    }

    /**
     * 加载搜索视图
     */
    @RequestMapping("/search-view")
    public String searchView(){
        return "search";
    }

    /**
     * 加载添加学生视图
     */
    @RequestMapping("/add-view")
    public String addView(){
        return "add";
    }

    /**
     * 更新
     */
    @RequestMapping("/update")
    public String update(@ModelAttribute Student student){
        System.out.println(student);
        studentService.updateStudent(student);
        return "redirect:/list";
    }

    /**
     * 添加
     */
    @RequestMapping("/add")
    public String add(@ModelAttribute Student student){
        System.out.println(student);
        studentService.addStudent(student);
        return "redirect:/list";
    }

    /**
     * 搜索学生
     */
    @RequestMapping("/search")
    public ModelAndView search(@Valid Student  student, Errors errors,ModelMap model,@RequestParam("number") String numberP){
        if(errors.hasErrors()) {
            System.out.println(errors.getFieldError("number"));
            //errors.rejectValue("username","不能为空！");
            return new ModelAndView("search","errors",errors);
        }else {
            Student student1=studentService.getStudent(numberP);
            System.out.println(student1);
            model.addAttribute("student",student1);
            return new ModelAndView("search");
        }
    }


}
