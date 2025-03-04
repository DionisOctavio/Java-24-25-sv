package Armas.Defensa;

public class Escudo extends ArmaDefensa{

    private final int VIDA_DEFENDIDA = 0;

    public Escudo(String nombre) {
        super(nombre);
    }

    public int getVIDA_DEFENDIDA() {
        return VIDA_DEFENDIDA;
    }

    @Override
    public String toString() {
        return "Escudo{" +
                "VIDA_DEFENDIDA=" + VIDA_DEFENDIDA +
                '}';
    }
}
