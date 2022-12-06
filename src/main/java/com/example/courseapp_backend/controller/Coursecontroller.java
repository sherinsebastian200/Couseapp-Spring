package com.example.courseapp_backend.controller;

import com.example.courseapp_backend.model.Courses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Coursecontroller {

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

        return "courses added successfully";
    }


}
