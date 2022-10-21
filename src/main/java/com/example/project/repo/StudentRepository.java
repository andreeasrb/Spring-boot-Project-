package com.example.project.repo;

import com.example.project.entity.Student;

import java.util.List;

public interface StudentRepository {

    void add (Student param);
    void delete (Student stud);

    Student get(String studentName);
    List<Student> getAll();

    String updateStudenti(Student student);
}
