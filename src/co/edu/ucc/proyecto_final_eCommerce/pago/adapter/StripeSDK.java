package co.edu.ucc.proyecto_final_eCommerce.pago.adapter;

public class StripeSDK {

    public boolean realizarPago(double monto, String moneda, String clienteId) {
        System.out.println("💳 Realizando pago con Stripe:");
        System.out.println("Monto: $" + monto + ", Moneda: " + moneda + ", Cliente: " + clienteId);
        return true; // Simulación exitosa
    }
}
