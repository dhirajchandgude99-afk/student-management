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
import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;

@Slf4j
@Service
public class StudentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentRepository studentRepository;
    // public List<Student> getAllStudents() {
    //     return studentRepository.findAll();
    // }
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

    public void deleteStudent(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        studentRepository.delete(student);
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
    public StudentDTO updateStudent(Integer id, StudentDTO studentDTO) {
        log.info("Updating student with id: {}", id);
        Student Student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
       Student.setName(studentDTO.getName());
        Student.setAge(studentDTO.getAge());
        Student.setCourse(studentDTO.getCourse());
        Student updatedStudent = studentRepository.save(Student);
        log.info("Student updated successfully: {}", updatedStudent);
        return modelMapper.map(updatedStudent, StudentDTO.class);
    }
    // public Page<StudentDTO> getAllStudents(Pageable pageable) {
    //     Page<Student> students = studentRepository.findAll(pageable);
    //     return students.map(student -> modelMapper.map(student, StudentDTO.class));
    // }
    public List<StudentDTO>getAllStudentsSorted(String field){
        List<Student>students = studentRepository.findAll(Sort.by(field));
        return students.stream().map(student -> modelMapper.map(student, StudentDTO.class))
                .toList();
    }
    public Page<StudentDTO> getAllStudentsWithPaginationAndSorting(int page, int size,String field) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(field));
        Page<Student> students = studentRepository.findAll(pageRequest);
        return students.map(student -> modelMapper.map(student, StudentDTO.class));
    }
    public List<StudentDTO> getStudentsByAgeGreaterThan(Integer age) {
        System.out.println("Age: " + age);
        List<Student> students = studentRepository.findStudentsByAgeGreaterThan(age);
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .toList();
                
    }
    public List<StudentDTO>getStudentsByAgeGreaterThanNative(Integer age){

        List<Student> students =studentRepository.findStudentsByAgeGreaterThanNative(age);

        return students.stream()
              .map(student -> modelMapper.map(student,StudentDTO.class))
              .toList();
    }

}
