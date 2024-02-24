package com.example.compras.dtos;

import com.example.compras.models.ProdutoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record VendaRecordDto(@NotNull UUID idUsuario, @NotNull List<UUID> idProdutos, @NotBlank String tipoPagamento, String frete) {

    @Override
    public UUID idUsuario() {
        return idUsuario;
    }

    @Override
    public List<UUID> idProdutos() {
        return idProdutos;
    }
}
