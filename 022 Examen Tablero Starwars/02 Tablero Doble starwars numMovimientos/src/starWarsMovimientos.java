import java.util.Random;
import java.util.Scanner;

public class starWarsMovimientos {

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

    public static void main(String[] args) {

        //Rellenamos El tablero 1 completo
        rellenarTablero1();
        asignarPersonajeTablero1(YODA);
        asignarObjetoATablero1(MUROS, 10);
        asignarObjetoATablero1(DARTH_MAUL, 10);
        tablero1[9][9] = FINAL;

        //Rellenamos El tablero 2 completo
        rellenarTablero2();
        asignarPersonajeTablero2(DARTH_VADER);
        asignarObjetoATablero2(MUROS, 10);
        asignarObjetoATablero2(R2D2, 10);
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

            Scanner mov = new Scanner(System.in);

            String movimiento = teclado.nextLine();

            int numMov = mov.nextInt();

            if (contador % 2 == 0) {
                switch (movimiento) {
                    case "W", "w":  // Movimiento hacia arriba
                        if ((filaYoda - numMov) >= 0) {
                            filaYoda = filaYoda - numMov;
                            switch (tablero1[filaYoda][columnaYoda]) {
                                case 'D':
                                    vidasTablero1 = vidasTablero1 - numMov;
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda + numMov][columnaYoda] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda + numMov][columnaYoda] = LIBRE;
                                    break;
                                case 'M':
                                    filaYoda = filaYoda + numMov;
                                    break;
                            }
                        }
                        break;

                    case "S", "s":  // Movimiento hacia abajo
                        if ((filaYoda + numMov) < tablero1.length) {
                            filaYoda = filaYoda + numMov;
                            switch (tablero1[filaYoda][columnaYoda]) {
                                case 'D':
                                    vidasTablero1 = vidasTablero1 - numMov;
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda - numMov][columnaYoda] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda - numMov][columnaYoda] = LIBRE;
                                    break;
                                case 'M':
                                    filaYoda = filaYoda - numMov;
                                    break;
                            }
                        }
                        break;

                    case "A", "a":  // Movimiento hacia la izquierda
                        if ((columnaYoda - numMov) >= 0) {
                            columnaYoda = columnaYoda - numMov;
                            switch (tablero1[filaYoda][columnaYoda]) {
                                case 'D':
                                    vidasTablero1 = vidasTablero1 - numMov;
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda][columnaYoda + numMov] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda][columnaYoda + numMov] = LIBRE;
                                    break;
                                case 'M':
                                    columnaYoda = columnaYoda + numMov;
                                    break;
                            }
                        }// Yeray estubo aqui recuerdalo
                        break;

                    case "D", "d":  // Movimiento hacia la derecha
                        if ((columnaYoda + numMov) < tablero1[0].length) {
                            columnaYoda = columnaYoda + numMov;
                            switch (tablero1[filaYoda][columnaYoda]) {
                                case 'D':
                                    vidasTablero1 = vidasTablero1 - numMov;
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda][columnaYoda - numMov] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda][columnaYoda - numMov] = LIBRE;
                                    break;
                                case 'M':
                                    columnaYoda = columnaYoda - numMov;
                                    break;
                            }
                        }
                        break;

                    case "Q", "q":  // Movimiento en diagonal hacia arriba a la izquierda
                        if ((filaYoda - numMov) >= 0 && (columnaYoda - numMov) >= 0) {
                            filaYoda = filaYoda - numMov;
                            columnaYoda = columnaYoda - numMov;
                            switch (tablero1[filaYoda][columnaYoda]) {
                                case 'D':
                                    vidasTablero1 = vidasTablero1 - numMov;
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda + 1][columnaYoda + numMov] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda + numMov][columnaYoda + numMov] = LIBRE;
                                    break;
                                case 'M':
                                    filaYoda = filaYoda + numMov;
                                    columnaYoda = columnaYoda + numMov;
                                    break;
                            }
                        }
                        break;

                    case "E", "e":  // Movimiento en diagonal hacia arriba a la derecha
                        if ((filaYoda - numMov) >= 0 && (columnaYoda + numMov) < tablero1[0].length) {
                            filaYoda = filaYoda - numMov;
                            columnaYoda = columnaYoda + numMov;
                            switch (tablero1[filaYoda][columnaYoda]) {
                                case 'D':
                                    vidasTablero1 = vidasTablero1 - numMov;
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda + numMov][columnaYoda - numMov] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda + numMov][columnaYoda - numMov] = LIBRE;
                                    break;
                                case 'M':
                                    filaYoda = filaYoda + numMov;
                                    columnaYoda = columnaYoda - numMov;
                                    break;
                            }
                        }
                        break;

                    case "Z", "z":  // Movimiento en diagonal hacia abajo a la izquierda
                        if ((filaYoda + numMov) < tablero1.length && (columnaYoda - numMov) >= 0) {
                            filaYoda = filaYoda + numMov;
                            columnaYoda = columnaYoda - numMov;
                            switch (tablero1[filaYoda][columnaYoda]) {
                                case 'D':
                                    vidasTablero1 = vidasTablero1 - numMov;
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda - numMov][columnaYoda + numMov] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda - numMov][columnaYoda + numMov] = LIBRE;
                                    break;
                                case 'M':
                                    filaYoda = filaYoda - numMov;
                                    columnaYoda = columnaYoda + numMov;
                                    break;
                            }
                        }
                        break;

                    case "X", "x":  // Movimiento en diagonal hacia abajo a la derecha
                        if ((filaYoda + numMov) < tablero1.length && (columnaYoda + numMov) < tablero1[0].length) {
                            filaYoda = filaYoda + numMov;
                            columnaYoda = columnaYoda + numMov;
                            switch (tablero1[filaYoda][columnaYoda]) {
                                case 'D':
                                    vidasTablero1 = vidasTablero1 - numMov;
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda - numMov][columnaYoda - numMov] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero1[filaYoda][columnaYoda] = YODA;
                                    tablero1[filaYoda - numMov][columnaYoda - numMov] = LIBRE;
                                    break;
                                case 'M':
                                    filaYoda = filaYoda - numMov;
                                    columnaYoda = columnaYoda - numMov;
                                    break;
                            }
                        }
                        break;

                }
                imprimirTablero1();

            }else{
                switch (movimiento) {
                    case "W", "w":  // Movimiento hacia arriba
                        if ((filaVader - numMov) >= 0) {
                            filaVader = filaVader - numMov;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'R':
                                    vidasTablero2 = vidasTablero2 - numMov;
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader + numMov][columnaVader] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader + numMov][columnaVader] = LIBRE;
                                    break;
                                case 'M':
                                    filaVader = filaVader + numMov;
                                    break;
                            }
                        }
                        break;

                    case "S", "s":  // Movimiento hacia abajo
                        if ((filaVader + numMov) < tablero2.length) {
                            filaVader= filaVader + numMov;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'R':
                                    vidasTablero2 = vidasTablero2 - numMov;
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader - numMov][columnaVader] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader - numMov][columnaVader] = LIBRE;
                                    break;
                                case 'M':
                                    filaVader = filaVader - numMov;
                                    break;
                            }
                        }
                        break;

                    case "A", "a":  // Movimiento hacia la izquierda
                        if ((columnaVader - numMov) >= 0) {
                            columnaVader = columnaVader - numMov;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'R':
                                    vidasTablero2 = vidasTablero2 - numMov;
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero1[filaVader][columnaVader + numMov] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader][columnaVader + numMov] = LIBRE;
                                    break;
                                case 'M':
                                    columnaVader = columnaVader + numMov;
                                    break;
                            }
                        }
                        break;

                    case "D", "d":  // Movimiento hacia la derecha
                        if ((columnaVader + numMov) < tablero2[0].length) {
                            columnaVader = columnaVader + numMov;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'R':
                                    vidasTablero2 = vidasTablero2 - numMov;
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader][columnaVader - numMov] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader][columnaVader - numMov] = LIBRE;
                                    break;
                                case 'M':
                                    columnaVader = columnaVader - numMov;
                                    break;
                            }
                        }
                        break;
                    case "Q", "q":  // Movimiento en diagonal hacia arriba a la izquierda
                        if ((columnaVader - numMov) >= 0 && (columnaVader - numMov) >= 0) {
                            filaVader = filaVader - numMov;
                            columnaVader = columnaVader - numMov;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'R':
                                    vidasTablero2 = vidasTablero2 - numMov;
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader + numMov][columnaVader + numMov] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader + numMov][columnaVader + numMov] = LIBRE;
                                    break;
                                case 'M':
                                    filaVader = filaVader + numMov;
                                    columnaVader = columnaVader + numMov;
                                    break;
                            }
                        }
                        break;

                    case "E", "e":  // Movimiento en diagonal hacia arriba a la derecha
                        if ((filaVader - numMov) >= 0 && (columnaVader + numMov) < tablero2[0].length) {
                            filaVader = filaVader - numMov;
                            columnaVader = columnaVader + numMov;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'R':
                                    vidasTablero2 = vidasTablero2 - numMov;
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader + numMov][columnaVader - numMov] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader + numMov][columnaVader - numMov] = LIBRE;
                                    break;
                                case 'M':
                                    filaVader = filaVader + numMov;
                                    columnaVader = columnaVader - numMov;
                                    break;
                            }
                        }
                        break;

                    case "Z", "z":  // Movimiento en diagonal hacia abajo a la izquierda
                        if ((filaVader + numMov) < tablero2.length && (columnaVader - numMov) >= 0) {
                            filaVader = filaVader + numMov;
                            columnaVader = columnaVader - numMov;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'R':
                                    vidasTablero2 = vidasTablero2 - numMov;
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader - numMov][columnaVader + numMov] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader - numMov][columnaVader + numMov] = LIBRE;
                                    break;
                                case 'M':
                                    filaVader = filaVader - numMov;
                                    columnaVader = columnaVader + numMov;
                                    break;
                            }
                        }
                        break;

                    case "X", "x":  // Movimiento en diagonal hacia abajo a la derecha
                        if ((filaVader + numMov) < tablero2.length && (columnaVader + numMov) < tablero2[0].length) {
                            filaVader = filaVader + numMov;
                            columnaVader = columnaVader + numMov;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'R':
                                    vidasTablero2 = vidasTablero2 - numMov;
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader - numMov][columnaVader - numMov] = LIBRE;
                                    System.out.println("Has Perdido Una Vida");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader] = DARTH_VADER;
                                    tablero2[filaVader - numMov][columnaVader - numMov] = LIBRE;
                                    break;
                                case 'M':
                                    filaVader = filaVader - numMov;
                                    columnaVader = columnaVader - numMov;
                                    break;
                                case 'F':
                                    vidasTablero1 = 0;
                                    break;
                            }
                        }
                        break;
                }
                imprimirTablero2();
            }
            System.out.println("===================");
            numMov = 0;
            contador ++;
        }

    }
}