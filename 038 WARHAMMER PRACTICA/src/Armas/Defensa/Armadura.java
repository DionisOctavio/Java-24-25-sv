package Armas.Defensa;

public class Armadura extends ArmaDefensa {

    private final int VIDA_DEFENDIDA = 0;

    public Armadura(String nombre) {
        super(nombre);
    }

    public int getVIDA_DEFENDIDA() {
        return VIDA_DEFENDIDA;
    }

    @Override
    public String toString() {
        return "Armadura{" +
                "VIDA_DEFENDIDA=" + VIDA_DEFENDIDA +
                '}';
    }

}
