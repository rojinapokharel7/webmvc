package com.example.webmvc.service;

import com.example.webmvc.dao.StudentDao;
import com.example.webmvc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao stddao;
    @Override
    public List<Student> getAllStudent() {
        List<Student> stdlist = stddao.getAllStudent();
        return stdlist;
    }

    @Override
    public Student getStudentById(int std_id) {
        Student std = stddao.getStudentById(std_id);
        return std;
    }

    @Override
    public boolean updateStudent(Student std) {
        boolean isUpdateSuccess= stddao.updateStudent(std);
        return isUpdateSuccess;
    }

    @Override
    public boolean createStudent(Student std) {
        boolean isCreateSuccess= stddao.createStudent(std);
        return isCreateSuccess;
    }

    @Override
    public boolean deleteStudent(int std_id) {
        boolean isDeleteSucess = stddao.deleteStudent(std_id);
        return isDeleteSucess;
    }
}
