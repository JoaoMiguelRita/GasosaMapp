package com.example.gasosamapp.controllers;

import com.example.gasosamapp.domain.combustiveis.Combustiveis;
import com.example.gasosamapp.domain.combustiveis.CombustiveisRepository;
import com.example.gasosamapp.domain.combustiveis.RequestCombustivelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/combustiveis")
public class CombustiveisController {

    @Autowired
    private CombustiveisRepository combustiveisRepository;

    @GetMapping
    public ResponseEntity getTodosCombustiveis(){
        var todosCombustiveis = combustiveisRepository.findAll();
        return ResponseEntity.ok(todosCombustiveis);
    }

    @PostMapping
    public ResponseEntity registrarCombustivel(@RequestBody RequestCombustivelDTO combustivelDTO){
        Combustiveis novoCombustivel = new Combustiveis(combustivelDTO);
        combustiveisRepository.save(novoCombustivel);
        return ResponseEntity.ok().build();
    }
}
