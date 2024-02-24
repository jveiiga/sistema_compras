package com.example.compras.repositories;

import com.example.compras.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID> {
}
