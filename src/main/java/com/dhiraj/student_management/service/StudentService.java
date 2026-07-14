package com.dhiraj.student_management.service;
import org.springframework.stereotype.Service;
import com.dhiraj.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.dhiraj.student_management.entity.Student;
import java.util.List;
import com.dhiraj.student_management.exception.StudentNotFoundException;
import com.dhiraj.student_management.dto.StudentDTO;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public StudentDTO getStudentDTOById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setCourse(student.getCourse());
        return studentDTO;
    }
    public String updateStudent(Student student) {
        studentRepository.save(student);
        return "Student updated successfully!";
    }

    public String addStudent(Student student) {
        studentRepository.save(student);
        return "Student added successfully!";
    }

    public String deleteStudent(Integer id) {
        studentRepository.deleteById(id);
        return "Student deleted successfully!";
    }
    public String getMessage() {
        return "Student Service is working successfully!";
    }

}
