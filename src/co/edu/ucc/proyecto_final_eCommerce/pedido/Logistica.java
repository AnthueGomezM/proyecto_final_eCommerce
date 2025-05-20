package co.edu.ucc.proyecto_final_eCommerce.pedido;

public class Logistica {
    public void actualizarEstado(String pedidoId, String estado) {
        System.out.println("[LOGÍSTICA] Pedido " + pedidoId + " ahora está en estado: " + estado.toUpperCase());
    }
}