package Printers;

import Herencia.Reporte;
import Interfaces.Print;

public class PrintToXML extends Reporte {

    private String cadenaENXML;

    public PrintToXML(String cadena) {
        super(cadena);
    }

    void imprimirCadena() {
        System.out.println(super.cadenaATransformar);
        System.out.println(this.cadenaENXML);
    }

}
