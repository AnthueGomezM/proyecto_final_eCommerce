package co.edu.ucc.proyecto_final_eCommerce.pedido;

import co.edu.ucc.proyecto_final_eCommerce.pedido.Estados.*;
import co.edu.ucc.proyecto_final_eCommerce.pedido.Mediator.PedidoMediator;
import co.edu.ucc.proyecto_final_eCommerce.pedidoMemento.PedidoHistorial;
import co.edu.ucc.proyecto_final_eCommerce.pedidoMemento.PedidoMemento;

import java.time.LocalDateTime;

public class Pedido {
    private String id;
    private PedidoState estado;
    private PedidoMediator mediator;

    private String direccionEnvio;
    private LocalDateTime fechaCreacion;
    private PedidoHistorial historial;

    public Pedido(String id,String direccionEnvio, PedidoMediator mediator) {
        this.id = id;
        this.direccionEnvio = direccionEnvio;
        this.mediator = mediator;
        this.estado = new PendienteState();
        this.fechaCreacion = LocalDateTime.now();
        this.historial = new PedidoHistorial();

        // Guardar estado inicial
        guardarEstado();
    }

    public void avanzarEstado() {
        guardarEstado();
        estado.avanzar(this);
        notificarCambio();
    }

    public void cancelar() {
        guardarEstado();
        estado.cancelar(this);
        notificarCambio();
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

    public void guardarEstado() {
        PedidoMemento memento = new PedidoMemento(id, verEstado(), direccionEnvio, fechaCreacion);
        historial.guardar(memento);
    }

    public void restaurarEstado() {
        PedidoMemento memento = historial.deshacer();
        if (memento != null) {
            this.id = memento.getId();
            this.direccionEnvio = memento.getDireccionEnvio();
            this.fechaCreacion = memento.getFechaCreacion();
            this.estado = obtenerEstadoDesdeTexto(memento.getEstado());
            notificarCambio();
        }
    }

    private PedidoState obtenerEstadoDesdeTexto(String estadoTexto) {
        return switch (estadoTexto) {
            case "Pendiente" -> new PendienteState();
            case "En Proceso" -> new EnviadoState();
            case "Confirmado" -> new ConfirmadoState();
            case "Cancelado" -> new CanceladoState();
            case "Entregado" -> new EntregadoState();
            default -> throw new IllegalStateException("❌ Estado desconocido: " + estadoTexto);
        };
    }

    // === UTILIDAD ===
    public void mostrarInfo() {
        System.out.println("📦 Pedido #" + id + " | Estado: " + verEstado() + " | Dirección: " + direccionEnvio);
    }

    private void notificarCambio() {
        if (mediator != null) {
            mediator.notificarCambio(this, verEstado());
        }
    }


}
