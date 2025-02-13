package Herencia;

public class Reporte {

    protected String cadenaTransformar;

    public Reporte(String cadena) {
        this.cadenaTransformar = cadena;
    }

    public void imprimirCadena(){
        System.out.println(cadenaTransformar);

    }

}
