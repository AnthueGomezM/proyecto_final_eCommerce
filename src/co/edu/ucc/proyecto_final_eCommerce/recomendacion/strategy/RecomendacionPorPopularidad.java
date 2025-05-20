package co.edu.ucc.proyecto_final_eCommerce.recomendacion.strategy;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Producto;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Usuario;

import java.util.List;

public class RecomendacionPorPopularidad implements EstrategiaRecomendacion{
    @Override
    public List<Producto> recomendar(Usuario usuario) {
        // Mock: retornar productos más vendidos (simulados)
        return List.of(new Producto("Zapatillas"), new Producto("Camisa"));
    }
}
