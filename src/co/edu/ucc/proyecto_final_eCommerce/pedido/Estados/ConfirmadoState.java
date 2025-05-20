package co.edu.ucc.proyecto_final_eCommerce.pedido.Estados;

import co.edu.ucc.proyecto_final_eCommerce.pedido.Pedido;
import co.edu.ucc.proyecto_final_eCommerce.pedido.PedidoState;

public class ConfirmadoState implements PedidoState {
    @Override
    public void avanzar(Pedido pedido) {
        pedido.setEstado(new EnviadoState());
        pedido.getMediator().notificarCambio(pedido, "enviado");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new CanceladoState());
        pedido.getMediator().notificarCambio(pedido, "cancelado");
    }

    @Override
    public String obtenerEstado() {
        return "Confirmado";
    }
}