package com.example.compras.services;

import com.example.compras.dtos.VendaRecordDto;
import com.example.compras.models.ItemVendaModel;
import com.example.compras.models.ProdutoModel;
import com.example.compras.models.UsuarioModel;
import com.example.compras.models.VendaModel;
import com.example.compras.repositories.ItemVendaRepository;
import com.example.compras.repositories.ProdutoRepository;
import com.example.compras.repositories.UsuarioRepository;
import com.example.compras.repositories.VendaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class VendaService {

    private final ProdutoRepository produtoRepository;
    private final UsuarioRepository usuarioRepository;
    private final VendaRepository vendaRepository;
    private final ItemVendaRepository itemVendaRepository;

    public VendaService(ProdutoRepository produtoRepository, UsuarioRepository usuarioRepository, VendaRepository vendaRepository, ItemVendaRepository itemVendaRepository) {
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
        this.vendaRepository = vendaRepository;
        this.itemVendaRepository = itemVendaRepository;
    }

    public VendaModel realizarCompra(@Valid VendaRecordDto vendaRecordDto) {

        //Obtem usuario no db
        UsuarioModel usuario = usuarioRepository.findById(vendaRecordDto.idUsuario()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        //Obtem id, tipoPagamento e frete através do dto
        UUID usuarioId = vendaRecordDto.idUsuario();
        String tipoPagamento = vendaRecordDto.tipoPagamento();
        String frete = vendaRecordDto.frete();

        List<UUID> produtosIds = vendaRecordDto.idProdutos();
        List<BigDecimal> quantidadePedidos = vendaRecordDto.quantidadesProdutos();

        //Cria venda
        VendaModel venda = new VendaModel();
        venda.setUsuario(usuario);
        venda.setTipoPagamento(tipoPagamento);
        venda.setFrete(frete);
        venda.setIdUsuario(usuarioId);
        venda = vendaRepository.save(venda);

        for (int i = 0; i < produtosIds.size(); i++) {
            UUID produtoId = produtosIds.get(i);
            BigDecimal quantidadePedido = quantidadePedidos.get(i);

            // Obtem produto
            ProdutoModel produto = produtoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            // Valida quantidade em estoque
            if (produto.getQuantidade().compareTo(quantidadePedido) < 0) {
                throw new RuntimeException("Quantidade de produto insuficiente em estoque");
            }

            // Atualiza quantidade em estoque
            produto.setQuantidade(produto.getQuantidade().subtract(quantidadePedido));
            produtoRepository.save(produto);

            // Adiciona venda
            ItemVendaModel itemVenda = new ItemVendaModel();
            itemVenda.setProduto(produto);
            itemVenda.setVenda(venda);
            itemVenda.setIdUsuario(usuarioId);

            itemVendaRepository.save(itemVenda);
        }

        return venda;
    }
}
