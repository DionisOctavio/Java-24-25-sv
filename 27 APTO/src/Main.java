import pojo.Magdalena;

public class Main {
    public static void main(String[] args) {

        String marron = "Marron";
        String mediano = "Mediano";

        Magdalena magdalena = new Magdalena(marron, mediano);
        magdalena.decorar();
        magdalena.estado();


    }
}