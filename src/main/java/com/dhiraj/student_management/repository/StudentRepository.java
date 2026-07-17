package com.dhiraj.student_management.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dhiraj.student_management.entity.Student;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByName(String name);
}
