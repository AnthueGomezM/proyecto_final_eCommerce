package co.edu.ucc.proyecto_final_eCommerce.recomendacion.contexto;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Producto;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Usuario;
import co.edu.ucc.proyecto_final_eCommerce.recomendacion.strategy.EstrategiaRecomendacion;

import java.util.List;

public class RecomendadorContexto {
    private EstrategiaRecomendacion estrategia;

    public RecomendadorContexto(EstrategiaRecomendacion estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaRecomendacion estrategia) {
        this.estrategia = estrategia;
    }

    public List<Producto> obtenerRecomendaciones(Usuario usuario) {
        return estrategia.recomendar(usuario);
    }
}
