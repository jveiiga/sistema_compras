package com.example.compras.controllers;

import com.example.compras.dtos.VendaRecordDto;
import com.example.compras.models.VendaModel;
import com.example.compras.services.VendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public ResponseEntity<VendaModel> realizarCompra(@RequestBody VendaRecordDto vendaRecordDto) {
        try {
            VendaModel venda = vendaService.realizarCompra(vendaRecordDto);
            return new ResponseEntity<>(venda, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
