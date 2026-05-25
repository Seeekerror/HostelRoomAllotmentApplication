package com.HostelRoomAllotmentApplication.controller;

import com.HostelRoomAllotmentApplication.entity.Student;
import com.HostelRoomAllotmentApplication.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {

    @Autowired
    private StudentService studentService;



    // GET ALL STUDENTS
    @GetMapping

    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }



    // GET STUDENT BY ID
    @GetMapping("/{id}")

    public Student getStudentById(
            @PathVariable Long id
    ) {

        return studentService.getStudentById(id);
    }
}