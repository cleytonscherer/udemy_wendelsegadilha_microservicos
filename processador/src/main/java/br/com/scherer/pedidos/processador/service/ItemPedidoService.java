package br.com.scherer.pedidos.processador.service;

import br.com.scherer.pedidos.processador.entity.ItemPedido;
import br.com.scherer.pedidos.processador.entity.Pedido;
import br.com.scherer.pedidos.processador.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public List<ItemPedido> save(List<ItemPedido> itens) {
        return itemPedidoRepository.saveAll(itens);
    }

    public void save(ItemPedido itemPedido) {
        itemPedidoRepository.save(itemPedido);
    }

    public void updatedItemPedido(List<ItemPedido> itensPedido, Pedido pedido) {
        itensPedido.forEach(item -> {
            item.setPedido(pedido);
            this.save(item);
        });
    }
}
