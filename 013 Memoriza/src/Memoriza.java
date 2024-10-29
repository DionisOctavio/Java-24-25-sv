import java.util.Random;
import java.util.Scanner;

public class Memoriza {

    private static Random aleatorio = new Random();
    private static Scanner leer = new Scanner(System.in);

    private static int numParejas = 2;
    private static int cantidadNum = 8;

    private static final int FILA = 4;
    private static final int COLUMNA = 4;

    private static int[][] tablero = new int[FILA][COLUMNA];

    private static void rellenarTablero() {
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                tablero[i][j] = 0;
            }
        }
    }

    private static void imprimeTablero() {
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void asignarParejas (){

        int filaAleatoria = 0;
        int columnaAleatoria = 0;

        for (int i = 0; i < cantidadNum; i++){
            for (int j = 0; j < numParejas; j++){

                do {
                    filaAleatoria = aleatorio.nextInt(FILA);
                        columnaAleatoria = aleatorio.nextInt(COLUMNA);

                }while (tablero[filaAleatoria][columnaAleatoria] != 0);
                tablero[filaAleatoria][columnaAleatoria] = (i+1);
            }
        }
    }

    public static void main(String[] args) {

        asignarParejas();
        imprimeTablero();

        System.out.println("Cuantos intentos quieres Probar");
        int intentos = leer.nextInt();

        do{
            System.out.println("Dame las Cordenadas X del Primer Numero");
            int posicionUsuarioFila = leer.nextInt();
            System.out.println("Dame las Cordenadas Y del Primer Numero");
            int posicionUsuarioColumna = leer.nextInt();

            System.out.println("Dame las Cordenadas X del Segundo Numero");
            int posicionUsuarioFila2 = leer.nextInt();
            System.out.println("Dame las Cordenadas Y del Segundo Numero");
            int posicionUsuarioColumna2 = leer.nextInt();

            if (tablero[posicionUsuarioFila][posicionUsuarioColumna] == tablero[posicionUsuarioFila2][posicionUsuarioColumna2]){
                tablero[posicionUsuarioFila][posicionUsuarioColumna] = 0;
                tablero[posicionUsuarioFila2][posicionUsuarioColumna2] = 0;
                System.out.println("Has acertado");

            }else{
                System.out.println("Posiciones incorectas");
            }
            imprimeTablero();
            intentos--;
        }while (intentos > 0);
    }
}