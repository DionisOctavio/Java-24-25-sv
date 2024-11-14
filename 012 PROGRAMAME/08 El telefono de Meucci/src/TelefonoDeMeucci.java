import java.util.Scanner;

public class TelefonoDeMeucci {

    private static int contarCombinaciones(String cadena) {
        if (cadena.isEmpty()) return 1;

        int total = 0; // almacena el numero de combinaciones posibles

// Va del 1 al 4 por que del 1 al 9 solo hay combinaciones con 4 numeros
// La condición 'i <= cadena.length()' asegura que no intentemos tomar más caracteres de los que tiene la cadena.
        for (int i = 1; i <= 4 && i <= cadena.length(); i++) {

            // Extraemos un prefijo (subcadena) de los primeros 'i' caracteres de la cadena.
            String prefijo = cadena.substring(0, i);

            // Verificamos si este prefijo es un número romano válido (por ejemplo, "I", "V", "IV", etc.).
            if (esDigitoValido(prefijo)) {

                // Si el prefijo es válido, llamamos a 'contarCombinaciones' para el resto de la cadena
                // (excluyendo el prefijo que acabamos de verificar).
                // Esto permite encontrar combinaciones para el resto de la cadena.
                total += contarCombinaciones(cadena.substring(i));
            }
        }

        return total;
    }

    private static boolean esDigitoValido(String s) {
        return s.equals("X") || s.equals("I") || s.equals("II") || s.equals("III") || s.equals("IV") ||
                s.equals("V") || s.equals("VI") || s.equals("VII") || s.equals("VIII") || s.equals("IX");
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in); // defino un scaner llamado "leer"

        while (true) {
            String linea = leer.nextLine().trim();
            if (linea.isEmpty()) break; // Salir si la línea está vacía

            int combinaciones = contarCombinaciones(linea);
            System.out.println(combinaciones);
        }
    }
}
