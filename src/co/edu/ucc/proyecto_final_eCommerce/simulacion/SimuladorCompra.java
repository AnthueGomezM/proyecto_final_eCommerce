package co.edu.ucc.proyecto_final_eCommerce.simulacion;

import java.util.Random;

public class SimuladorCompra implements Runnable {
    private final CompraObservable observable;
    private final String[] productos = {"Camiseta", "Zapatos", "Laptop", "Celular", "Libro"};

    public SimuladorCompra(CompraObservable observable) {
        this.observable = observable;
    }

    @Override
    public void run() {
        Random random = new Random();
        String producto = productos[random.nextInt(productos.length)];
        ProductoFlyweight p = FlyweightFactory.obtenerProducto(producto, "Descripción común");

        p.mostrarDescripcion();
        observable.notificarTodos(p.getNombre(), Thread.currentThread().getName());

        try {
            Thread.sleep(random.nextInt(200));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}