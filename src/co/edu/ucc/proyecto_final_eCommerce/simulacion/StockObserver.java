package co.edu.ucc.proyecto_final_eCommerce.simulacion;

public class StockObserver implements CompraObserver {
    @Override
    public void notificar(String producto, String hilo) {
        System.out.println("[STOCK] " + producto + " procesado por " + hilo);
    }
}