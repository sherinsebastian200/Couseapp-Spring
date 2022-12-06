package com.example.courseapp_backend.controller;

import com.example.courseapp_backend.dao.CourseDao;
import com.example.courseapp_backend.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class Coursecontroller {
    @Autowired
    private CourseDao dao;

    @CrossOrigin(origins = "*")

    @PostMapping("/")
    public String Welcomepage()
    {
        return "Welcome to Course website";
    }

    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")

    public String Addcourse(@RequestBody Courses c){
        System.out.println(c.getCoursetitle().toString());
        System.out.println(c.getDescription().toString());
        System.out.println(c.getVenue().toString());
        System.out.println(c.getDuration().toString());
        System.out.println(c.getDate().toString());
        dao.save(c);


        return "courses added successfully";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List <Courses>viewAll(){
        return (List<Courses>) dao.findAll();
    }



}
