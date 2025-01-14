import pojo.Magdalena;
import pojo.MagdalenaFactory;

public class Main {
    public static void main(String[] args) {

        Magdalena magdalena = new Magdalena("Magdalena1","fresa", "mediano",'S');
        Magdalena magdalena2 = new Magdalena("Magdalena2","limon", "mediano",'N');
        Magdalena magdalena3 = new Magdalena("Magdalena3","chocolate", "mediano", 'S');
        Magdalena magdalena4 = new Magdalena("Magdalena4","vainilla", "mediano", 'S');

        MagdalenaFactory MGfactory = new MagdalenaFactory();

        MGfactory.addMagdalena(magdalena);
        MGfactory.addMagdalena(magdalena2);
        MGfactory.addMagdalena(magdalena3);
        MGfactory.addMagdalena(magdalena4);

        MGfactory.printMagdalenas();

    }
}
