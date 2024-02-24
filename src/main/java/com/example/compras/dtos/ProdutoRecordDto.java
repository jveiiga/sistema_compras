package com.example.compras.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoRecordDto(@NotNull UUID idUsuario, @NotBlank String categoria, @NotBlank String titulo, @NotBlank String descricao, @NotNull BigDecimal preco, @NotNull BigDecimal quantidade, @NotBlank String cep) {
}
