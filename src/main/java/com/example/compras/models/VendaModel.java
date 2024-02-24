package com.example.compras.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "VENDAS")
public class VendaModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idVenda;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioModel usuario;

    @NotNull
    private String tipoPagamento;

    @NotNull
    private String frete;

    @OneToMany(mappedBy = "venda")
    private List<ItemVendaModel> itensVenda;

    @ElementCollection
    private List<UUID> idProdutos;

    public UUID getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(UUID idVenda) {
        this.idVenda = idVenda;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getFrete() {
        return frete;
    }

    public void setFrete(String frete) {
        this.frete = frete;
    }

    public List<ItemVendaModel> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVendaModel> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public List<UUID> getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(List<UUID> idProdutos) {
        this.idProdutos = idProdutos;
    }
}
