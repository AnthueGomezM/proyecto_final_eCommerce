package co.edu.ucc.proyecto_final_eCommerce.reportes.visitor;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Usuario;
import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Producto;

public class GeneradorReporteConcreto implements ReporteVisitor {

    @Override
    public void visitar(Usuario usuario) {
        System.out.println("📊 Generando informe del usuario: " + usuario.getId());

        System.out.println("➡ Tipo de usuario: " + usuario.getTipo());

        System.out.println("🕵️ Historial de búsqueda:");
        for (Producto p : usuario.getHistorialBusqueda()) {
            System.out.println("- " + p.getNombre());
        }

        System.out.println("🛍️ Historial de compras:");
        for (Producto p : usuario.getCompras()) {
            System.out.println("- " + p.getNombre());
        }

        System.out.println("🔄 Productos recientes:");
        for (Producto p : usuario.getProductosRecientes()) {
            System.out.println("- " + p.getNombre());
        }

        System.out.println("✅ Informe generado.\n");
    }
}