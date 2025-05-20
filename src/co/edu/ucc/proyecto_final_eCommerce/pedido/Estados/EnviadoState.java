package co.edu.ucc.proyecto_final_eCommerce.pedido.Estados;

import co.edu.ucc.proyecto_final_eCommerce.pedido.Pedido;
import co.edu.ucc.proyecto_final_eCommerce.pedido.PedidoState;

public class EnviadoState implements PedidoState {
    @Override
    public void avanzar(Pedido pedido) {
        pedido.setEstado(new EntregadoState());
        pedido.getMediator().notificarCambio(pedido, "entregado");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("⚠️ No se puede cancelar un pedido que ya fue enviado.");
    }

    @Override
    public String obtenerEstado() {
        return "Enviado";
    }
}