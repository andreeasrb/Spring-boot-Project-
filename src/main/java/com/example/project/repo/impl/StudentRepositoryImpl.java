package com.example.project.repo.impl;

import com.example.project.entity.Student;
import com.example.project.repo.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private List<Student> all;

    public StudentRepositoryImpl() {
        all = new ArrayList<>();

        Student Buget = new Student();
        Buget.setStudentId(4L);
        Buget.setStudentName("Buget");

        Student Taxa = new Student();
        Taxa.setStudentId(5L);
        Taxa.setStudentName("Taxa");

        all.add(Buget);
        all.add(Taxa);
    }

    @Override
    public void add(Student param) {
        all.add(param);
    }

    @Override
    public void delete(Student studentName) {
        all.removeIf(s -> s.getStudentName().equals(studentName));
        //removeIf: argument de tip predicat-
        //elimina elem care se potrivesc cu o anumita conditie sub forma unui predicat
    }

    @Override
    public Student get(String studentName) {
        for(Student student : all) {
            if(student.getStudentName().equals(studentName)){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> getAll() {
        return all;
    }


    public String updateStudenti(Student student){
        //exista in obiecte deja - yes, update, no-create/add
        boolean resourceFound = false;
        for(Student currentStudent: all){
            if(currentStudent.getStudentId() == student.getStudentId()){
                resourceFound = true;
                currentStudent.setStudentId(student.getStudentId());
                currentStudent.setStudentName(student.getStudentName());
            }
        }
        if(!resourceFound){
            all.add(student);
            return "Student Added  Successfully";
        }
        return "Student Update Successfully";
    }
}
