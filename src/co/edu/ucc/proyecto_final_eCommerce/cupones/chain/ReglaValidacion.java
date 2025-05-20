package co.edu.ucc.proyecto_final_eCommerce.cupones.chain;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Usuario;
import co.edu.ucc.proyecto_final_eCommerce.cupones.model.Cupon;

public abstract class ReglaValidacion {
    protected ReglaValidacion siguiente;

    public ReglaValidacion enlazarCon(ReglaValidacion siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }

    public boolean validar(Cupon cupon, double montoCarrito, Usuario usuario) {
        if (!validarRegla(cupon, montoCarrito, usuario)) {
            return false;
        }
        return siguiente == null || siguiente.validar(cupon, montoCarrito, usuario);
    }

    protected abstract boolean validarRegla(Cupon cupon, double montoCarrito, Usuario usuario);
}
