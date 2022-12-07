package com.example.courseapp_backend.controller;

import com.example.courseapp_backend.dao.CourseDao;
import com.example.courseapp_backend.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")



    public Map<String,String> AddCourses(@RequestBody Courses c ) {
        System.out.println(c.getCoursetitle().toString());
        System.out.println(c.getDescription().toString());
        System.out.println(c.getVenue().toString());
        System.out.println(c.getDuration().toString());
        System.out.println(c.getDate().toString());
        dao.save(c);

        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;





    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Courses> SearchCourses(@RequestBody Courses c){
        String coursetitle = String.valueOf(c.getCoursetitle());
        System.out.println(coursetitle);
        return (List<Courses>) dao.SearchCourses(c.getCoursetitle());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List <Courses>viewAll(){
        return (List<Courses>) dao.findAll();
    }



}
