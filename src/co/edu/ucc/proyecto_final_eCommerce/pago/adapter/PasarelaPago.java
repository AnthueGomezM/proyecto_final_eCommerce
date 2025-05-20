package co.edu.ucc.proyecto_final_eCommerce.pago.adapter;

import co.edu.ucc.proyecto_final_eCommerce.pago.model.DetallePago;

public interface PasarelaPago {
    boolean procesarPago(DetallePago pago);
}
