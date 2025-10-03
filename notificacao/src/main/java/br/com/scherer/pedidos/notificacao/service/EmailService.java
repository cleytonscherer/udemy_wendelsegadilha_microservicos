package br.com.scherer.pedidos.notificacao.service;

import br.com.scherer.pedidos.notificacao.entity.Pedido;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarEmail(Pedido pedido) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("cleytonscherer@gmail.com");
//        simpleMailMessage.setTo(pedido.getEmailNotificacao());
        simpleMailMessage.setTo("cleytonscherer@gmail.com");
        simpleMailMessage.setSubject("Pedido de Compra " + pedido.getId());
        simpleMailMessage.setText(this.gerarMensagem(pedido));
        mailSender.send(simpleMailMessage);
    }

    private String gerarMensagem(Pedido pedido) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        String pedidoId = pedido.getId().toString();
        String cliente = pedido.getCliente();
        String valor = String.valueOf(pedido.getValorTotal());
        String status = pedido.getStatusPedido().name();
//        String dataPedido = simpleDateFormat.format(pedido.getDataHora());
        String dataPedido = pedido.getDataHora().toString();

        String mensagem = String.format("Olá %s, " +
                        "\n\nSeu pedido de número %s com o valor de R$ %s foi recebido com sucesso em %s." +
                        "\n\nSituação do pedido %s",
                        cliente, pedidoId, valor, dataPedido, status);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(mensagem);
        System.out.println("-----------------------------------------------------------------------------------------");

        return mensagem;
    }
}
