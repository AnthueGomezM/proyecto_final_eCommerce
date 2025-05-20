package co.edu.ucc.proyecto_final_eCommerce.cupones.chain;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Usuario;
import co.edu.ucc.proyecto_final_eCommerce.cupones.model.Cupon;

public class MontoMinimoRegla extends ReglaValidacion{
    @Override
    protected boolean validarRegla(Cupon cupon, double montoCarrito, Usuario usuario) {
        return montoCarrito >= cupon.getMontoMinimo();
    }
}
