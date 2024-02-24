package com.example.compras.controllers;

import com.example.compras.dtos.VendaRecordDto;
import com.example.compras.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<VendaRecordDto> realizarCompra(@RequestBody VendaRecordDto vendaRecordDto) {
        VendaRecordDto venda = compraService.realizarCompra(vendaRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
    }
}
