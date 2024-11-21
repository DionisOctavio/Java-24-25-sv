import java.util.Random;

public class ayuda {
    private static Random random = new Random();

    //Ancho de los tableros
    private static final int FILAS = 10;
    private static final int COLUMNAS = 10;

    // Inicializamos tableros
    private static char[][] tablero1 = new char[FILAS][COLUMNAS];
    private static char[][] tablero2 = new char[FILAS][COLUMNAS];

    // Personajes Tablero1
    private static char YODA = 'Y';
    private static char DARTH_MAUL = 'D';

    // Personajes Tablero2
    private static char DARTH_VADER = 'V';
    private static char R2D2 = 'R';

    // Objetos
    private static char LIBRE = 'L';
    private static char MUROS = 'M';
    private static char FINAL = 'F';

    private static int filaYoda = 0;
    private static int columnaYoda = 0;

    private static int filaVader = 0;
    private static int columnaVader = 0;

    private static void rellenarTablero1() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero1[i][j] = LIBRE;
            }
        }
    }

    private static void rellenarTablero2() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero2[i][j] = LIBRE;
            }
        }
    }

    private static void asignarPersonajeTablero1(char personaje) {
        filaYoda = random.nextInt(FILAS);
        columnaYoda = random.nextInt(COLUMNAS);

        tablero1[filaYoda][columnaYoda] = personaje;
    }

    private static void asignarPersonajeTablero2(char personaje) {
        filaVader = random.nextInt(FILAS);
        columnaVader = random.nextInt(COLUMNAS);

        tablero2[filaVader][columnaVader] = personaje;
    }

    private static void asignarObjetoATablero1(char objeto, int numRepeticiones){
        int fila = 0;
        int columna = 0;

        for (int i = 0; i < numRepeticiones; i++) {
            do {
                fila = random.nextInt(FILAS);
                columna = random.nextInt(COLUMNAS);


            }while (tablero1[fila][columna] != 'L');
            tablero1[fila][columna] = objeto;
        }
    }

    private static void asignarObjetoATablero2(char objeto, int numRepeticiones){
        int fila = 0;
        int columna = 0;

        for (int i = 0; i < numRepeticiones; i++) {
            do {
                fila = random.nextInt(FILAS);
                columna = random.nextInt(COLUMNAS);


            }while (tablero2[fila][columna] != 'L');
            tablero2[fila][columna] = objeto;
        }
    }

    private static void imprimirTablero1() {
        System.out.println("Tablero 1");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero1[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void imprimirTablero2() {
        System.out.println("Tablero 2");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
