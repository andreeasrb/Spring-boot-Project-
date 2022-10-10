package com.example.project.repo.impl;

import com.example.project.entity.Materie;
import com.example.project.entity.Student;
import com.example.project.repo.MaterieRepository;

import java.util.ArrayList;
import java.util.List;

public class MaterieRepositoryImpl implements MaterieRepository {

    private List<Materie> all;

    public MaterieRepositoryImpl(){
        all = new ArrayList<>();

        Materie Mate = new Materie();
        Mate.setMaterieId(3L);
        Mate.setMaterieName("Matematica");

        Materie Rom = new Materie();
        Rom.setMaterieId(1L);
        Rom.setMaterieName("Romana");

        all.add(Mate);
        all.add(Rom);
    }

    @Override
    public void add(Materie param) {
        all.add(param);
    }

    @Override
    public void delete(Materie materie) {
        all.removeIf(s -> s.getMaterieName().equals(materie));
        //removeIf: argument de tip predicat-
        //elimina elem care se potrivesc cu o anumita conditie sub forma unui predicat
    }

    @Override
    public Materie get(String materieName) {
        for(Materie materie : all){
            if(materie.getMaterieName().equals(materieName)){
                return materie;
            }
        }
        return null;
    }

    @Override
    public List<Materie> getAll() {
        return all;
    }

    public String updateMaterie(Materie materie){
        //exista in obiecte deja - yes, update, no-create/add
        boolean resourceFound = false;
        for(Materie currentMaterie: all){
            if(currentMaterie.getMaterieId() == materie.getMaterieId()){
                resourceFound = true;
                currentMaterie.setMaterieId(materie.getMaterieId());
                currentMaterie.setMaterieName(materie.getMaterieName());
            }
        }
        if(!resourceFound){
            all.add(materie);
            return "Materie Added  Successfully";
        }
        return "Materie Update Successfully";
    }
}
