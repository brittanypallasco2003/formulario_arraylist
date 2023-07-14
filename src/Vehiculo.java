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

    /*se sobreescribe el metodo equals, ya que es un metodo de la clase object que nosotros modificamos su comportamiento*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        if(!Objects.equals(this.marca, vehiculo.marca)){
            return false;
        }
        if(!Objects.equals(this.year, vehiculo.year)){
            return false;
        }
        if(!Objects.equals(this.cilindro, vehiculo.cilindro)){
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, year, cilindro);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", year='" + year + '\'' +
                ", cilindro='" + cilindro + '\'' +
                '}';
    }
}
