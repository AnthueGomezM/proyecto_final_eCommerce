package co.edu.ucc.proyecto_final_eCommerce.recomendacion.observer;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Producto;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Usuario;

public interface ObservadorUsuario {
    void actualizar(EventoUsuario evento, Producto producto, Usuario usuario);
}
