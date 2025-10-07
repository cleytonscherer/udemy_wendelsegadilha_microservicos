package br.com.scherer.pedidos.processador.service;

import br.com.scherer.pedidos.processador.entity.ItemPedido;
import br.com.scherer.pedidos.processador.entity.Pedido;
import br.com.scherer.pedidos.processador.repository.ItemPedidoRepository;
import br.com.scherer.pedidos.processador.repository.PedidoRepository;
import br.com.scherer.pedidos.processador.repository.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(PedidoService.class);

    private final PedidoRepository  pedidoRepository;
    private final ProdutoService    produtoService;
    private final ItemPedidoService itemPedidoService;

    public PedidoService(PedidoRepository pedidoRepository,
                         ProdutoService produtoService,
                         ItemPedidoService itemPedidoService
    ) {
        this.pedidoRepository = pedidoRepository;
        this.produtoService = produtoService;
        this.itemPedidoService = itemPedidoService;
    }

//    @Transactional
    public void save(Pedido pedido) {

        // salvar os produtos
        produtoService.save(pedido.getItens());

        // salvar os itens do pedido
        List<ItemPedido> itensPedido = itemPedidoService.save(pedido.getItens());

        // salvar o pedido
        pedidoRepository.save(pedido);

        // atualiar o item pedido definindo o pedido do item
        itemPedidoService.updatedItemPedido(itensPedido, pedido);

        logger.info("Pedido salvo: {} ", pedido.toString());
    }

}
