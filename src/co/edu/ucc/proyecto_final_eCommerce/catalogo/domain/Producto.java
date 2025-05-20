package co.edu.ucc.proyecto_final_eCommerce.catalogo.domain;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String nombre;
    private String descripcion;
    private double precio;
    private Categoria categoria;
    private List<VarianteProducto> variantes;

    public Producto(String nombre, String descripcion, double precio, Categoria categoria, List<VarianteProducto> variantes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.variantes = variantes;
    }

    public Producto(String zapatillas) {
        this.nombre = zapatillas;
        this.descripcion = zapatillas;
        this.precio = Double.parseDouble(zapatillas);
        this.categoria = null;
        this.variantes = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria +
                ", variantes=" + variantes +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<VarianteProducto> getVariantes() {
        return variantes;
    }

    public void setVariantes(List<VarianteProducto> variantes) {
        this.variantes = variantes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
