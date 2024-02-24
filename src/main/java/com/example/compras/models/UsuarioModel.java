package com.example.compras.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "USUARIOS")
public class UsuarioModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUsuario;

    @Size(max = 30)
    @NotNull
    private String nome;

    @Size(max = 11)
    @NotNull
    @Column(unique = true)
    private String cpf;

    @NotNull
    @Column(unique = true)
    private String email;

    @Size(max = 11)
    @NotNull
    @Column(unique = true)
    private String telefone;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuarios")
    private List<ProdutoModel> produtos;

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<ProdutoModel> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoModel> produtos) {
        this.produtos = produtos;
    }
}
