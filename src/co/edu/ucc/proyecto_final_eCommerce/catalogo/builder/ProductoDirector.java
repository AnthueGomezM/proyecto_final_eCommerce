package co.edu.ucc.proyecto_final_eCommerce.catalogo.builder;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Categoria;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Producto;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.VarianteProducto;

import java.util.List;

public class ProductoDirector {
    private final ProductoBuilder builder;

    public ProductoDirector(ProductoBuilder builder) {
        this.builder = builder;
    }

    public Producto construirProductoDeportivo() {
        builder.setNombre("Camiseta Deportiva");
        builder.setDescripcion("Camiseta transpirable para entrenamiento");
        builder.setPrecio(29.99);
        builder.setCategoria(new Categoria("Deporte"));

        List<VarianteProducto> variantes = List.of(
                new VarianteProducto("Rojo", "M", "Poliéster"),
                new VarianteProducto("Azul", "L", "Poliéster")
        );
        builder.setVariantes(variantes);

        return builder.build();
    }
}
