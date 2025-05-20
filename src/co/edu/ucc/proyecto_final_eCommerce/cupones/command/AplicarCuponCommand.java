package co.edu.ucc.proyecto_final_eCommerce.cupones.command;

import co.edu.ucc.proyecto_final_eCommerce.catalogo.domain.Usuario;
import co.edu.ucc.proyecto_final_eCommerce.cupones.chain.ReglaValidacion;
import co.edu.ucc.proyecto_final_eCommerce.cupones.model.Cupon;

public class AplicarCuponCommand implements CarritoCommand{
    private Carrito carrito;
    private Cupon cupon;
    private Usuario usuario;
    private ReglaValidacion cadenaReglas;

    public AplicarCuponCommand(Carrito carrito, Cupon cupon, Usuario usuario, ReglaValidacion cadenaReglas) {
        this.carrito = carrito;
        this.cupon = cupon;
        this.usuario = usuario;
        this.cadenaReglas = cadenaReglas;
    }

    @Override
    public void ejecutar() {
        if (cadenaReglas.validar(cupon, carrito.getTotal(), usuario)) {
            double descuento = carrito.getTotal() * cupon.getDescuento() / 100;
            carrito.aplicarDescuento(descuento);
            System.out.println("✅ Cupón aplicado correctamente.");
        } else {
            System.out.println("❌ Cupón no válido.");
        }
    }

    @Override
    public void deshacer() {
        carrito.removerDescuento();
        System.out.println("⏪ Cupón revertido.");
    }
}
