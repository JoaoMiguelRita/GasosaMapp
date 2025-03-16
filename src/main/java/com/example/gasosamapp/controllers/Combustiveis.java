package com.example.gasosamapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/combustiveis")
public class Combustiveis {


    @GetMapping
    public ResponseEntity getTodosCombustiveis(){
        return ResponseEntity.ok("Deu ok");
    }
}
