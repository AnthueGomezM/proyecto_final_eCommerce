package co.edu.ucc.proyecto_final_eCommerce.reportes.fecade;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Usuario;
import co.edu.ucc.proyecto_final_eCommerce.reportes.visitor.GeneradorReporteConcreto;
import co.edu.ucc.proyecto_final_eCommerce.reportes.visitor.ReporteVisitor;

import java.util.List;

public class ReporteFacade {

    private final ReporteVisitor visitor = new GeneradorReporteConcreto();

    public void generarReportesUsuarios(List<Usuario> usuarios) {
        System.out.println("=== Generando informes ejecutivos de usuarios ===");
        for (Usuario u : usuarios) {
            u.aceptar(visitor);
        }
        System.out.println("=== Todos los informes fueron generados ===");
    }
}