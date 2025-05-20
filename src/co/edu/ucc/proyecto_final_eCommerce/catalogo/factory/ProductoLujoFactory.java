package co.edu.ucc.proyecto_final_eCommerce.catalogo.factory;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.builder.ProductoBuilder;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.builder.ProductoConcretoBuilder;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Categoria;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Producto;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.VarianteProducto;

import java.util.List;

public class ProductoLujoFactory implements AbstractProductoFactory{
    @Override
    public Producto crearProducto() {
        ProductoBuilder builder = new ProductoConcretoBuilder();
        builder.setNombre("Bolso de Lujo");
        builder.setDescripcion("Bolso exclusivo de cuero italiano");
        builder.setPrecio(450.00);
        builder.setCategoria(new Categoria("Lujo"));

        List<VarianteProducto> variantes = List.of(
                new VarianteProducto("Negro", "Única", "Cuero"),
                new VarianteProducto("Marrón", "Única", "Cuero")
        );
        builder.setVariantes(variantes);

        return builder.build();
    }
}
