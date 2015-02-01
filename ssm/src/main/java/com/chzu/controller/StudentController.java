package com.chzu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yanxing on 2015/1/28.
 */
@Controller
public class StudentController {

    @RequestMapping("/index")
    public String index(){
        System.out.println("调转index页面");
        return "index";
    }

}
