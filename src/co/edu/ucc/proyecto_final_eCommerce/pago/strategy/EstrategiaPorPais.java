package co.edu.ucc.proyecto_final_eCommerce.pago.strategy;

import co.edu.ucc.proyecto_final_eCommerce.pago.adapter.MercadoPagoAdapter;
import co.edu.ucc.proyecto_final_eCommerce.pago.adapter.PasarelaPago;
import co.edu.ucc.proyecto_final_eCommerce.pago.adapter.PaypalAdapter;
import co.edu.ucc.proyecto_final_eCommerce.pago.adapter.StripeAdapter;
import co.edu.ucc.proyecto_final_eCommerce.pago.model.DetallePago;

public class EstrategiaPorPais implements EstrategiaSeleccionPago{
    @Override
    public PasarelaPago seleccionar(DetallePago pago) {
        switch (pago.getPais().toLowerCase()) {
            case "colombia": return new MercadoPagoAdapter();
            case "usa": return new PaypalAdapter();
            case "europa": return new StripeAdapter();
            default: return new PaypalAdapter(); // Por defecto
        }
    }
}
