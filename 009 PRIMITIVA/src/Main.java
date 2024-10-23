import java.util.Random;
import java.util.Scanner;

public class Main {

    private static char[][] tablero;
    private static final int FILA = 5;
    private static final int COLUMNA = 5;
    private static Random aleatorio = new Random();
    private static void rellenarTablero(char personaje){
        for (int i = 0; i < FILA; i++){
            for(int j = 0; j > COLUMNA; j++){
                tablero[i][j] = personaje;
            }
        }
    }

    private static void asignarBart(char caracter){
        int filaBart = aleatorio.nextInt(FILA);
        int columnaBart = aleatorio.nextInt(COLUMNA);

        tablero[filaBart][columnaBart] = caracter;
    }

    private static void asignarPersonajeALibre(char personaje, int numRepeticiones){
        int filaPersonaje = 0;
        int columnaPersonaje = 0;
        for(int i = 0; i < numRepeticiones; i++){
            do{
                filaPersonaje = aleatorio.nextInt(FILA);
                columnaPersonaje = aleatorio.nextInt(COLUMNA);
            }while (tablero[filaPersonaje][columnaPersonaje] !='L');
            tablero[filaPersonaje][columnaPersonaje] = personaje;
        }

    }

    public static void main(String[] args) {
        tablero = new char[FILA][COLUMNA];

        rellenarTablero('L');

        asignarBart('B');

        asignarPersonajeALibre('H', 10);

        asignarPersonajeALibre('M', 10);




    }
}