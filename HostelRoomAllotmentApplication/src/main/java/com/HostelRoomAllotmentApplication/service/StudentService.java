package com.HostelRoomAllotmentApplication.service;

import com.HostelRoomAllotmentApplication.entity.Student;
import com.HostelRoomAllotmentApplication.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;



    // GET ALL STUDENTS
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }



    // GET STUDENT BY ID
    public Student getStudentById(Long id) {

        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student Not Found"));
    }
}