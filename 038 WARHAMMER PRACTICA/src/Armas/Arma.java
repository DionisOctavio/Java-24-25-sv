package Armas;

public class Arma {

    private String nombre;

    public Arma(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Arma{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

}
