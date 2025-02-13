package Printers;

import Herencia.Reporte;

public class printToJSON extends Reporte {

    private String cadenaEnHtml;

    public printToJSON(String cadena){
        super(cadena);
    }
    public void imprimirCadena(){
        System.out.println(super.cadenaTransformar);
        System.out.println(this.cadenaEnHtml);
    }

    @Override
    public String toString() {
        return "printToJSON{" +
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
