package co.edu.ucc.proyecto_final_eCommerce.simulacion;

import java.util.ArrayList;
import java.util.List;

public class CompraObservable {
    private final List<CompraObserver> observadores = new ArrayList<>();

    public void agregarObservador(CompraObserver obs) {
        observadores.add(obs);
    }

    public void notificarTodos(String producto, String hilo) {
        for (CompraObserver obs : observadores) {
            obs.notificar(producto, hilo);
        }
    }
}