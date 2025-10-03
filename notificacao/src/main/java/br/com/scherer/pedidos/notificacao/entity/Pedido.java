package br.com.scherer.pedidos.notificacao.entity;

import br.com.scherer.pedidos.notificacao.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    private UUID    id = UUID.randomUUID();

    private String  cliente;

    private List<ItemPedido> itens = new ArrayList<>();

    private Double  valorTotal;

    private String  emailNotificacao;

    private StatusPedido statusPedido = StatusPedido.EM_PROCESSAMENTO;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime   dataHora = LocalDateTime.now();


}
