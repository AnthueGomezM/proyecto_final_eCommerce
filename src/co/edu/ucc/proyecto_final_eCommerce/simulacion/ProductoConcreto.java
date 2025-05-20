package co.edu.ucc.proyecto_final_eCommerce.simulacion;

public class ProductoConcreto implements ProductoFlyweight {
    private final String nombre;
    private final String descripcion;

    public ProductoConcreto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public void mostrarDescripcion() {
        System.out.println("Producto: " + nombre + " - " + descripcion);
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}