package org.example.spring_exercice3.controller;

import org.example.spring_exercice3.model.Student;
import org.example.spring_exercice3.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public String homePage(Model model) {
        model.addAttribute("student", new Student());
        return "home";
    }

    @GetMapping("/student/list")
    public String studentList(Model model) {
        model.addAttribute("students", studentService.getStudents());
        model.addAttribute("mode", "all");
        return "student/list";
    }

    @GetMapping("/student/details/{id}")
    public String details(@PathVariable("id") int id,Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "student/details";
    }

    @GetMapping("/student/add")
    public String formAddStudent(@RequestParam(name = "id", required = false) Integer id, Model model) {
        if (id != null && id > 0) {
            model.addAttribute("student", studentService.getStudentById(id));
        } else {
            model.addAttribute("student", new Student());
        }
        return "student/add";
    }

    @PostMapping("/student/add")
    public String addStudent(@ModelAttribute("student") Student student) {
        // modification
        if(student.getId() > 0) {
            studentService.updateStudent(student);
        }
        // creation
        else {
            studentService.addStudent(student);
        }
        return "redirect:/student/list";
    }

    @GetMapping("/student/search")
    public String searchStudent(String studentName, Model model) {
        model.addAttribute("searchName", studentName);
        model.addAttribute("students", studentService.getStudentsByName(studentName));
        model.addAttribute("mode", "search");
        return "student/list";
    }

    @GetMapping("/student/delete")
    public String deleteStudent(@RequestParam("id") int id) {
        studentService.deleteStudentById(id);
        return "redirect:/student/list";
    }

}
