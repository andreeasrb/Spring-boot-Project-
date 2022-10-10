package com.example.project.entity;

public class Materie {
    private Long materieId;
    private String materieName;

    public Materie() {
    }

    public void setMaterieId(Long materieId) {
        this.materieId = materieId;
    }

    public Long getMaterieId() {
        return materieId;
    }

    public void setMaterieName(String materieName) {
        this.materieName = materieName;
    }

    public String getMaterieName() {
        return materieName;
    }
}
