package br.com.scherer.pedidos.api.controller;

import br.com.scherer.pedidos.api.entity.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/pedidos")
public class Pedidocontroller {

    private final Logger logger = LoggerFactory.getLogger(Pedidocontroller.class);

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        logger.info("Pedido recebido: {}", pedido.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }
}
