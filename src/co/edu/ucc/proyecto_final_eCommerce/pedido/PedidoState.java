package co.edu.ucc.proyecto_final_eCommerce.pedido;

public interface PedidoState {
    void avanzar(Pedido pedido);
    void cancelar(Pedido pedido);
    String obtenerEstado();
}