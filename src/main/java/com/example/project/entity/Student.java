package com.example.project.entity;


import java.util.List;

public class Student {
    private Long studentId;
    private String studentName;
    private String studentParola;

    private List<Long> materiiStud;

    public List<Long> getMateriiStud() {
        return materiiStud;
    }

    public void setMateriiStud(List<Long> materiiStud) {
        this.materiiStud = materiiStud;
    }

    public Student(){}

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentParola() {
        return studentParola;
    }

    public void setStudentParola(String studentParola) {
        this.studentParola = studentParola;
    }

}
