package co.edu.ucc.proyecto_final_eCommerce.pedido;

import java.util.Stack;

public class PedidoHistorial {
    private Stack<PedidoMemento> historial = new Stack<>();

    public void guardar(PedidoMemento memento) {
        historial.push(memento);
    }

    public PedidoMemento deshacer() {
        if (!historial.isEmpty()) {
            return historial.pop();
        }
        return null;
    }
}
