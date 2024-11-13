import java.util.Random;
import java.util.Scanner;

public class DobleTablero {

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
    private static char POCIMA = 'P';
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

    public static void main(String[] args) {

        //Rellenamos El tablero 1 completo
        rellenarTablero1();
        asignarPersonajeTablero1(YODA);
        asignarObjetoATablero1(MUROS, 10);
        asignarObjetoATablero1(DARTH_MAUL, 10);
        asignarObjetoATablero1(POCIMA, 5);
        tablero1[9][9] = FINAL;

        //Rellenamos El tablero 2 completo
        rellenarTablero2();
        asignarPersonajeTablero2(DARTH_VADER);
        asignarObjetoATablero2(MUROS, 10);
        asignarObjetoATablero2(R2D2, 10);
        asignarObjetoATablero2(POCIMA, 5);
        tablero2[9][9] = FINAL;

        int vidasTablero1 = 3;
        int vidasTablero2 = 3;

        int contador = 0;


        while (vidasTablero1 >= 0 || vidasTablero2 >= 0) {

            System.out.println();

            if (contador % 2 == 0){
                imprimirTablero1();
                System.out.println("Ingresa Movimiento - Tablero 1");
                System.out.println("Vidas: " + vidasTablero1);
            }else {
                imprimirTablero2();
                System.out.println("Ingresa Movimiento - Tablero 2");
                System.out.println("Vidas: " + vidasTablero2);
            }

            Scanner teclado = new Scanner(System.in);

            String movimiento = teclado.nextLine();

            int longitud = movimiento.length();

            if (contador % 2 == 0) {
                switch (movimiento) {
                    case "W", "w":  // Movimiento hacia arriba
                        if ((filaYoda - 1) >= 0) {
                            filaYoda = filaYoda - 1;
                            switch (tablero1[filaYoda][columnaYoda]) {
                                case 'D':
                                    vidasTablero1 = vidasTablero1 - 1;
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda + 1][columnaYoda] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda + 1][columnaYoda] = LIBRE;
                                    break;
                                case 'M':
                                    filaYoda = filaYoda + 1;
                                    break;
                                case 'P':
                                    tablero1[filaYoda][columnaYoda] = LIBRE;
                                    tablero1[filaYoda + 1][columnaYoda] = LIBRE;

                                        do{
                                            filaYoda = random.nextInt(FILAS);
                                            columnaYoda = random.nextInt(COLUMNAS);
                                        }while (tablero1[filaYoda][columnaYoda] != 'L');{

                                            tablero1[filaYoda][columnaYoda] = YODA;

                                        }
                                    break;
                            }
                        }
                        break;

                    case "S", "s":  // Movimiento hacia abajo
                        if ((filaYoda + 1) < tablero1.length) {
                            filaYoda = filaYoda + 1;
                            switch (tablero1[filaYoda][columnaYoda]) {
                                case 'D':
                                    vidasTablero1 = vidasTablero1 - 1;
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda - 1][columnaYoda] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda - 1][columnaYoda] = LIBRE;
                                    break;
                                case 'M':
                                    filaYoda = filaYoda - 1;
                                    break;
                                case 'P':
                                    tablero1[filaYoda][columnaYoda] = LIBRE;
                                    tablero1[filaYoda - 1][columnaYoda] = LIBRE;

                                    do{
                                        filaYoda = random.nextInt(FILAS);
                                        columnaYoda = random.nextInt(COLUMNAS);
                                    }while (tablero1[filaYoda][columnaYoda] != 'L');{

                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    }
                                    break;
                            }
                        }
                        break;

                    case "A", "a":  // Movimiento hacia la izquierda
                        if ((columnaYoda - 1) >= 0) {
                            columnaYoda = columnaYoda - 1;
                            switch (tablero1[filaYoda][columnaYoda]) {
                                case 'D':
                                    vidasTablero1 = vidasTablero1 - 1;
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda][columnaYoda + 1] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda][columnaYoda + 1] = LIBRE;
                                    break;
                                case 'M':
                                    columnaYoda = columnaYoda + 1;
                                    break;
                                case 'P':
                                    tablero1[filaYoda][columnaYoda] = LIBRE;
                                    tablero1[filaYoda][columnaYoda + 1] = LIBRE;

