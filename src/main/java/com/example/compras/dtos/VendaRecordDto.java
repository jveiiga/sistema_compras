package com.example.compras.dtos;

import com.example.compras.models.ProdutoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record VendaRecordDto(
        @NotNull UUID idUsuario,
        @NotNull List<UUID> idProdutos,
        @NotNull List<BigDecimal> quantidadesProdutos,
        @NotBlank String tipoPagamento,
        String frete
) {
}
