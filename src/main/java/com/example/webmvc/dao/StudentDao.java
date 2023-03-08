package com.example.webmvc.dao;

import com.example.webmvc.helper.DBConnector;
import com.example.webmvc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class StudentDao {
    @Autowired
    private DBConnector dbConnector;
    public List<Student> getAllStudent(){
        List<Student> stdList = new ArrayList<>();
        Connection conn = dbConnector.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
            while(rs.next()){
                Student std = new Student();
                std.setStd_id(rs.getInt("std_id"));
                std.setStd_name(rs.getString("std_name"));
                std.setStd_address(rs.getString("std_address"));
                std.setStd_contactNum(rs.getString("std_contactnum"));
                std.setStd_grade(rs.getString("std_grade"));
                stdList.add(std);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return stdList;
    }
    public Student getStudentById(int std_id){
        Student std = new Student();
        Connection conn = dbConnector.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Student where std_id = ?");
            pstmt.setInt(1, std_id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
               std.setStd_id(rs.getInt("std_id"));
               std.setStd_name(rs.getString("std_name"));
               std.setStd_address(rs.getString("std_address"));
               std.setStd_contactNum(rs.getString("std_contactNum"));
               std.setStd_grade(rs.getString("std_grade"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return std;
    }

    public boolean updateStudent(Student std){
        boolean status = false;
        Connection conn = dbConnector.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE Student SET std_name =? , std_address = ?, std_contactnum = ?, std_grade = ? WHERE std_id = ?");
            pstmt.setString(1, std.getStd_name());
            pstmt.setString(2, std.getStd_address());
            pstmt.setString(3, std.getStd_contactNum());
            pstmt.setString(4, std.getStd_grade());
            pstmt.setInt(5, std.getStd_id());
            int count = pstmt.executeUpdate();
            if (count>0){
                status = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return status;
    }
    public boolean createStudent(Student std){
        boolean status = false;
        Connection conn = dbConnector.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Student (std_name, std_address, std_contactnum, std_grade) VALUES (? , ?, ?, ?)");
            pstmt.setString(1, std.getStd_name());
            pstmt.setString(2, std.getStd_address());
            pstmt.setString(3, std.getStd_contactNum());
            pstmt.setString(4, std.getStd_grade());
            int count = pstmt.executeUpdate();
            if (count>0){
                status = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return status;
    }
    public boolean deleteStudent(int std_id){
        boolean status = false;
        Connection conn = dbConnector.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Student WHERE std_id = ?");
            pstmt.setInt(1, std_id);
            int count = pstmt.executeUpdate();
            if (count>0){
                status = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return status;
    }

}
