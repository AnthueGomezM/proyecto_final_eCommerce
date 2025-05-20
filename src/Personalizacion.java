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

        System.out.println("****************************************************");
        System.out.println("* \uD83D\uDC68 Nombres: " + nombres + " \uD83D\uDC68");
        System.out.println("* Campus: " + campus);
        System.out.println("* Repositorio: " + repositorio + " \uD83D\uDCDA");
        System.out.println("* Fecha: " + fecha + " \uD83D\uDFEB");
        System.out.println("****************************************************");
        System.out.println("* Este programa implementa patrones solicitados del proyecto E-commerce");
        System.out.println("****************************************************");
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
