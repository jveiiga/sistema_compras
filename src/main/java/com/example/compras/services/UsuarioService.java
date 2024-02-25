package com.example.compras.services;

import com.example.compras.dtos.UsuarioRecordDto;
import com.example.compras.models.UsuarioModel;
import com.example.compras.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel salvandoUsuario(@Valid UsuarioRecordDto usuarioRecordDto) {
        UsuarioModel novoUsuario = new UsuarioModel();
        BeanUtils.copyProperties(usuarioRecordDto, novoUsuario);
        return usuarioRepository.save(novoUsuario);
    }

    public List<UsuarioModel> listandoTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> listandoUsuario(UUID id) {
        return usuarioRepository.findById(id);
    }

}
