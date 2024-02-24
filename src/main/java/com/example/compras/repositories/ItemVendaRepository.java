package com.example.compras.repositories;

import com.example.compras.models.ItemVendaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemVendaRepository extends JpaRepository<ItemVendaModel, UUID> {
}
