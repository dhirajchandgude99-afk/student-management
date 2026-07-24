package com.dhiraj.student_management.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.dhiraj.student_management.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.dhiraj.student_management.entity.Student;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import com.dhiraj.student_management.dto.StudentDTO;
import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;


	// @GetMapping("/students")
	// public List<Student> getAllStudents() {
	// 	return studentService.getAllStudents();
	// }

	@GetMapping("/students/dto/{id}")
	public ResponseEntity<StudentDTO> getStudentDTOById(@PathVariable Integer id) {
		return ResponseEntity.ok(studentService.getStudentDTOById(id));
	}

	@GetMapping("/students/name/{name}")
	public ResponseEntity<Student> getStudentByName(@PathVariable String name) {
		return ResponseEntity.ok(studentService.getStudentByName(name));
	}

	@GetMapping("/message")
	public ResponseEntity<String> getMessage() {
		return ResponseEntity.ok(studentService.getMessage());
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
		studentService.deleteStudent(id);
		return ResponseEntity.ok("Student deleted successfully!");
	}

	@GetMapping("/student")
	public String getStudent() {
		return "student API is working successfully!";
	}

	@PostMapping("/student")
	public ResponseEntity<String> addStudent(@Valid @RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
	}

	@GetMapping("/students/course/{course}")
	public ResponseEntity<List<Student>> getStudentsByCourse(@PathVariable String course) {
		return ResponseEntity.ok(studentService.getStudentsByCourse(course));
	}
	@PutMapping("/students/{id}")
	public ResponseEntity<StudentDTO> updateStudent(@PathVariable Integer id, @Valid @RequestBody StudentDTO studentDTO) {
		return ResponseEntity.ok(studentService.updateStudent(id, studentDTO));
	}
	// @GetMapping("/students/page")
	// public ResponseEntity<Page<StudentDTO>> getAllStudents(Pageable pageable) {
	// 	return ResponseEntity.ok(studentService.getAllStudents(pageable));
	// }
	@GetMapping("/students/sort/{field}")
	public ResponseEntity<List<StudentDTO>> getAllStudentsSorted(@PathVariable String field) {
		return ResponseEntity.ok(studentService.getAllStudentsSorted(field));
	}
	@GetMapping("/students/page-sort")
	public ResponseEntity<Page<StudentDTO>> getAllStudentsWithPaginationAndSorting(
			@RequestParam int page,
			@RequestParam int size,
			@RequestParam String field) {
		return ResponseEntity.ok(studentService.getAllStudentsWithPaginationAndSorting(page, size, field));
	}
	
	@GetMapping("/students/age/{age}")
	public ResponseEntity<List<StudentDTO>> getStudentsByAgeGreaterThan(@PathVariable Integer age) {
		return ResponseEntity.ok(studentService.getStudentsByAgeGreaterThan(age));
	}

	@GetMapping("/students/native/age/{age}")
    public ResponseEntity<List<StudentDTO>>getStudentsByAgeGreaterThanNative(@PathVariable Integer age){
        return ResponseEntity.ok(studentService.getStudentsByAgeGreaterThanNative(age));
    }  

}