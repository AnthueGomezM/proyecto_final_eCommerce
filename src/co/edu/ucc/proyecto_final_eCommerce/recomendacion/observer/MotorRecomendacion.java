package co.edu.ucc.proyecto_final_eCommerce.recomendacion.observer;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Producto;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Usuario;

public class MotorRecomendacion implements ObservadorUsuario {
    @Override
    public void actualizar(EventoUsuario evento, Producto producto, Usuario usuario) {
        switch (evento) {
            case BUSQUEDA -> usuario.agregarABusquedas(producto);
            case COMPRA -> usuario.registrarCompra(producto);
            case VISITA_PRODUCTO -> usuario.agregarARecientes(producto);
        }
    }
}
