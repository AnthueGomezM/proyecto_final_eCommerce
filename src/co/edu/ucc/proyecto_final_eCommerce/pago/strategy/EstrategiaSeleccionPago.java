package co.edu.ucc.proyecto_final_eCommerce.pago.strategy;

import co.edu.ucc.proyecto_final_eCommerce.pago.adapter.PasarelaPago;
import co.edu.ucc.proyecto_final_eCommerce.pago.model.DetallePago;

public interface EstrategiaSeleccionPago {
    PasarelaPago seleccionar(DetallePago pago);
}
