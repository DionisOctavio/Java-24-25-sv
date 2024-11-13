import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Paso 1: Leer un número entero del usuario
        System.out.print("Introduce un número entero: ");
        int numero = scanner.nextInt();

        // Paso 2: Convertir el número a una cadena
        String cadena = Integer.toString(numero);
        System.out.println("Número convertido a cadena: " + cadena);

        // Paso 3: Convertir la cadena a un array de caracteres
        char[] caracteres = cadena.toCharArray();
        System.out.println("Cadena convertida a caracteres:");

        // Paso 4: Leer cada carácter de la cadena y mostrarlo
        for (char c : caracteres) {
            System.out.println("Carácter: " + c);
        }

        // Paso 5: Convertir cada carácter a su valor numérico original
        System.out.println("Conversión de cada carácter a número:");
        for (char c : caracteres) {
            int digito = Character.getNumericValue(c); // Convierte el carácter en un número
            System.out.println("Carácter '" + c + "' convertido a número: " + digito);
        }

        scanner.close();
    }
}
