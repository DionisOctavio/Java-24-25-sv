import Herencia.Reporte;
import Printers.printToJSON;
import Printers.printToXML;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Reporte PrintToJSON = new printToJSON("HOLA JSON");
        Reporte PrintToXML = new printToXML("HOLA XML");
        Reporte PrintToHTML = new printToXML("HOLA HTML");

        ArrayList<Reporte> lst = new ArrayList<>();
        lst.add(PrintToJSON);
        lst.add(PrintToXML);
        lst.add(PrintToHTML);

        for (Reporte reporte : lst) {
            reporte.imprimirCadena();
        }

    }
}