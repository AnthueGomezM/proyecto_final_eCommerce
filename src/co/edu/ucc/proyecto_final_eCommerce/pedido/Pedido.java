package co.edu.ucc.proyecto_final_eCommerce.pedido;

import co.edu.ucc.proyecto_final_eCommerce.pedido.Estados.PendienteState;
import co.edu.ucc.proyecto_final_eCommerce.pedido.Mediator.PedidoMediator;

public class Pedido {
    private String id;
    private PedidoState estado;
    private PedidoMediator mediator;

    public Pedido(String id, PedidoMediator mediator) {
        this.id = id;
        this.mediator = mediator;
        this.estado = new PendienteState();
    }

    public void avanzarEstado() {
        estado.avanzar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public String verEstado() {
        return estado.obtenerEstado();
    }

    public void setEstado(PedidoState estado) {
        this.estado = estado;
    }

    public PedidoMediator getMediator() {
        return mediator;
    }

    public String getId() {
        return id;
    }
}