package co.edu.ucc.proyecto_final_eCommerce.pago.contexto;

import co.edu.ucc.proyecto_final_eCommerce.pago.adapter.PasarelaPago;
import co.edu.ucc.proyecto_final_eCommerce.pago.model.DetallePago;
import co.edu.ucc.proyecto_final_eCommerce.pago.strategy.EstrategiaSeleccionPago;

public class ProcesadorPago {
    private EstrategiaSeleccionPago estrategia;

    public ProcesadorPago(EstrategiaSeleccionPago estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaSeleccionPago estrategia) {
        this.estrategia = estrategia;
    }

    public boolean procesar(DetallePago pago) {
        PasarelaPago pasarela = estrategia.seleccionar(pago);
        return pasarela.procesarPago(pago);
    }
}
