package co.edu.ucc.proyecto_final_eCommerce.pedido.Estados;

import co.edu.ucc.proyecto_final_eCommerce.pedido.Pedido;
import co.edu.ucc.proyecto_final_eCommerce.pedido.PedidoState;

public class EntregadoState implements PedidoState {
    @Override
    public void avanzar(Pedido pedido) {
        System.out.println("✅ El pedido ya fue entregado. No hay más estados por avanzar.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("⚠️ No se puede cancelar un pedido que ya fue entregado.");
    }

    @Override
    public String obtenerEstado() {
        return "Entregado";
    }
}