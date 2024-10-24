import java.util.Random;
import java.util.Scanner;

public class Examen {

    // Defino las herramientas que tengo que usar, Random y Scanner
    private static Random aleatorio = new Random();
    private static Scanner leer = new Scanner(System.in);

    // Defino los anchos de la primerara tabla de los numeros
    private static final int FILA_NUMEROS = 10;
    private static final int COLUMNA_NUMEROS = 10;

    // Defino los anchos de la primerara tabla de los Letras
    private static final char FILA_LETRAS = 10;
    private static final char COLUMNA_LETRAS = 10;

    // Inizializo las dos tablas
    private static String[][] tablero = new String[FILA_NUMEROS][COLUMNA_NUMEROS];
    private static String[][] tableroUsuario = new String[FILA_LETRAS][COLUMNA_LETRAS];

   // Defino los intentos
    private static int intento = 5;

    // Relleno el tablero de numeros aleatorios
    private static void rellenarTableroNumerosAleatorios(){
        for (int i = 0; i < FILA_NUMEROS; i++) {
            for (int j = 0; j < COLUMNA_NUMEROS; j++) {
                int numAleatorio = aleatorio.nextInt(90) + 10;
                tablero[i][j] = String.valueOf(numAleatorio);
            }
        }
    }

    // Relleno el tablero de Letras en este caso X
    private static void rellenarTableroUsuarioLetras(){
        for (int i = 0; i < FILA_LETRAS; i++) {
            for (int j = 0; j < COLUMNA_LETRAS; j++) {
                tableroUsuario[i][j] = String.valueOf('X');
            }
        }
    }

    // Imprimo el tablero de Numeros
    private static void imprimirTableroUsuarioAleatorios(){
        for (int i = 0; i < FILA_NUMEROS; i++) {
            for (int j = 0; j < FILA_NUMEROS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Imprimo el tablero de Letras
    private static void imprimirTableroUsuarioLetras(){
        for (int i = 0; i < FILA_LETRAS; i++) {
        for (int j = 0; j < FILA_LETRAS; j++) {
                System.out.print(tableroUsuario[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // relleno los dostableros y muestro la tabla de Letras
        rellenarTableroNumerosAleatorios();
        rellenarTableroUsuarioLetras();
        imprimirTableroUsuarioLetras();

        // funcion de ingresar numeros
        do {
            System.out.println("Ingrese el numero: ");
            String numero = leer.nextLine();
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    if (numero.equals(tablero[i][j])) {
                        System.out.println("tu numero esta en el Tablero en la posicion [" + "Fil-" +(i+1) +"][Col-" + (j+1) + "]");
                        tableroUsuario[i][j] = numero.toUpperCase();
                        tablero[i][j] = String.valueOf("XX");

                    }
                }
            }

            intento--;
            System.out.println();
            imprimirTableroUsuarioLetras();
        }while(intento > 0);
        System.out.println();
        imprimirTableroUsuarioAleatorios();
    }
}