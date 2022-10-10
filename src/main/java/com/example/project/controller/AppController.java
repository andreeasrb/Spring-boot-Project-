package com.example.project.controller;


import com.example.project.entity.Facultate;
import com.example.project.entity.Materie;
import com.example.project.entity.Student;
import com.example.project.repo.impl.FacultateRepositoryImpl;
import com.example.project.repo.impl.MaterieRepositoryImpl;
import com.example.project.repo.impl.StudentRepositoryImpl;
import com.example.project.service.AppService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/app/")
public class AppController {
    private final AppService appService;
    private final StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
    private final MaterieRepositoryImpl materieRepository = new MaterieRepositoryImpl();
    private final FacultateRepositoryImpl facultateRepository = new FacultateRepositoryImpl();

    public AppController(){
        appService = new AppService();
    }


    @RequestMapping(method = RequestMethod.GET, path = "echo/{name}")
    public String echo(@PathVariable String name){
        return name;
    }


    //GET Student
    @RequestMapping(method = RequestMethod.GET, path = "echo/student/{studentName}")
    public Student echoStudentGet(@PathVariable String studentName){
        return studentRepository.get(studentName);
    }

    //GET ALL Studenti
    @RequestMapping(method = RequestMethod.GET, path = "/Studenti")
    public List<Student> getAllStudenti(){
        return studentRepository.getAll();
    }

    //GET Materie
    @RequestMapping(method = RequestMethod.GET, path = "echo/materie/{materieName}")
    public Materie echoMaterieGet(@PathVariable String materieName){
        return materieRepository.get(materieName);
    }

    //GET ALL Materii
    @RequestMapping(method = RequestMethod.GET, path="/Materii")
    public List<Materie> getAllMaterii(){
        return materieRepository.getAll();
    }

    //GET Facultate
    @RequestMapping(method = RequestMethod.GET, path = "echo/facultate/{facultateName}")
    public Facultate echoFacultateGet(@PathVariable String facultateName){
        return facultateRepository.get(facultateName);
    }

    //GET ALL Facultati
    @RequestMapping(method = RequestMethod.GET, path = "/Facultati")
    public List<Facultate> getAllFacultati(){
        return facultateRepository.getAll();
    }



    //PUT STUDENT
    @PutMapping("/Studenti")
    public String updateStudenti(@RequestBody Student student){
        return studentRepository.updateStudenti(student);
    }

    //PUT FACULTATE
    @PutMapping("/Facultati")
    public String updateFacultate(@RequestBody Facultate facultate){
        return facultateRepository.updateFacultate(facultate);
    }

    //PUT MATERIE
    @PutMapping("/Materii")
    public String updateMaterie(@RequestBody Materie materie){
        return materieRepository.updateMaterie(materie);
    }


    //POST STUDENT
    @PostMapping("/Studenti")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addStudenti(@RequestBody Student student){
        studentRepository.add(student);
    }

    //POST FACULTATE
    @PostMapping("/Facultati")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addFacultate(@RequestBody Facultate facultate){
        facultateRepository.add(facultate);
    }

    //POST MATERIE
    @PostMapping("/Materii")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addMaterie(@RequestBody Materie materie){
        materieRepository.add(materie);
    }


    //DELETE STUDENT
    @DeleteMapping("/Studenti")
    public void deleteStudenti(@RequestBody Student studentName){
        studentRepository.delete(studentName);
    }

    //DELETE FACULTATE
    @DeleteMapping("/Facultati")
    public void deleteFacultate(@RequestBody Facultate facultate){
        facultateRepository.delete(facultate);
    }

    //DELETE FACULTATE
    @DeleteMapping("/Materii")
    public void deleteMaterie(@RequestBody Materie materie){
        materieRepository.delete(materie);
    }


}



