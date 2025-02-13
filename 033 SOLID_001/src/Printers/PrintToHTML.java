package Printers;

import Herencia.Reporte;
import Interfaces.Print;

public class PrintToHTML extends Reporte {

    private String cadenaENHTML;

    public PrintToHTML(String cadena) {
        super(cadena);
    }

    void imprimirCadena() {
        System.out.println(super.cadenaATransformar);
        System.out.println(this.cadenaENHTML);
    }

}
