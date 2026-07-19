package com.dhiraj.student_management.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Getter; //
import lombok.NoArgsConstructor;
//import lombok.Setter;//
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Employee {
 private int id;
 private String name;
 private double salary;
 public static void main(String[] args) {

    Employee emp = new Employee(101, "Dhiraj", 50000);

    System.out.println(emp);
    
}
}

