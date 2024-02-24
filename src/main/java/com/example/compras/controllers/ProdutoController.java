package com.example.compras.controllers;

import com.example.compras.dtos.ProdutoRecordDto;
import com.example.compras.models.ProdutoModel;
import com.example.compras.models.UsuarioModel;
import com.example.compras.repositories.ProdutoRepository;
import com.example.compras.repositories.UsuarioRepository;
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
    private ProdutoRepository produtoRepository;

    @PostMapping("/produtos")
    public ResponseEntity<ProdutoModel> salvandoProduto(@RequestBody @Valid ProdutoRecordDto produtoRecordDto) {
        ProdutoModel produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoRecordDto, produtoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produtoModel));
    }
}
