package co.edu.ucc.proyecto_final_eCommerce.pedidoMemento;

import java.time.LocalDateTime;

public class PedidoMemento {
    private final String id;
    private final String estado;
    private final String direccionEnvio;
    private final LocalDateTime fechaCreacion;

    public PedidoMemento(String id, String estado, String direccionEnvio, LocalDateTime fechaCreacion) {
        this.id = id;
        this.estado = estado;
        this.direccionEnvio = direccionEnvio;
        this.fechaCreacion = fechaCreacion;
    }

    public String getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
}
