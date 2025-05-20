package co.edu.ucc.proyecto_final_eCommerce.cupones.chain;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Usuario;
import co.edu.ucc.proyecto_final_eCommerce.cupones.model.Cupon;

public class TipoUsuarioRegla extends ReglaValidacion{
    @Override
    protected boolean validarRegla(Cupon cupon, double montoCarrito, Usuario usuario) {
        return usuario.getTipo().equals(cupon.getTipoUsuarioPermitido());
    }
}
