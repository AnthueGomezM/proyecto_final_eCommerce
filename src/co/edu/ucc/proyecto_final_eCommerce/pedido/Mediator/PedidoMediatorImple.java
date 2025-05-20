package co.edu.ucc.proyecto_final_eCommerce.pedido.Mediator;

import co.edu.ucc.proyecto_final_eCommerce.pedido.Logistica;
import co.edu.ucc.proyecto_final_eCommerce.pedido.Notificacion;
import co.edu.ucc.proyecto_final_eCommerce.pedido.Pedido;

public class PedidoMediatorImple implements PedidoMediator {
    private Logistica logistica;
    private Notificacion notificacion;

    public PedidoMediatorImple(Logistica logistica, Notificacion notificacion) {
        this.logistica = logistica;
        this.notificacion = notificacion;
    }

    @Override
    public void notificarCambio(Pedido pedido, String nuevoEstado) {
        logistica.actualizarEstado(pedido.getId(), nuevoEstado);
        notificacion.enviarMensaje(pedido.getId(), nuevoEstado);
    }
}