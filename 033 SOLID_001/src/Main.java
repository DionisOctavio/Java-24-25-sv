import Herencia.Reporte;
import Interfaces.Print;
import Printers.PrintToHTML;
import Printers.PrintToJSON;
import Printers.PrintToXML;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        PrintToHTML printToHTML = new PrintToHTML(" ytui");
        PrintToXML printToXML = new PrintToXML("ytjked");
        PrintToJSON printToJSON = new PrintToJSON("ytkytk");

        ArrayList<Reporte> lst = new ArrayList<>();

        lst.add(printToHTML);
        lst.add(printToXML);
        lst.add(printToJSON);

        for (Reporte reporte : lst) {
            printToHTML.imprimi
        }

    }
}