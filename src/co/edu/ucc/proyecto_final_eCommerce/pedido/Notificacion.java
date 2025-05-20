package co.edu.ucc.proyecto_final_eCommerce.pedido;

public class Notificacion {
    public void enviarMensaje(String pedidoId, String estado) {
        System.out.println("[NOTIFICACIÓN] Enviado SMS/Email para Pedido " + pedidoId + ": " + estado.toUpperCase());
    }
}