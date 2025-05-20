package co.edu.ucc.proyecto_final_eCommerce.cupones.command;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Producto;

import java.util.HashMap;
import java.util.Map;

public class Carrito {

    private Map<Producto, Integer> productos = new HashMap<>();
    private double totalOriginal;
    private double totalConDescuento;
    private boolean descuentoAplicado;

    public Carrito() {
        this.totalOriginal = 0.0;
        this.totalConDescuento = 0.0;
        this.descuentoAplicado = false;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productos.put(producto, cantidad);
        double subtotal = producto.getPrecio() * cantidad;
        totalOriginal += subtotal;
        totalConDescuento += subtotal;
    }

    public void aplicarDescuento(double descuento) {
        if (!descuentoAplicado) {
            this.totalConDescuento -= descuento;
            this.descuentoAplicado = true;
        }
    }

    public void removerDescuento() {
        if (descuentoAplicado) {
            this.totalConDescuento = this.totalOriginal;
            this.descuentoAplicado = false;
        }
    }

    public double getTotal() {
        return totalConDescuento;
    }

    public double getTotalOriginal() {
        return totalOriginal;
    }

    public boolean isDescuentoAplicado() {
        return descuentoAplicado;
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }
}
