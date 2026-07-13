package com.dhiraj.student_management.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Student {
    @Id
    private Integer id;
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @Min(value = 18, message = "Age must be at least 18")
    private int age;
    @NotBlank(message = "Course cannot be empty")
    private String course;
    

    // Constructors
    public Student() {
    }

    public Student(Integer id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
     @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", course=" + course + "]";
    }
}
