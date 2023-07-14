import java.io.Serializable;
import java.util.Objects;

public class Vehiculo implements Serializable {
    private static final long serialVesionUID=1L;
    private String marca;
    private String year;
    private String cilindro;

    public Vehiculo(String marca, String year, String cilindro) {
        this.marca = marca;
        this.year = year;
        this.cilindro = cilindro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCilindro() {
        return cilindro;
    }

    public void setCilindro(String cilindro) {
        this.cilindro = cilindro;
    }

    /*Escritura*/

    @Override
    public String toString() {
        return "\nMarca: " + marca + "\nAño: " + year + "\n Cilindraje: " + cilindro + "\n";
    }
}
