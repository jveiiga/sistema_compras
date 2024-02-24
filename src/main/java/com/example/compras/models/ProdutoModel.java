package com.example.compras.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "PRODUTOS")
public class ProdutoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduto;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioModel usuario;

    @Transient
    private UUID idUsuario;

    @Size(max = 30)
    @NotNull
    private String categoria;

    @NotNull
    private String titulo;

    @NotNull
    private String descricao;

    @NotNull
    private BigDecimal preco;

    @NotNull
    private BigDecimal quantidade;

    @NotNull
    @Size(max = 8)
    private String cep;

    @OneToMany(mappedBy = "produtos", fetch = FetchType.LAZY)
    private List<ItemVendaModel> itensVenda;

    public UUID getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(UUID idProduto) {
        this.idProduto = idProduto;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<ItemVendaModel> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVendaModel> itensVenda) {
        this.itensVenda = itensVenda;
    }
}
