package com.dhiraj.student_management.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dhiraj.student_management.entity.Student;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByName(String name);
    List<Student> findByCourse(String course);

    @Query("SELECT s FROM Student s WHERE s.age > :age")
    List<Student> findStudentsByAgeGreaterThan(@Param("age") Integer age);
}
