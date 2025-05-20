package co.edu.ucc.proyecto_final_eCommerce.cupones.command;

public class Carrito {

    private double totalOriginal;
    private double totalConDescuento;
    private boolean descuentoAplicado;

    public Carrito(double totalOriginal) {
        this.totalOriginal = totalOriginal;
        this.totalConDescuento = totalOriginal;
        this.descuentoAplicado = false;
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
}
