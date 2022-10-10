package com.example.project.service;

import com.example.project.repo.FacultateRepository;
import com.example.project.repo.MaterieRepository;
import com.example.project.repo.StudentRepository;
import com.example.project.repo.impl.FacultateRepositoryImpl;
import com.example.project.repo.impl.MaterieRepositoryImpl;
import com.example.project.repo.impl.StudentRepositoryImpl;

public class AppService {
    private FacultateRepository facultateRepository;
    private MaterieRepository materieRepository;
    private StudentRepository studentRepository;

    public AppService(){
        facultateRepository = new FacultateRepositoryImpl();
        materieRepository = new MaterieRepositoryImpl();
        studentRepository = new StudentRepositoryImpl();
    }

    public FacultateRepository getFacultateRepository() {
        return facultateRepository;
    }

    public MaterieRepository getMaterieRepository() {
        return materieRepository;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }


}
