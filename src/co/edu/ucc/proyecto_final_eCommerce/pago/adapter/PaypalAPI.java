package co.edu.ucc.proyecto_final_eCommerce.pago.adapter;

public class PaypalAPI {
    public boolean enviarPago(String clienteId, double monto, String moneda) {
        System.out.println("💸 Enviando pago con PayPal:");
        System.out.println("Cliente: " + clienteId + ", Monto: $" + monto + ", Moneda: " + moneda);
        return true; // Simulación exitosa
    }
}
