package com.example.compras.controllers;

import com.example.compras.dtos.VendaRecordDto;
import com.example.compras.models.VendaModel;
import com.example.compras.services.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public ResponseEntity<VendaModel> realizarCompra(@RequestBody @Valid VendaRecordDto vendaRecordDto) {
            VendaModel novaVenda = vendaService.realizarCompra(vendaRecordDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaVenda);
    }
}
