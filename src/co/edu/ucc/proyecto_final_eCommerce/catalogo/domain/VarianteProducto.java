package co.edu.ucc.proyecto_final_eCommerce.catalogo.domain;


public class VarianteProducto {
    private String talla;
    private String color;
    private String material;

    public VarianteProducto(String talla, String color, String material) {
        this.talla = talla;
        this.color = color;
        this.material = material;
    }

    public String getTalla() {
        return talla;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return "VarianteProducto{" +
                "color='" + color + '\'' +
                ", talla='" + talla + '\'' +
                '}';
    }
}
