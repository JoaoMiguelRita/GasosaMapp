package com.example.gasosamapp.controllers;

import com.example.gasosamapp.domain.combustiveis.Combustiveis;
import com.example.gasosamapp.domain.combustiveis.CombustiveisRepository;
import com.example.gasosamapp.domain.combustiveis.RequestCombustivelDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity registrarCombustivel(@RequestBody @Valid RequestCombustivelDTO combustivelDTO){
        Combustiveis novoCombustivel = new Combustiveis(combustivelDTO);
        combustiveisRepository.save(novoCombustivel);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarCombustivel(@RequestBody @Valid RequestCombustivelDTO combustivelDTO){
        Optional<Combustiveis> optionalCombustivel = combustiveisRepository.findById(combustivelDTO.id());
        if (optionalCombustivel.isPresent()) {
            Combustiveis combustivel = optionalCombustivel.get();
            combustivel.setNome(combustivelDTO.nome());
            combustivel.setPreco(combustivelDTO.preco());
            return ResponseEntity.ok(combustivel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarCombustivel(@PathVariable String id){
        combustiveisRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
