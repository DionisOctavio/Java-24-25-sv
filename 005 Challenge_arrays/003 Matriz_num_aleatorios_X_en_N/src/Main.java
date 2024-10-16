import java.util.Random;

public class Main {

    private static final int FILA = 6;
    private static final int COLUMNA = 6;
    private static final int[][] matrizNumAleatorio = new int[FILA][COLUMNA];

    public static int imprimirTablero(){
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                System.out.print("[" +matrizNumAleatorio[i][j]+"]" + " ");
            }
            System.out.println();
        }
        return 0;
    }

    public static int matrizNumerosAleatrios(int cant){
        Random ale = new Random();
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                matrizNumAleatorio[i][j] = ale.nextInt(cant);
            }
        }
        return 0;
    }


    public static void main(String[] args) {

        matrizNumerosAleatrios(10);
        imprimirTablero();

    }
}