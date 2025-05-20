package co.edu.ucc.proyecto_final_eCommerce.categorias.composite;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Producto;

public class ItemProducto extends ComponenteCatalogo{
    private Producto producto;

    public ItemProducto(Producto producto) {
        super(producto.getNombre());
        this.producto = producto;
    }

    @Override
    public void mostrar(int nivel) {
        System.out.println("  ".repeat(nivel) + "- Producto: " + producto.getNombre());
    }

    public Producto getProducto() {
        return producto;
    }
}
