package com.HostelRoomAllotmentApplication.service;

import com.HostelRoomAllotmentApplication.dto.LoginRequest;
import com.HostelRoomAllotmentApplication.dto.RegisterRequest;
import com.HostelRoomAllotmentApplication.entity.Student;
import com.HostelRoomAllotmentApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private StudentRepository studentRepository;

    // REGISTER
    public String register(RegisterRequest request) {

        Student student = new Student();

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setPassword(request.getPassword());
        student.setGender(request.getGender());

        student.setYear(request.getYear());

        student.setCourse(request.getCourse());

        studentRepository.save(student);

        return "Student Registered Successfully";
    }

    // LOGIN
    public String login(LoginRequest request) {

        Student student = studentRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Student Not Found"));

        if (!student.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        return "Login Successful";
    }
}