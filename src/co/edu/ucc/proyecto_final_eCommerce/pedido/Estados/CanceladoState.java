package co.edu.ucc.proyecto_final_eCommerce.pedido.Estados;

import co.edu.ucc.proyecto_final_eCommerce.pedido.Pedido;
import co.edu.ucc.proyecto_final_eCommerce.pedido.PedidoState;

public class CanceladoState implements PedidoState {
    @Override
    public void avanzar(Pedido pedido) {
        pedido.setEstado(new EnviadoState());
        System.out.println("⚠️ El pedido fue cancelado. No se puede avanzar a otro estado.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("⚠️ El pedido ya está cancelado.");
    }

    @Override
    public String obtenerEstado() {
        return "Cancelado";
    }
}