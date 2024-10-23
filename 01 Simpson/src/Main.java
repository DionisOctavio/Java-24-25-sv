import java.util.Random;
import java.util.Scanner;

public class Main {

    private static char[][] tablero;
    private static final int FILA = 10;
    private static final int COLUMNA = 10;
    private static Random aleatorio = new Random();
    private static int vidas = 5;
    private static int filaBart;
    private static int columnaBart;

    private static char LIBRE = 'L';
    private static char BART = 'B';
    private static char HOMER = 'H';
    private static char MURO = 'M';
    private static char FINAL = 'F';

    // Defino una variable que imprime el tablero
    private static void imprimirTablero() {
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Defino una variable que rellena el ttablero de L
    private static void rellenarTablero(char personaje){
        for (int i = 0; i < FILA; i++){
            for(int j = 0; j < COLUMNA; j++){
                tablero[i][j] = personaje;
            }
        }
    }

    // Defino una variable que asigna a bar a una fila y columan a leatoria
    private static void asignarBart(char caracter){
        filaBart = aleatorio.nextInt(FILA);
        columnaBart = aleatorio.nextInt(COLUMNA);

        tablero[filaBart][columnaBart] = caracter;
    }

    // Asigno uno o varios caracter osea un Homer o un Muro a una casilla aleatoria
    private static void asignarPersonajeALibre(char personaje, int numRepeticiones){
        int filaPersonaje = 0;
        int columnaPersonaje = 0;
        for(int i = 0; i < numRepeticiones; i++){
            do{
                filaPersonaje = aleatorio.nextInt(FILA);
                columnaPersonaje = aleatorio.nextInt(COLUMNA);
            }while (tablero[filaPersonaje][columnaPersonaje] != LIBRE);
            tablero[filaPersonaje][columnaPersonaje] = personaje;
        }

    }


    public static void main(String[] args) {
        tablero = new char[FILA][COLUMNA];

        rellenarTablero(LIBRE);

        asignarBart(BART);

        asignarPersonajeALibre(HOMER, 10);

        asignarPersonajeALibre(MURO, 10);

        // Defino una casilla vara que sea el final del juego
        tablero[FILA - 1][COLUMNA - 1] = FINAL;

        imprimirTablero();

        Scanner leer = new Scanner(System.in);

        do{
            System.out.print("Usa WASD para desplazarte");
            String movimiento = leer.nextLine();

            switch (movimiento) {
                case "W", "w":
                    if (filaBart == 0) {  // Si Bart ya está en la fila superior, no puede moverse más arribaw
                        System.out.println("Fuera de Límites, no puedes avanzar hacia arriba.");
                    } else {
                        filaBart--;  // Mueve a Bart hacia arriba
                        if (tablero[filaBart][columnaBart] == HOMER) {
                            System.out.println("Te encontraste con Homero. Pierdes una vida.");
                            vidas--;
                            tablero[filaBart + 1][columnaBart] = LIBRE;
                            tablero[filaBart][columnaBart] = BART;
                        } else if (tablero[filaBart][columnaBart] == MURO) {
                            System.out.println("¡Hay un muro! No puedes pasar.");
                            filaBart++;
                        } else if (tablero[filaBart][columnaBart] == FINAL) {
                            System.out.println("¡Felicidades! Llegaste al final.");
                            vidas = 0;  // Termina el juego
                        } else {
                            tablero[filaBart + 1][columnaBart] = LIBRE;
                            tablero[filaBart][columnaBart] = BART;
                        }
                    }
                    break;
                case "S","s":
                    if (filaBart == 9) {
                        System.out.println("Fuera de Límites, no puedes avanzar hacia arriba.");
                    } else {
                        filaBart++;
                        if (tablero[filaBart][columnaBart] == HOMER) {
                            System.out.println("Te encontraste con Homero. Pierdes una vida.");
                            vidas--;
                            tablero[filaBart - 1][columnaBart] = LIBRE;
                            tablero[filaBart][columnaBart] = BART;
                        } else if (tablero[filaBart][columnaBart] == MURO) {
                            System.out.println("¡Hay un muro! No puedes pasar.");
                            filaBart++;
                        } else if (tablero[filaBart][columnaBart] == FINAL) {
                            System.out.println("¡Felicidades! Llegaste al final.");
                            vidas = 0;
                        } else {
                            tablero[filaBart - 1][columnaBart] = LIBRE;
                            tablero[filaBart][columnaBart] = BART;
                        }
                    }
                    break;
                case "A","a":
                    if (columnaBart == 0) {
                        System.out.println("Fuera de Límites, no puedes avanzar hacia la izquierda.");
                    } else {
                        columnaBart--;
                        if (tablero[filaBart][columnaBart] == HOMER) {
                            System.out.println("Te encontraste con Homero. Pierdes una vida.");
                            vidas--;
                            tablero[filaBart][columnaBart + 1] = LIBRE;
                            tablero[filaBart][columnaBart] = BART;
                        } else if (tablero[filaBart][columnaBart] == MURO) {
                            System.out.println("¡Hay un muro! No puedes pasar.");
                            columnaBart++;
                        } else if (tablero[filaBart][columnaBart] == FINAL) {
                            System.out.println("¡Felicidades! Llegaste al final.");
                            vidas = 0;  // Termina el juego
                        } else {
                            tablero[filaBart][columnaBart + 1] = LIBRE;
                            tablero[filaBart][columnaBart] = BART;
                        }
                    }
                    break;
                case "D","d":
                    if (columnaBart == 9) {
                        System.out.println("Fuera de Límites, no puedes avanzar hacia la izquierda.");
                    } else {
                        columnaBart++;
                        if (tablero[filaBart][columnaBart] == HOMER) {
                            System.out.println("Te encontraste con Homero. Pierdes una vida.");
                            vidas--;
                            tablero[filaBart][columnaBart - 1] = LIBRE;
                            tablero[filaBart][columnaBart] = BART;
                        } else if (tablero[filaBart][columnaBart] == MURO) {
                            System.out.println("¡Hay un muro! No puedes pasar.");
                            columnaBart--;
                        } else if (tablero[filaBart][columnaBart] == FINAL) {
                            System.out.println("¡Felicidades! Llegaste al final.");
                            vidas = 0;
                        } else {
                            tablero[filaBart][columnaBart - 1] = LIBRE;
                            tablero[filaBart][columnaBart] = BART;
                        }
                    }
                    break;
            }
            imprimirTablero();
        }while (vidas > 0);
    }
}