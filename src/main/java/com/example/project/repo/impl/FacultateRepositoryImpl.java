package com.example.project.repo.impl;

import com.example.project.entity.Facultate;
import com.example.project.entity.Facultate;
import com.example.project.repo.FacultateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FacultateRepositoryImpl implements FacultateRepository {

    private List<Facultate> all;

    public FacultateRepositoryImpl(){
        all = new ArrayList<>();

        Facultate Poli = new Facultate();
        Poli.setFacultateId(1L);
        Poli.setFacultateName("Univ Poli");

        Facultate UBB = new Facultate();
        UBB.setFacultateName("Univ Babes");
        UBB.setFacultateId(2L);

        all.add(Poli);
        all.add(UBB);

    }


    @Override
    public void add(Facultate param) {
        all.add(param);
    }

    @Override
    public void delete(Facultate facultate) {
        all.removeIf(f -> f.getFacultateName().equals(facultate.getFacultateName()));
    }

    @Override
    public Facultate get(String facultateName) {
        for(Facultate facultate : all)
        {
            if(facultate.getFacultateName().equals(facultateName))
            {
                return facultate;
            }
        }
        return null;
    }

    @Override
    public List<Facultate> getAll() {
        return all;
    }

    public String updateFacultate(Facultate facultate){
        //exista in obiecte deja - yes, update, no-create/add
        boolean resourceFound = false;
        for(Facultate currentFacultate: all){
            if(Objects.equals(currentFacultate.getFacultateId(), facultate.getFacultateId())){
                resourceFound = true;
                currentFacultate.setFacultateId(facultate.getFacultateId());
                currentFacultate.setFacultateName(facultate.getFacultateName());
            }
        }
        if(!resourceFound){
            all.add(facultate);
            return "Facultate Added  Successfully";
        }
        return "Facultate Update Successfully";
    }

    public List<String> extract(){
         return all.stream() //convert list to stream
                .map(Facultate::getFacultateName)
                .filter(element -> element.contains("a"))
                .collect(Collectors.toList());
    }


}


