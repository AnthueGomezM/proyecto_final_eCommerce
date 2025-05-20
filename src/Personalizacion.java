import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;

public class Personalizacion {
    public static void main(String[] args) {
        String nombres = "Joseph Rodriguez, Anthue Gomez, Emilio Martinez";
        String campus = "Campus Cali, U. Cooperativa de Colombia";
        String repositorio = "https://github.com/AnthueGomezM/proyecto_final_eCommerce";
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = ahora.format(formatter);

        System.out.println(String.format("""
        ****************************************************
        * \uD83D\uDC68 Stakeholders: %s \uD83D\uDC68
        * Campus: %s
        * Repositorio: %s \uD83D\uDCDA
        * Fecha: %s \uD83D\uDFEB
        ****************************************************
        * Este programa implementa patrones solicitados del proyecto E-commerce
        ****************************************************
        """, nombres, campus, repositorio, fecha));
        getIdentidad();
    }

    public static void getIdentidad() {
        String[] nombres = {"Joseph Rodriguez", "Anthue Gomez", "Emilio Martinez"};
        for (String nombreCompleto : nombres) {
            String nombreCodificado = java.util.Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
            System.out.println("Identidad codificada en Base64 para " + nombreCompleto + ": " + nombreCodificado);
        }
    }
}
