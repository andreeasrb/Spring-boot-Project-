package com.example.project.repo;

import com.example.project.entity.Materie;

import java.util.List;

public interface MaterieRepository {
    void add(Materie param);
    void delete(Materie materie);

    Materie get(String materieName);

    List<Materie> getAll();

    String updateMaterie(Materie materie);
}
