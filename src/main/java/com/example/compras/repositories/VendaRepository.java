package com.example.compras.repositories;

import com.example.compras.models.VendaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VendaRepository extends JpaRepository<VendaModel, UUID> {
    List<VendaModel> findAllByUsuarioIdUsuario(UUID idUsuario);
}
