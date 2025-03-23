package com.example.gasosamapp.domain.combustiveis;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CombustiveisRepository extends JpaRepository<Combustiveis, String> {
    List<Combustiveis> findAllByAtivoTrue();
}
