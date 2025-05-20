package co.edu.ucc.proyecto_final_eCommerce.catalogo.domain;

import co.edu.ucc.proyecto_final_eCommerce.cupones.model.UsuarioTipo;
import co.edu.ucc.proyecto_final_eCommerce.reportes.visitor.ReporteVisitor;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String id;
    private UsuarioTipo tipo;
    private List<Producto> historialBusqueda = new ArrayList<>();
    private List<Producto> productosRecientes = new ArrayList<>();
    private List<Producto> historialCompras = new ArrayList<>();

    public Usuario(String id) {
        this.id = id;
    }

    public void agregarABusquedas(Producto p) {
        historialBusqueda.add(p);
    }

    public void registrarCompra(Producto p) {
        historialCompras.add(p);
    }

    public void agregarARecientes(Producto p) {
        productosRecientes.add(p);
    }

    public List<Producto> getHistorialBusqueda() {
        return historialBusqueda;
    }

    public List<Producto> getCompras() {
        return historialCompras;
    }

    public String getId() {
        return id;
    }
    public UsuarioTipo getTipo() {
        return tipo;
    }

    public void aceptar(ReporteVisitor visitor) {
        visitor.visitar(this);
    }
    public List<Producto> getProductosRecientes() {
        return productosRecientes;
    }
}
