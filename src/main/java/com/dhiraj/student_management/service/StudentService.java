package com.dhiraj.student_management.service;
import org.springframework.stereotype.Service;
import com.dhiraj.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.dhiraj.student_management.entity.Student;
import java.util.List;
import com.dhiraj.student_management.exception.StudentNotFoundException;
import com.dhiraj.student_management.dto.StudentDTO;
import org.modelmapper.ModelMapper;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class StudentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student getStudentByName(String name) {
        return studentRepository.findByName(name)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with name: " + name));
        
    }
    public StudentDTO getStudentDTOById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        return modelMapper.map(student, StudentDTO.class);
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
    public StudentDTO addStudent(StudentDTO studentDTO) {
        log.info("Adding a new student: {}", studentDTO);
        Student student = modelMapper.map(studentDTO, Student.class);
        Student savedStudent = studentRepository.save(student);
        log.info("Student added successfully: {}", savedStudent);
        return studentDTO;
    }
    public List<Student> getStudentsByCourse(String course) {
        return studentRepository.findByCourse(course);
    }

}
