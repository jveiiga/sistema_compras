package com.example.compras.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ItemVendaRecordDto(@NotNull UUID idUsuario, @NotNull UUID idProduto, @NotNull UUID IdVenda) {
}
