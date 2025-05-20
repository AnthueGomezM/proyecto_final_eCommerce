package co.edu.ucc.proyecto_final_eCommerce.simulacion;

public class FacturacionObserver implements CompraObserver {
    @Override
    public void notificar(String producto, String hilo) {
        System.out.println("[FACTURACIÓN] Compra de " + producto + " facturada por " + hilo);
    }
}