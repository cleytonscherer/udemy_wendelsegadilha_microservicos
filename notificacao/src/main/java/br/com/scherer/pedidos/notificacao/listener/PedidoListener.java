package br.com.scherer.pedidos.notificacao.listener;

import br.com.scherer.pedidos.notificacao.entity.Pedido;
import br.com.scherer.pedidos.notificacao.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);

    private final EmailService emailService;

    public PedidoListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
    public void enviarNotificacao(Pedido pedido) {
        logger.info("Notificação gerada: {}", pedido.toString());
        emailService.enviarEmail(pedido);
    }
}
