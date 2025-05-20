package co.edu.ucc.proyecto_final_eCommerce.pedido.Mediator;

import co.edu.ucc.proyecto_final_eCommerce.pedido.Pedido;

public interface PedidoMediator {
    void notificarCambio(Pedido pedido, String nuevoEstado);
}