                                    do{
                                        filaYoda = random.nextInt(FILAS);
                                        columnaYoda = random.nextInt(COLUMNAS);
                                    }while (tablero1[filaYoda][columnaYoda] != 'L');{

                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    }
                                    break;
                            }
                        }
                        break;

                    case "D", "d":  // Movimiento hacia la derecha
                        if ((columnaYoda + 1) < tablero1[0].length) {
                            columnaYoda = columnaYoda + 1;
                            switch (tablero1[filaYoda][columnaYoda]) {
                                case 'D':
                                    vidasTablero1 = vidasTablero1 - 1;
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda][columnaYoda - 1] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda][columnaYoda - 1] = LIBRE;
                                    break;
                                case 'M':
                                    columnaYoda = columnaYoda - 1;
                                    break;
                                case 'P':
                                    tablero1[filaYoda][columnaYoda] = LIBRE;
                                    tablero1[filaYoda][columnaYoda - 1] = LIBRE;

                                    do{
                                        filaYoda = random.nextInt(FILAS);
                                        columnaYoda = random.nextInt(COLUMNAS);
                                    }while (tablero1[filaYoda][columnaYoda] != 'L');{

                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    vidasTablero1++;
                                    }
                                    break;
                            }
                        }
                        break;

                    case "Q", "q":  // Movimiento en diagonal hacia arriba a la izquierda
                        if ((filaYoda - 1) >= 0 && (columnaYoda - 1) >= 0) {
                            filaYoda = filaYoda - 1;
                            columnaYoda = columnaYoda - 1;
                            switch (tablero1[filaYoda][columnaYoda]) {
                                case 'D':
                                    vidasTablero1 = vidasTablero1 - 1;
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda + 1][columnaYoda + 1] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda + 1][columnaYoda + 1] = LIBRE;
                                    break;
                                case 'M':
                                    filaYoda = filaYoda + 1;
                                    columnaYoda = columnaYoda + 1;
                                    break;
                                case 'P':
                                    tablero1[filaYoda][columnaYoda] = LIBRE;
                                    tablero1[filaYoda + 1][columnaYoda + 1] = LIBRE;

                                    do{
                                        filaYoda = random.nextInt(FILAS);
                                        columnaYoda = random.nextInt(COLUMNAS);
                                    }while (tablero1[filaYoda][columnaYoda] != 'L');{

                                    tablero1[filaYoda][columnaYoda] = YODA;
                                }
                                break;
                            }
                        }
                        break;

                    case "E", "e":  // Movimiento en diagonal hacia arriba a la derecha
                        if ((filaYoda - 1) >= 0 && (columnaYoda + 1) < tablero1[0].length) {
                            filaYoda = filaYoda - 1;
                            columnaYoda = columnaYoda + 1;
                            switch (tablero1[filaYoda][columnaYoda]) {
                                case 'D':
                                    vidasTablero1 = vidasTablero1 - 1;
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda + 1][columnaYoda - 1] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda + 1][columnaYoda - 1] = LIBRE;
                                    break;
                                case 'M':
                                    filaYoda = filaYoda + 1;
                                    columnaYoda = columnaYoda - 1;
                                    break;
                                case 'P':
                                    tablero1[filaYoda][columnaYoda] = LIBRE;
                                    tablero1[filaYoda + 1][columnaYoda - 1] = LIBRE;

                                    do{
                                        filaYoda = random.nextInt(FILAS);
                                        columnaYoda = random.nextInt(COLUMNAS);
                                    }while (tablero1[filaYoda][columnaYoda] != 'L');{

                                    tablero1[filaYoda][columnaYoda] = YODA;
                                }
                                break;
                            }
                        }
                        break;

                    case "Z", "z":  // Movimiento en diagonal hacia abajo a la izquierda
                        if ((filaYoda + 1) < tablero1.length && (columnaYoda - 1) >= 0) {
                            filaYoda = filaYoda + 1;
                            columnaYoda = columnaYoda - 1;
                            switch (tablero1[filaYoda][columnaYoda]) {
                                case 'D':
                                    vidasTablero1 = vidasTablero1 - 1;
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda - 1][columnaYoda + 1] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda - 1][columnaYoda + 1] = LIBRE;
                                    break;
                                case 'M':
                                    filaYoda = filaYoda - 1;
                                    columnaYoda = columnaYoda + 1;
                                    break;
                                case 'P':
                                    tablero1[filaYoda][columnaYoda] = LIBRE;
                                    tablero1[filaYoda - 1][columnaYoda + 1] = LIBRE;

                                    do{
                                        filaYoda = random.nextInt(FILAS);
                                        columnaYoda = random.nextInt(COLUMNAS);
                                    }while (tablero1[filaYoda][columnaYoda] != 'L');{

                                    tablero1[filaYoda][columnaYoda] = YODA;
                                }
                                break;
                            }
                        }
                        break;

                    case "X", "x":  // Movimiento en diagonal hacia abajo a la derecha
                        if ((filaYoda + 1) < tablero1.length && (columnaYoda + 1) < tablero1[0].length) {
                            filaYoda = filaYoda + 1;
                            columnaYoda = columnaYoda + 1;
                            switch (tablero1[filaYoda][columnaYoda]) {
                                case 'D':
                                    vidasTablero1 = vidasTablero1 - 1;
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda - 1][columnaYoda - 1] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda - 1][columnaYoda - 1] = LIBRE;
                                    break;
                                case 'M':
                                    filaYoda = filaYoda - 1;
                                    columnaYoda = columnaYoda - 1;
                                    break;
                                case 'P':
                                    tablero1[filaYoda][columnaYoda] = LIBRE;
                                    tablero1[filaYoda - 1][columnaYoda - 1] = LIBRE;

                                    do{
                                        filaYoda = random.nextInt(FILAS);
                                        columnaYoda = random.nextInt(COLUMNAS);
                                    }while (tablero1[filaYoda][columnaYoda] != 'L');{

                                    tablero1[filaYoda][columnaYoda] = YODA;
                                }
                                break;
                            }
                        }
                        break;

                }
                imprimirTablero1();
                System.out.println("===================");

            }else{
                switch (movimiento) {
                    case "W", "w":  // Movimiento hacia arriba
                        if ((filaVader - 1) >= 0) {
                            filaVader = filaVader - 1;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'R':
                                    vidasTablero2 = vidasTablero2 - 1;
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader + 1][columnaVader] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader + 1][columnaVader] = LIBRE;
                                    break;
                                case 'M':
                                    filaVader = filaVader + 1;
                                    break;
                            }
                        }
                        break;

                    case "S", "s":  // Movimiento hacia abajo
                        if (( + 1) < tablero2.length) {
                            filaVader= filaVader + 1;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'R':
                                    vidasTablero2 = vidasTablero2 - 1;
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader - 1][columnaVader] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader - 1][columnaVader] = LIBRE;
                                    break;
                                case 'M':
                                    filaVader = filaVader - 1;
                                    break;
                            }
                        }
                        break;

                    case "A", "a":  // Movimiento hacia la izquierda
                        if ((columnaVader - 1) >= 0) {
                            columnaVader = columnaVader - 1;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'R':
                                    vidasTablero2 = vidasTablero2 - 1;
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero1[filaVader][columnaVader + 1] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader][columnaVader + 1] = LIBRE;
                                    break;
                                case 'M':
                                    columnaVader = columnaVader + 1;
                                    break;
                            }
                        }
                        break;

                    case "D", "d":  // Movimiento hacia la derecha
                        if ((columnaVader + 1) < tablero2[0].length) {
                            columnaVader = columnaVader + 1;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'R':
                                    vidasTablero2 = vidasTablero2 - 1;
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader][columnaVader - 1] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader][columnaVader - 1] = LIBRE;
                                    break;
                                case 'M':
                                    columnaVader = columnaVader - 1;
                                    break;
                            }
                        }
                        break;
                    case "Q", "q":  // Movimiento en diagonal hacia arriba a la izquierda
                        if ((columnaVader - 1) >= 0 && (columnaVader - 1) >= 0) {
                            filaVader = filaVader - 1;
                            columnaVader = columnaVader - 1;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'R':
                                    vidasTablero2 = vidasTablero2 - 1;
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader + 1][columnaVader + 1] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader + 1][columnaVader + 1] = LIBRE;
                                    break;
                                case 'M':
                                    filaVader = filaVader + 1;
                                    columnaVader = columnaVader + 1;
                                    break;
                            }
                        }
                        break;

                    case "E", "e":  // Movimiento en diagonal hacia arriba a la derecha
                        if ((filaVader - 1) >= 0 && (columnaVader + 1) < tablero2[0].length) {
                            filaVader = filaVader - 1;
                            columnaVader = columnaVader + 1;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'R':
                                    vidasTablero2 = vidasTablero2 - 1;
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader + 1][columnaVader - 1] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader + 1][columnaVader - 1] = LIBRE;
                                    break;
                                case 'M':
                                    filaVader = filaVader + 1;
                                    columnaVader = columnaVader - 1;
                                    break;
                            }
                        }
                        break;

                    case "Z", "z":  // Movimiento en diagonal hacia abajo a la izquierda
                        if ((filaVader + 1) < tablero2.length && (columnaVader - 1) >= 0) {
                            filaVader = filaVader + 1;
                            columnaVader = columnaVader - 1;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'R':
                                    vidasTablero2 = vidasTablero2 - 1;
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader - 1][columnaVader + 1] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader - 1][columnaVader + 1] = LIBRE;
                                    break;
                                case 'M':
                                    filaVader = filaVader - 1;
                                    columnaVader = columnaVader + 1;
                                    break;
                            }
                        }
                        break;

                    case "X", "x":  // Movimiento en diagonal hacia abajo a la derecha
                        if ((filaVader + 1) < tablero2.length && (columnaVader + 1) < tablero2[0].length) {
                            filaVader = filaVader + 1;
                            columnaVader = columnaVader + 1;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'R':
                                    vidasTablero2 = vidasTablero2 - 1;
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader - 1][columnaVader - 1] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader - 1][columnaVader - 1] = LIBRE;
                                    break;
                                case 'M':
                                    filaVader = filaVader - 1;
                                    columnaVader = columnaVader - 1;
                                    break;
                            }
                        }
                        break;
                }
                imprimirTablero2();
                System.out.println("===================");
            }
            contador ++;
        }

    }
}