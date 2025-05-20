package co.edu.ucc.proyecto_final_eCommerce.reportes.visitor;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Usuario;

public interface ReporteVisitor {
    void visitar(Usuario usuario);
}