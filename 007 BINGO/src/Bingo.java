import java.util.Random;

public class Bingo {

    // El private significa que solo esta clase puede acceder a la variable en la que esta
    // El Static significa que todas las variables que se definan pertenecen a esta clase no a otra.
    // El Final significa que una vez asignado el valor ya no cambia.
    // El int es para definir una variable que es un numero entero

    private static final int FILA = 3;
    private static final int COLUMNA = 9;

    // El char es para definir una variable que es un caracter unico si fuera mas de uno se usaria string
    private static int[][] tablero;

    private static void RellenarTablero() {
        Random aleatorio = new Random();

        for (int col = 0; col < COLUMNA; col++) {
            int min = 10 + col *10;
            int max = min + 9;
            for (int fil = 0; fil < FILA; fil++) {
                tablero[fil][col] = aleatorio.nextInt((max - min) +1) + min;
            }
            OrdenarTablero(col);
        }
    }

    private static void OrdenarTablero(int col) {
        for (int i = 0; i < FILA - 1; i++) {
            for (int j = 0; j < FILA - 1 - i; j++) {
                if (tablero[j][col] > tablero[j + 1][col]) {
                    int temp = tablero[j][col];
                    tablero[j][col] = tablero[j + 1][col];
                    tablero[j + 1][col] = temp;
                }
            }
        }
    }

    private static void MostrarTablero() {
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        tablero = new int[FILA][COLUMNA];

        RellenarTablero();
        MostrarTablero();

    }

}