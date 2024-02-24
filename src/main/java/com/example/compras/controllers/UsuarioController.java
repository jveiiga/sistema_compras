package com.example.compras.controllers;

import com.example.compras.dtos.UsuarioRecordDto;
import com.example.compras.models.UsuarioModel;
import com.example.compras.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioModel> salvandoUsuario(@RequestBody @Valid UsuarioRecordDto usuarioRecordDto){
        UsuarioModel usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioRecordDto, usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuarioModel));
    }
}
