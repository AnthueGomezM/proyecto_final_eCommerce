package co.edu.ucc.proyecto_final_eCommerce.pedidoMemento;

import java.time.LocalDateTime;

public class Pedido {
    private String id;
    private String estado;
    private String direccionEnvio;
    private LocalDateTime fechaCreacion;

    public Pedido(String id, String direccionEnvio) {
        this.id = id;
        this.direccionEnvio = direccionEnvio;
        this.estado = "Pendiente";
        this.fechaCreacion = LocalDateTime.now();
    }

    public void confirmarEnvio() {
        this.estado = "Enviado";
    }

    public void cancelar() {
        this.estado = "Cancelado";
    }

    public PedidoMemento guardarEstado() {
        return new PedidoMemento(id, estado, direccionEnvio, fechaCreacion);
    }

    public void restaurarEstado(PedidoMemento memento) {
        this.id = memento.getId();
        this.estado = memento.getEstado();
        this.direccionEnvio = memento.getDireccionEnvio();
        this.fechaCreacion = memento.getFechaCreacion();
    }

    public void mostrarInfo() {
        System.out.println("📦 Pedido #" + id + " | Estado: " + estado + " | Dirección: " + direccionEnvio);
    }
}