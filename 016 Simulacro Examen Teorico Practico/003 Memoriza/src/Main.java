import java.util.Scanner;
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static String[] palabras = {"sol", "luna", "estrella", "cielo", "mar", "montaña", "río", "nube", "flor", "árbol"};
    private static String[] respuestas = new String[palabras.length];

    private static void mostrarPalabra() {
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("Palabra a memorizar: " + palabras[i]);
            respuestas[i] = palabras[i];

            System.out.print("Escribe todas las palabras memorizadas hasta ahora: ");
            String entrada = scanner.nextLine();

            VerificarPalabra(entrada, i);

        }
    }

    private static void VerificarPalabra(String entrada, int i) {
        // Verificar si la respuesta es correcta
        StringBuilder correctas = new StringBuilder();
        for (int j = 0; j <= i; j++) {
            correctas.append(respuestas[j]).append(" ");
        }

        if (!entrada.equals(correctas.toString().trim())) {
            System.out.println("¡Incorrecto! La secuencia era: " + correctas.toString().trim());
            System.out.println("Intenta de nuevo desde el inicio.");
            i = -1; // Reiniciar el juego
        } else {
            System.out.println("¡Correcto! Sigue a la siguiente palabra.\n");
        }
    }

    public static void main(String[] args) {

        mostrarPalabra();
        System.out.println("¡Felicidades! Has memorizado todas las palabras correctamente.");
        scanner.close();
    }
}