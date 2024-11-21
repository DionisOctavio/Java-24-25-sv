import java.io.File;
import java.nio.file.attribute.FileAttribute;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Random random = new Random();

    private static final int FILA = 9;
    private static final int COLUMNA = 9;

    private static char[][] tableroYoda = new char[COLUMNA][FILA];
    private static char[][] tableroDarthVader = new char[COLUMNA][FILA];

    private static char LIBRE = 'L';

    private static char YODA = 'Y';
    private static char DARTH_MAUl = 'D';

    private static int filaYoda = 0;
    private static int columnaYoda = 0;

    private static char DARTH_VADER = 'V';
    private static char R2D2 = 'R';

    private static char FINAL = 'F';

    private static int filaDarthVader = 0;
    private static int columnaDarthVader = 0;

    private static int vidas = 3;

    private static void rellenarTableroYoda() {
        for (int i = 0; i < COLUMNA; i++) {
            for (int j = 0; j < FILA; j++) {
                tableroYoda[i][j] = LIBRE;
            }
        }
    }

    private static void rellenarTableroDarthVader() {
        for (int i = 0; i < COLUMNA; i++) {
            for (int j = 0; j < FILA; j++) {
                tableroDarthVader[i][j] = LIBRE;
            }
        }
    }

    private static void asignarPersonajeTableroYoda() {

        filaYoda = random.nextInt(COLUMNA);
        columnaYoda = random.nextInt(FILA);

        tableroYoda[filaYoda][columnaYoda] = YODA;
    }

    private static void asignarPersonajeTableroDarthVader() {

        filaDarthVader = random.nextInt(COLUMNA);
        columnaDarthVader = random.nextInt(FILA);

        tableroDarthVader[filaDarthVader][columnaDarthVader] = DARTH_VADER;
    }

    private static void asignarEnemigoTableroYoda(char caracter, int numRepeticiones) {
        int fila = 0;
        int columna = 0;
        for (int i = 0; i < numRepeticiones; i++) {
            do {

                fila = random.nextInt(COLUMNA);
                columna = random.nextInt(FILA);

            }while (tableroYoda[fila][columna] != LIBRE);
            tableroYoda[fila][columna] = caracter;
        }
    }

    private static void asignarEnemigoTableroDarthVader(char caracter, int numRepeticiones) {
        int fila = 0;
        int columna = 0;
        for (int i = 0; i < numRepeticiones; i++) {
            do {

                fila = random.nextInt(COLUMNA);
                columna = random.nextInt(FILA);

            }while (tableroDarthVader[fila][columna] != LIBRE);
            tableroDarthVader[fila][columna] = caracter;
        }
    }

    private static void imprimirTableroYoda() {
        for (int i = 0; i < COLUMNA; i++) {
            for (int j = 0; j < FILA; j++) {
                System.out.print(tableroYoda[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void imprimirTableroDarthVader() {
        for (int i = 0; i < COLUMNA; i++) {
            for (int j = 0; j < FILA; j++) {
                System.out.print(tableroDarthVader[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        rellenarTableroYoda();
        rellenarTableroDarthVader();

        asignarPersonajeTableroYoda();
        asignarPersonajeTableroDarthVader();

        asignarEnemigoTableroYoda(DARTH_MAUl, 5);
        asignarEnemigoTableroDarthVader(R2D2, 5);

        tableroYoda[8][8] = FINAL;
        tableroDarthVader[8][8] = FINAL;

        imprimirTableroYoda();
        System.out.println();
        imprimirTableroDarthVader();



        while (vidas >= 0){

            Scanner leer = new Scanner(System.in);
            String movimiento = leer.nextLine();

            switch (movimiento){
                case "W","w":
                    if ((filaYoda - 1) >= 0){
                        filaYoda--;
                        tableroYoda[filaYoda][columnaYoda] = LIBRE;
                        tableroYoda[filaYoda][columnaYoda -1] = YODA;
                        imprimirTableroYoda();
                    }
                    break;
                case "S","s":
                    break;
                case "D","d":
                    break;
                case "A","a":
            }
        }







    }
}



