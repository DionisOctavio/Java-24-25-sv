package Printers;

import Herencia.Reporte;

public class printToHTML extends Reporte {

    private String cadenaEnHtml;

    public printToHTML(String cadena){
        super(cadena);
    }
    public void imprimirCadena(){
        System.out.println(super.cadenaTransformar);
        System.out.println(this.cadenaEnHtml);
    }

    /* public abstract void imprimir */

    @Override
    public String toString() {
        return "printToHTML{" +
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
