package co.edu.ucc.proyecto_final_eCommerce.simulacion;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private static final Map<String, ProductoFlyweight> productos = new HashMap<>();

    public static ProductoFlyweight obtenerProducto(String nombre, String descripcion) {
        productos.computeIfAbsent(nombre, k -> new ProductoConcreto(nombre, descripcion));
        return productos.get(nombre);
    }
}