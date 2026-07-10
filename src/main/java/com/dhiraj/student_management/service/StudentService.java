package com.dhiraj.student_management.service;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public String addStudent() {
        return "Student added successfully!";
    }
    public String getMessage() {
        return "Student Service is working successfully!";
    }

}
