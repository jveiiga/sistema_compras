package com.example.compras.models;

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
    @JoinColumn(name = "idProduto")
    private ProdutoModel produtos;

    @ManyToOne
    @JoinColumn(name = "idVenda")
    private VendaModel vendas;

    public UUID getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(UUID idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public ProdutoModel getProdutos() {
        return produtos;
    }

    public void setProdutos(ProdutoModel produtos) {
        this.produtos = produtos;
    }

    public VendaModel getVendas() {
        return vendas;
    }

    public void setVendas(VendaModel vendas) {
        this.vendas = vendas;
    }
}
