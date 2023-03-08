package com.example.webmvc.controller;

import com.example.webmvc.model.Student;
import com.example.webmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService stdService;

    @GetMapping("/student-list")
    public String getAllStudent(Model model) {
        List<Student> stdList = stdService.getAllStudent();
        model.addAttribute("listStudent", stdList);
        return "student-list";
    }

    @GetMapping("/edit-student/{id}")
    public String editStudent(@PathVariable("id") int std_id, Model model) {
        Student std = stdService.getStudentById(std_id);
        model.addAttribute("student", std);
        return "edit-student";
    }

    @PostMapping("student/update")
    public String updateStudent(@ModelAttribute("student") Student std) {
        boolean isUpdateSuccess = stdService.updateStudent(std);
        if (isUpdateSuccess) {
            return "redirect:/student-list";
        } else {
            return "redirect:/edit-student/" + std.getStd_id();
        }
    }
    @GetMapping("/create-student")
    public String createStudent(Model model) {
        Student std = new Student();
        model.addAttribute("student", std);
        return "create-student";
    }
    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute("student") Student std){
        boolean isCreateSuccess = stdService.createStudent(std);
        if (isCreateSuccess) {
            return "redirect:/student-list";
        } else {
            return "redirect:/create-student";
        }
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable("id") int std_id){
        boolean isDeleteSucess = stdService.deleteStudent(std_id);
        return "redirect:/student-list";
    }
}
