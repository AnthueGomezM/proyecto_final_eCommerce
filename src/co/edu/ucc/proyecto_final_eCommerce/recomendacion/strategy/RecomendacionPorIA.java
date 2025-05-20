package co.edu.ucc.proyecto_final_eCommerce.recomendacion.strategy;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Categoria;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Producto;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Usuario;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.VarianteProducto;

import java.util.List;

public class RecomendacionPorIA implements EstrategiaRecomendacion{
    Categoria categoriaSmart = new Categoria("smart");

    VarianteProducto variante1 = new VarianteProducto("M", "Negro", "Aluminio");
    VarianteProducto variante2 = new VarianteProducto("L", "Plata", "Titanio");
    List<VarianteProducto> variantes = List.of(variante1, variante2);
    @Override
    public List<Producto> recomendar(Usuario usuario) {
        // Simulación de IA (en real usaría un motor externo)
        return List.of(new Producto("Smartwatch IA",
                "Un reloj inteligente con funciones de salud y conectividad avanzada.",
                3000.0,
                categoriaSmart,
                variantes));
    }
}
