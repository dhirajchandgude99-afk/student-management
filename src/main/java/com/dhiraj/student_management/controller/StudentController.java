package com.dhiraj.student_management.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.dhiraj.student_management.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.dhiraj.student_management.entity.Student;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;


	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable Integer id) {
		return studentService.getStudentById(id).orElse(null);
	}

	@PutMapping("/student")
	public String updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		return studentService.deleteStudent(id);
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
