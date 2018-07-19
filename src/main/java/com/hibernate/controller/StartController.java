package com.hibernate.controller;


import com.hibernate.entity.Student;
import com.hibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/")
public class StartController {

    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "start", method = RequestMethod.GET)
    public String getStudentList(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("studentList", studentService.studentList());
        return "start";
    }

    @RequestMapping(value = "/start/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student) {
        if (student.getIdStud()==0) {
            studentService.addSudent(student);
        } else {
            studentService.updateStudent(student);
        }
        return "redirect:/start";
    }

    @RequestMapping("/remove/{id}")
    public String removeStudent(@PathVariable("id") int id) {
        studentService.removeStudent(id);
        return "redirect:/start";
    }

    @RequestMapping("edit/{id}")
    public String editStudent(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", this.studentService.getById(id));
        model.addAttribute("studentList", this.studentService.studentList());
        return "start";
    }

    @RequestMapping("studentdata/{id}")
    public String studData(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentService.getById(id));
        return "studentdata";
    }
}
