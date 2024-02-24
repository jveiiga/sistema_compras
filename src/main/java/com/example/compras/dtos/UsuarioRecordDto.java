package com.example.compras.dtos;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRecordDto(@NotBlank String nome, @NotBlank String cpf, @NotBlank String email, @NotBlank String telefone) {
}
