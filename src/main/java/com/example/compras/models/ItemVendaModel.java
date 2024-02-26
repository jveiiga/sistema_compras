package com.example.compras.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "ITENS_VENDA")
public class ItemVendaModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idItemVenda;

    @ManyToOne
//    @JoinColumn(name = "idUsuario")
    @JsonManagedReference
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    private ProdutoModel produto;

    @ManyToOne
    @JoinColumn(name = "idVenda")
    private VendaModel venda;

    public UUID getIdItemVenda() {
        return idItemVenda;
    }

    @Column(name = "idUsuario")
    private UUID idUsuario;

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdItemVenda(UUID idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public VendaModel getVenda() {
        return venda;
    }

    public void setVenda(VendaModel venda) {
        this.venda = venda;
    }
}
