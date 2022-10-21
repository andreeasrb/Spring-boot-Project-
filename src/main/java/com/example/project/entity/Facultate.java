package com.example.project.entity;

import java.util.Objects;

public class Facultate {
    //instantierea variabilelor
    private Long facultateId; //private sa fie accesate doar aici
    private String facultateName;

    //Constructor
    public Facultate() {
    }
    
    //Getter si setter pentru a putea fi folosite si in alta parte variabilele private

    public void setFacultateId(Long facultateId) {
        this.facultateId = facultateId;
    }

    public Long getFacultateId() {
        return facultateId;
    }

    public void setFacultateName(String facultateName) {
        this.facultateName = facultateName;
    }

    public String getFacultateName() {
        return facultateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facultate facultate = (Facultate) o;
        return Objects.equals(facultateId, facultate.facultateId) && Objects.equals(facultateName, facultate.facultateName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultateId, facultateName);
    }
}