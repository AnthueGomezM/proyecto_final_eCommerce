package co.edu.ucc.proyecto_final_eCommerce.simulacion;

public interface CompraObserver {
    void notificar(String producto, String hilo);
}