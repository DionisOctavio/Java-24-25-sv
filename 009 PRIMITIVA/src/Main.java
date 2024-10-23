import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random ale = new Random();
        Scanner leer = new Scanner(System.in);
        int intento = 6;

        String arrayPrimitiva[] = new String[6];
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            int numAle = ale.nextInt(100);
            arrayPrimitiva[i] = String.valueOf(numAle);
        }

        for (int i = 0; i < arrayPrimitiva.length; i++) {
            System.out.println(arrayPrimitiva[i]);
        }

        do {
            System.out.println("Intentos: " + intento);
            System.out.println("Dame un Numerin");
            String usuario = leer.next();
            for (int i = 0; i < arrayPrimitiva.length; i++) {
                if (usuario.equals(arrayPrimitiva[i])) {
                    arrayPrimitiva[i] = "XX";
                }
            }

            for (int i = 0; i < arrayPrimitiva.length; i++) {
                System.out.println(arrayPrimitiva[i]);
            }

            intento = intento - 1;
        }while(intento > 0);

        System.out.println("+-----------------+");
        System.out.println("   End Primitiva  ");
        System.out.println("+---------------- +");
    }
}