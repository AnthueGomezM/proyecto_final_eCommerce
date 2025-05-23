package co.edu.ucc.proyecto_final_eCommerce.catalogo.builder;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Categoria;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Producto;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.VarianteProducto;

import java.util.ArrayList;
import java.util.List;

public class ProductoConcretoBuilder implements ProductoBuilder {
    private String nombre;
    private String descripcion;
    private double precio;
    private Categoria categoria;
    private List<VarianteProducto> variantes = new ArrayList<>();

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public void setVariantes(List<VarianteProducto> variantes) {
        this.variantes = variantes;
    }

    @Override
    public Producto build() {
        return new Producto(nombre, descripcion, precio, categoria, variantes);
    }
}
