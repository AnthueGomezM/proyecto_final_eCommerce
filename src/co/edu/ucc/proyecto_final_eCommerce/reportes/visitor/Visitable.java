package co.edu.ucc.proyecto_final_eCommerce.reportes.visitor;

public interface Visitable {
    void aceptar(ReporteVisitor visitor);
}