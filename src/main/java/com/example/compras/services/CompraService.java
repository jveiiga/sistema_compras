package com.example.compras.services;

import com.example.compras.dtos.VendaRecordDto;
import com.example.compras.models.ItemVendaModel;
import com.example.compras.models.ProdutoModel;
import com.example.compras.models.UsuarioModel;
import com.example.compras.models.VendaModel;
import com.example.compras.repositories.ProdutoRepository;
import com.example.compras.repositories.UsuarioRepository;
import com.example.compras.repositories.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/compra")
public class CompraService {

    private final UsuarioRepository usuarioRepository;
    private final ProdutoRepository produtoRepository;
    private final VendaRepository vendaRepository;

    @Autowired
    public CompraService(UsuarioRepository usuarioRepository, ProdutoRepository produtoRepository, VendaRepository vendaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.produtoRepository = produtoRepository;
        this.vendaRepository = vendaRepository;
    }

    private List<ItemVendaModel> criarItensVenda(List<UUID> idProdutos, VendaModel venda) {
        List<ItemVendaModel> itensVenda = new ArrayList<>();

        for (UUID idProduto : idProdutos) {
            // Buscar o produto no db com base no ID
            Optional<ProdutoModel> produtoOptional = produtoRepository.findById(idProduto);

            produtoOptional.ifPresent(produto -> {
                ItemVendaModel itemVenda = new ItemVendaModel();
                itemVenda.setProdutos(produto);
                itemVenda.setVendas(venda);
                // Configurar outros atributos do item de venda, se necessário
                itensVenda.add(itemVenda);
            });
        }

        return itensVenda;
    }

    @Transactional
    public VendaRecordDto realizarCompra(VendaRecordDto vendaRecordDto) {
        // Busca um usuário no db com base no id.
        Optional<UsuarioModel> usuarioO = usuarioRepository.findById(vendaRecordDto.idUsuario());
        AtomicReference<VendaModel> novaVendaRef = new AtomicReference<>();
        // Verifica se o usuário foi encontrado.
        usuarioO.ifPresent(usuario -> {

            // Itera sobre todas as vendas do usuário
            for (VendaModel venda : usuario.getVendas()) {
                List<ProdutoModel> produtos = produtoRepository.findAllById(venda.getIdProdutos());

                // Verifica se a lista de produtos não está vazia.
                if (!produtos.isEmpty()) {
                    // Cria uma nova venda para representar a compra
                    VendaModel novaVenda = new VendaModel();
                    novaVenda.setUsuario(usuario);
                    novaVenda.setTipoPagamento("Cartão de Crédito"); // Substitua pela lógica adequada
                    novaVenda.setFrete("Entrega Expressa"); // Substitua pela lógica adequada
                    novaVenda.setItensVenda(criarItensVenda(vendaRecordDto.idProdutos(), novaVenda)); // Método para criar e associar itens de venda

                    // Persiste os dados no db
                    vendaRepository.save(novaVenda);

                    // Adiciona a nova venda à lista de vendas do usuário
                    usuario.getVendas().add(novaVenda);
                    usuarioRepository.save(usuario);
                }
            }

        });
        // Retorna uma representação da venda (por exemplo, um DTO) após a compra ser realizada.
        return criarVendaRecordDto(novaVendaRef.get());
    }

    private VendaRecordDto criarVendaRecordDto(VendaModel vendaModel) {
        // Lógica para converter um objeto VendaModel em um DTO (VendaRecordDto).
        return new VendaRecordDto(
                vendaModel.getUsuario().getIdUsuario(),
                vendaModel.getIdProdutos(),
                vendaModel.getTipoPagamento(),
                vendaModel.getFrete()
        );
    }
}
