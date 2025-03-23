package com.example.gasosamapp.controllers;

import com.example.gasosamapp.domain.combustiveis.Combustiveis;
import com.example.gasosamapp.domain.combustiveis.CombustiveisRepository;
import com.example.gasosamapp.domain.combustiveis.RequestCombustivelDTO;
import jakarta.persistence.EntityNotFoundException;
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
        var todosCombustiveis = combustiveisRepository.findAllByAtivoTrue();
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
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarCombustivel(@PathVariable String id){
        Optional<Combustiveis> optionalCombustivel = combustiveisRepository.findById(id);
        if (optionalCombustivel.isPresent()) {
            Combustiveis combustivel = optionalCombustivel.get();
            combustivel.setAtivo(false);
            return ResponseEntity.ok(combustivel);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
