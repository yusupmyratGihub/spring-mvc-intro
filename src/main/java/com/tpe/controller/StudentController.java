package com.tpe.controller;
import java.util.List;

import com.tpe.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.tpe.domain.Student;
@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/welcome")
    @ResponseBody
    public String welcome() {
        return "Welcome to Student Controller";
    }


    @GetMapping("/sayHi")
    public ModelAndView sayHi() {
        ModelAndView mav=new ModelAndView();
        mav.addObject("message","Hi");
        mav.setViewName("try");
        return mav;
    }


    //@RequestMapping(value="/students", method=RequestMethod.GET)
    @GetMapping
    public ModelAndView getStudents() {
        List<Student> list = studentService.getAll();
        ModelAndView mav=new ModelAndView();
        mav.addObject("students",list);
        mav.setViewName("students");
        return mav;
    }


    @GetMapping("/new")
    public String newStudent(@ModelAttribute("student") Student student) {
        return "newStudent";
    }


    @PostMapping("/new")
    public String createStudent(@ModelAttribute Student student) {
        studentService.createStudent(student);
        return "redirect:/students";
    }


    @GetMapping("/update/{id}")
    public String getStudent(@PathVariable Long id, ModelMap modelMap) {
        Student student= studentService.findStudent(id);
        modelMap.put("student", student);
        return "updateStudent";
    }


    @PostMapping("/update/{id}")
    public String updateStudent(@ModelAttribute Student student) {
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String getStudentForDelete(@PathVariable Long id, ModelMap modelMap) {
        Student student= studentService.findStudent(id);
        modelMap.put("student", student);
        return "deleteStudent";
    }


    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }




}