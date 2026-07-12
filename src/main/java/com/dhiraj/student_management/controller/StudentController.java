package com.dhiraj.student_management.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.dhiraj.student_management.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.dhiraj.student_management.entity.Student;
import java.util.List;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("/student")
	public String getStudent() {
		return "student API is working successfully!";
	}
	@PostMapping("/student")
	public String addStudent(@RequestBody Student student) {
		// Logic to add the student to the database or perform any other operation
		return studentService.addStudent(student);
	}

}
