package com.example.compras.controllers;

import com.example.compras.dtos.UsuarioRecordDto;
import com.example.compras.models.UsuarioModel;
import com.example.compras.repositories.UsuarioRepository;
import com.example.compras.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;


    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioModel> salvandoUsuario(@RequestBody @Valid UsuarioRecordDto usuarioRecordDto) {
        UsuarioModel novoUsuario = usuarioService.salvandoUsuario(usuarioRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioModel>> listandoTodosUsuarios() {
        List<UsuarioModel> usuarios = usuarioService.listandoTodosUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Object> listandoUsuario(@PathVariable(value = "id") UUID id) {
        Optional<UsuarioModel> usuarioO = usuarioService.listandoUsuario(id);
        if (usuarioO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioO.get());
    }
}
