import java.util.Random;

public class Bingo {

    private static int filas = 10;
    private static int columnas = 9;
    private static int tablero[][] = new int[filas][columnas];
    private static Random random = new Random();

    private static void rellenarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                //int numAleatorio= random.nextInt(10)+10*(j+1); //10 - 19
                int numAleatorio = random.nextInt(10*(j+1),(10*(j+1)+10));
                tablero[i][j] = numAleatorio;
            }
        }
    }

    private static void ordenarTablero() {
        int cont = 0;
        do {
            for (int i = 0; i < filas -1; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (tablero[i][j] > tablero[i + 1][j]) {
                        int aux;
                        aux = tablero[i][j];
                        tablero[i][j] = tablero[i + 1][j];
                        tablero[i + 1][j] = aux;
                    }
                }
            }
            cont++;
        }while (cont < filas);
    }

    private static void imprimirTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        rellenarTablero();
        ordenarTablero();
        imprimirTablero();

    }
}