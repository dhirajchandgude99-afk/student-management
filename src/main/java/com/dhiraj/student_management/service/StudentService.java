package com.dhiraj.student_management.service;
import org.springframework.stereotype.Service;
import com.dhiraj.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.dhiraj.student_management.entity.Student;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }
    public String updateStudent(Student student) {
        studentRepository.save(student);
        return "Student updated successfully!";
    }

    public String addStudent(Student student) {
        studentRepository.save(student);
        return "Student added successfully!";
    }
    public String getMessage() {
        return "Student Service is working successfully!";
    }

}
