package co.edu.ucc.proyecto_final_eCommerce.cupones.chain;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Usuario;
import co.edu.ucc.proyecto_final_eCommerce.cupones.model.Cupon;

import java.time.LocalDate;

public class FechaValidaRegla extends ReglaValidacion{
    @Override
    protected boolean validarRegla(Cupon cupon, double montoCarrito, Usuario usuario) {
        return LocalDate.now().isBefore(cupon.getFechaExpiracion());
    }
}
