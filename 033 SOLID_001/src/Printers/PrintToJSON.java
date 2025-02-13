package Printers;

import Herencia.Reporte;
import Interfaces.Print;

public class PrintToJSON extends Reporte {

    private String cadenaENJSON;

    public PrintToJSON(String cadena) {
        super(cadena);
    }

    void imprimirCadena() {
        System.out.println(super.cadenaATransformar);
        System.out.println(this.cadenaENJSON);
    }
}
