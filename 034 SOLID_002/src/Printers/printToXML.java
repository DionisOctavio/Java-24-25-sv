package Printers;

import Herencia.Reporte;

public class printToXML extends Reporte {

    private String cadenaEnHtml;

    public printToXML(String cadena) {
        super(cadena);
    }

    public void imprimirCadena(){
        System.out.println(super.cadenaTransformar);
        System.out.println(this.cadenaEnHtml);
    }

    @Override
    public String toString() {
        return "printToXML{" +
                "cadenaEnHtml='" + cadenaEnHtml + '\'' +
                '}';
    }

    public String getCadenaEnHtml() {
        return cadenaEnHtml;
    }

    public void setCadenaEnHtml(String cadenaEnHtml) {
        this.cadenaEnHtml = cadenaEnHtml;
    }
}
