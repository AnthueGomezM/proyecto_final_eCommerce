package co.edu.ucc.proyecto_final_eCommerce.catalogo.factory;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.builder.ProductoBuilder;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.builder.ProductoConcretoBuilder;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.builder.ProductoDirector;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Producto;

public class ProductoDeportivoFactory implements AbstractProductoFactory {
    @Override
    public Producto crearProducto() {
        ProductoBuilder builder = new ProductoConcretoBuilder();
        ProductoDirector director = new ProductoDirector(builder);
        return director.construirProductoDeportivo();
    }
}
