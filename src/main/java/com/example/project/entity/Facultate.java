package com.example.project.entity;

public class Facultate {
    //instantierea variabilelor
    private Long facultateId; //private sa fie accesate doar aici
    private String facultateName;

    //Constructor
    public Facultate() {
    }

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


}