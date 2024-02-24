package com.example.compras.controllers;

import com.example.compras.dtos.ProdutoRecordDto;
import com.example.compras.models.ProdutoModel;
import com.example.compras.models.UsuarioModel;
import com.example.compras.repositories.ProdutoRepository;
import com.example.compras.repositories.UsuarioRepository;
import com.example.compras.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/produtos")
    public ResponseEntity<ProdutoModel> salvandoProduto(@RequestBody @Valid ProdutoRecordDto produtoRecordDto) {
        ProdutoModel novoProduto = produtoService.salvandoProduto(produtoRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }
}
