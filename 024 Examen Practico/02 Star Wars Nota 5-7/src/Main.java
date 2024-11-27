import java.util.Random;
import java.util.Scanner;

public class Main {

    // DECLARAMOS LAS HERAMIENTAS A USAR
    private static Random random = new Random();
    private static Scanner leer = new Scanner(System.in);

    // DECLARAMOS EL ANCHO Y ALTO DEL TABLERO
    private static final int FILA = 10;
    private static final int COLUMNA = 10;

    // INICIALIZAMOS LOS DOS TABLEROS
    private static char[][] tab1= new char[FILA][COLUMNA];

    private static char[][] tab2= new char[FILA][COLUMNA];

    private static int vidasTablero1 = 3;
    private static int vidasTablero2 = 3;

    //CONSTANTES
    // PERSONAJES TAB 1
    private static final char YODA = 'Y';
    private static final char DARTH_MAUL = 'D';

    // PERSONAJES TAB 2
    private static final char DARTH_VADER = 'V';
    private static final char R2D2 = 'R';

    // OBJETOS TABLEROS
    private static final char MURO = 'M';
    private static final char LIBRE = 'L';
    private static final char FINAL = 'F';

    private static int filaYoda = 0;
    private static int columnaYoda = 0;

    private static int filaVader = 0;
    private static int columnaVader = 0;

    // FUNCIONES/PROCEDIMIENTOS

    // RELLENAMOS EL PRIMER TABLEROS DE 'L'
    private static void rellenarTab1(){
        for (int i = 0; i < FILA; i++){
            for (int j = 0; j < COLUMNA; j++){
                tab1[i][j] = LIBRE;
            }
        }
    }

    // RELLENAMOS EL SEGUNDO TABLEROS DE 'L'
    private static void rellenarTab2(){
        for (int i = 0; i < FILA; i++){
            for (int j = 0; j < COLUMNA; j++){
                tab2[i][j] = LIBRE;
            }
        }
    }

    // ASIGNAMOS A NUESTRO PERSONAJE YODA A UNA CELDA ALEATORIA DEL TABLERO
    private static void asignarPersonajeTab1(){

        filaYoda = random.nextInt(FILA);
        columnaYoda = random.nextInt(COLUMNA);

        tab1[filaYoda][columnaYoda] = YODA;

    }

    // ASIGNAMOS A NUESTRO PERSONAJE DARTH_VADER A UNA CELDA ALEATORIA DEL TABLERO
    private static void asignarPersonajeTab2(){

        filaVader = random.nextInt(FILA);
        columnaVader = random.nextInt(COLUMNA);

        tab2[filaVader][columnaVader] = DARTH_VADER;
    }

    private static void asignarObjetosTab1(char enemigo, int numEnemios){
        for (int i = 0; i < numEnemios; i++){
            int filaAleatorio = 0;
            int columnaAleatorio = 0;

            do {

                filaAleatorio = random.nextInt(FILA);
                columnaAleatorio = random.nextInt(COLUMNA);

            }while (tab1[filaAleatorio][columnaAleatorio] != LIBRE);
            tab1[filaAleatorio][columnaAleatorio] = enemigo;
        }
    }

    private static void asignarObjetosTab2(char enemigo, int numEnemios){
        for (int i = 0; i < numEnemios; i++){
            int filaAleatorio = 0;
            int columnaAleatorio = 0;

            do {

                filaAleatorio = random.nextInt(FILA);
                columnaAleatorio = random.nextInt(COLUMNA);

            }while (tab2[filaAleatorio][columnaAleatorio] != LIBRE);
            tab2[filaAleatorio][columnaAleatorio] = enemigo;
        }
    }

    private static void imprimirTab1() {
        for (int i = 0; i < FILA; i++){
            for (int j = 0; j < COLUMNA; j++){
                System.out.print(tab1[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void imprimirTab2() {
        for (int i = 0; i < FILA; i++){
            for (int j = 0; j < COLUMNA; j++){
                System.out.print(tab2[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        rellenarTab1();
        asignarPersonajeTab1();
        asignarObjetosTab1(DARTH_MAUL, 5);
        asignarObjetosTab1(MURO, 5);
        tab1[9][9] = FINAL;
        imprimirTab1();

        System.out.println();

        rellenarTab2();
        asignarPersonajeTab2();
        asignarObjetosTab2(R2D2, 5);
        asignarObjetosTab2(MURO, 5);
        tab2[9][9] = FINAL;
        imprimirTab2();

    }
}