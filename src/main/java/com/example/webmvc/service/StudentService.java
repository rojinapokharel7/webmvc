package com.example.webmvc.service;

import com.example.webmvc.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    Student getStudentById(int std_id);
    boolean updateStudent(Student std);
    boolean createStudent(Student std);
    boolean deleteStudent(int std_id);
}
