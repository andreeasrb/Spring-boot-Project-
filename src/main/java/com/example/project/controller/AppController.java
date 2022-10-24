package com.example.project.controller;

import com.example.project.entity.Facultate;
import com.example.project.entity.Materie;
import com.example.project.entity.Student;
import com.example.project.repo.StudentRepository;
import com.example.project.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "/app/")
public class AppController {
    //injectare
    @Autowired
    private  AppService appService;

    @RequestMapping(method = RequestMethod.GET, path = "echo/{name}")
    public String echo(@PathVariable String name){
        return name;
    }


    //GET Student
    @RequestMapping(method = RequestMethod.GET, path = "echo/student/{studentName}")
    public Student echoStudentGet(@PathVariable String studentName){
        return appService.getStudentRepository().get(studentName);
    }

    //GET ALL Studenti
    @RequestMapping(method = RequestMethod.GET, path = "/Studenti")
    public List<Student> getAllStudenti(){
        return appService.getStudentRepository().getAll();
    }

    //GET Materie
    @RequestMapping(method = RequestMethod.GET, path = "echo/materie/{materieName}")
    public Materie echoMaterieGet(@PathVariable String materieName){
        return appService.getMaterieRepository().get(materieName);
    }


    //GET ALL Materii
    @RequestMapping(method = RequestMethod.GET, path="/Materii")
    public List<Materie> getAllMaterii(){
        return appService.getMaterieRepository().getAll();
    }

    //GET Facultate
    @RequestMapping(method = RequestMethod.GET, path = "echo/facultate/{facultateName}")
    public Facultate echoFacultateGet(@PathVariable String facultateName){
        return appService.getFacultateRepository().get(facultateName);
    }

    //GET ALL Facultati
    @RequestMapping(method = RequestMethod.GET, path = "/Facultati")
    public List<Facultate> getAllFacultati(){
        return appService.getFacultateRepository().getAll();
    }


    //PUT STUDENT
    @PutMapping("/Studenti")
    public String updateStudenti(@RequestBody Student student){
        return appService.getStudentRepository().updateStudenti(student);
    }

    //PUT FACULTATE
    @PutMapping("/Facultati")
    public String updateFacultate(@RequestBody Facultate facultate){
        return appService.getFacultateRepository().updateFacultate(facultate);
    }

    //PUT MATERIE
    @PutMapping("/Materii")
    public String updateMaterie(@RequestBody Materie materie){
        return appService.getMaterieRepository().updateMaterie(materie);
    }


    //POST STUDENT
    @PostMapping("/Studenti")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addStudenti(@RequestBody Student student){
        appService.getStudentRepository().add(student);
    }

    //POST FACULTATE
    @PostMapping("/Facultati")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addFacultate(@RequestBody Facultate facultate){
        appService.getFacultateRepository().add(facultate);
    }

    //POST MATERIE
    @PostMapping("/Materii")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addMaterie(@RequestBody Materie materie){
        appService.getMaterieRepository().add(materie);
    }


    //DELETE STUDENT
    @DeleteMapping("/Studenti")
    public void deleteStudenti(@RequestBody Student studentName){
        appService.getStudentRepository().delete(studentName);
    }

    //DELETE FACULTATE
    @DeleteMapping("/Facultati")
    public void deleteFacultate(@RequestBody Facultate facultate){
        appService.getFacultateRepository().delete(facultate);
    }

    //DELETE FACULTATE
    @DeleteMapping("/Materii")
    public void deleteMaterie(@RequestBody Materie materie){
        appService.getMaterieRepository().delete(materie);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/Filters")
    public List<String> filters(){
        return appService.getFacultateRepository().extract();
    }


    @PostMapping("/users/login")
    public ResponseEntity <?> login(@RequestBody Map<String, Object> requestParams){
        String username = requestParams.get("username").toString();
        String password = requestParams.get("password").toString();
        Student stud = appService.getStudentRepository().get(username);
        if(stud != null && stud.getStudentParola().equals(password)) {
            return new ResponseEntity<>("Success", HttpStatus.FOUND);
        }
        return new ResponseEntity<>("Error", HttpStatus.OK);
    }

   @GetMapping("/materiiStud/{studentName}")
    public ResponseEntity<?> getMaterie(@PathVariable String studentName){
      StudentRepository studRepo = appService.getStudentRepository();
      Student stud = studRepo.get(studentName);
      final List <Long> materiiIds = stud.getMateriiStud();
      List <String> attending = appService.getMaterieRepository().getAll().stream()
              .filter(materie -> materiiIds.contains(materie.getMaterieId()))
              .map(Materie::getMaterieName)
              .collect(Collectors.toList());
      return new ResponseEntity<>(attending, HttpStatus.OK);
    }


}



