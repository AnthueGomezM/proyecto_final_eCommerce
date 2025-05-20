package co.edu.ucc.proyecto_final_eCommerce.simulacion;

public class SimuladorMain {
    public static void main(String[] args) throws InterruptedException {
        CompraObservable observable = new CompraObservable();
        observable.agregarObservador(new StockObserver());
        observable.agregarObservador(new FacturacionObserver());

        int duracionSegundos = 30;
        long tiempoInicio = System.currentTimeMillis();

        while ((System.currentTimeMillis() - tiempoInicio) < duracionSegundos * 1000) {
            Thread t = new Thread(new SimuladorCompra(observable));
            t.start();
            Thread.sleep(50); // control de frecuencia
        }

        System.out.println("✅ Simulación finalizada.");
    }
}