package co.edu.ucc.proyecto_final_eCommerce.pago.adapter;

public class MercadoPagoServicio {
    public boolean procesar(String clienteId, String pais, double monto) {
        System.out.println("💰 Procesando pago con MercadoPago:");
        System.out.println("Cliente: " + clienteId + ", País: " + pais + ", Monto: $" + monto);
        return true; // Simulación exitosa
    }
}
