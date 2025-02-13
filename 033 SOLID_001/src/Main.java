import Herencia.Reporte;
import Interfaces.Print;
import Printers.PrintToHTML;
import Printers.PrintToJSON;
import Printers.PrintToXML;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        PrintToHTML printToHTML = new PrintToHTML("");
        PrintToXML printToXML = new PrintToXML("");
        PrintToJSON printToJSON = new PrintToJSON("");

        ArrayList<Reporte> lst = new ArrayList<>();

        lst.add(printToHTML);
        lst.add(printToXML);
        lst.add(printToJSON);

    }
}