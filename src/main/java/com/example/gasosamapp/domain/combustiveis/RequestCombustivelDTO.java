package com.example.gasosamapp.domain.combustiveis;

import jakarta.validation.constraints.NotBlank;
import org.jetbrains.annotations.NotNull;

public record RequestCombustivelDTO(String id, @NotBlank String nome, @NotNull Double preco) {
}
