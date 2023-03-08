package com.example.webmvc.model;

public class Student {
    private int std_id;
    private String std_name;
    private String std_address;
    private String std_contactNum;
    private String std_grade;

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public String getStd_address() {
        return std_address;
    }

    public void setStd_address(String std_address) {
        this.std_address = std_address;
    }

    public String getStd_contactNum() {
        return std_contactNum;
    }

    public void setStd_contactNum(String std_contactNum) {
        this.std_contactNum = std_contactNum;
    }

    public String getStd_grade() {
        return std_grade;
    }

    public void setStd_grade(String std_grade) {
        this.std_grade = std_grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "std_id=" + std_id +
                ", std_name='" + std_name + '\'' +
                ", std_address='" + std_address + '\'' +
                ", std_contactNum='" + std_contactNum + '\'' +
                ", std_grade='" + std_grade + '\'' +
                '}';
    }
}
