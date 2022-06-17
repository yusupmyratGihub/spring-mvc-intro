package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {



    @RequestMapping("/welcome")
    @ResponseBody
    public String welcome(){
        return "welcome to Student Controller";

    }
    @Autowired
    private IStudentService iStudentService;
    @RequestMapping(value="/students",method = RequestMethod.GET)
    public ModelAndView getStudents(){
        ModelAndView mav=new ModelAndView();
        List<Student> list=iStudentService.getAll();
        mav.addObject("students",list);
        mav.setViewName("students");
        return mav;
    }
}
