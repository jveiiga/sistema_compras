package com.example.compras.services;

import com.example.compras.dtos.ProdutoRecordDto;
import com.example.compras.models.ProdutoModel;
import com.example.compras.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoModel salvandoProduto(@Valid ProdutoRecordDto produtoRecordDto) {
        ProdutoModel novoProduto = new ProdutoModel();
        BeanUtils.copyProperties(produtoRecordDto, novoProduto);
        return produtoRepository.save(novoProduto);
    }

    public List<ProdutoModel> listandoTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> listandoProduto(UUID id) {
        return produtoRepository.findById(id);
    }
}
