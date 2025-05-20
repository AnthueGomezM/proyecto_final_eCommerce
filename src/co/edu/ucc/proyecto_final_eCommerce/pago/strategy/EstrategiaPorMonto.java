package co.edu.ucc.proyecto_final_eCommerce.pago.strategy;

import co.edu.ucc.proyecto_final_eCommerce.pago.adapter.MercadoPagoAdapter;
import co.edu.ucc.proyecto_final_eCommerce.pago.adapter.PasarelaPago;
import co.edu.ucc.proyecto_final_eCommerce.pago.adapter.StripeAdapter;
import co.edu.ucc.proyecto_final_eCommerce.pago.model.DetallePago;

public class EstrategiaPorMonto implements EstrategiaSeleccionPago{
    @Override
    public PasarelaPago seleccionar(DetallePago pago) {
        if (pago.getMonto() < 100) {
            return new MercadoPagoAdapter();
        } else {
            return new StripeAdapter();
        }
    }
}
