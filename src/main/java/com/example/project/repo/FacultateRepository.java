package com.example.project.repo;

import com.example.project.entity.Facultate;

import java.util.List;

public interface FacultateRepository {
    void add(Facultate param);
    void delete(Facultate facultate);

    Facultate get(String facultateName);

    List<Facultate> getAll();

    String updateFacultate(Facultate facultate);

    List<String> extract();
}
