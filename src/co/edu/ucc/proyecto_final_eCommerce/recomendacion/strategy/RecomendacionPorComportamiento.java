package co.edu.ucc.proyecto_final_eCommerce.recomendacion.strategy;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Producto;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Usuario;

import java.util.List;

public class RecomendacionPorComportamiento implements EstrategiaRecomendacion{
    @Override
    public List<Producto> recomendar(Usuario usuario) {
        // Analizar historial de navegación
        return usuario.getHistorialBusqueda();
    }
}
