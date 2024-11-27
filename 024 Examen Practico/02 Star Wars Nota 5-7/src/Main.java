import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

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

    // MATRIZ DE MOVIMIENTOS
    private static int[][] movimientos = new int[8][2];
    private static char[] letras ={'W','S','A','D','Q','E','Z','X'};

    // CONSTANTES
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

        System.out.println();

        rellenarTab2();
        asignarPersonajeTab2();
        asignarObjetosTab2(R2D2, 5);
        asignarObjetosTab2(MURO, 5);
        tab2[9][9] = FINAL;

        // DEFINO LOS MIVIMIENT QUE VO A TENER EN MI MATRIZ

        // W --- Arriba
        movimientos[0][0] = -1;
        movimientos[0][1] = 0;

        // S --- Abajo
        movimientos[1][0] = 1;
        movimientos[1][1] = 0;

        // A --- Izquierda
        movimientos[2][0] = 0;
        movimientos[2][1] = -1;

        // D --- Derecha
        movimientos[3][0] = 0;
        movimientos[3][1] = 1;

        // Q --- Arriba-Izquierda
        movimientos[4][0] = -1;
        movimientos[4][1] = -1;

        // E --- Arriba-Derecha
        movimientos[5][0] = -1;
        movimientos[5][1] = 1;

        // Z --- Abajo-Izquierda
        movimientos[6][0] = 1;
        movimientos[6][1] = -1;

        // X --- Abajo-Derecha
        movimientos[7][0] = 1;
        movimientos[7][1] = 1;

        boolean isFinalizado = false;
        int contador = 0;

        while (isFinalizado = true && (vidasTablero1 >= 0 || vidasTablero2 >= 0)){

            System.out.println("#####################################################");
            System.out.println("VIDAS - TAB 1 : " + vidasTablero1);
            imprimirTab1();
            System.out.println("#####################################################");
            System.out.println("VIDAS - TAB 2 : " + vidasTablero2);
            imprimirTab2();
            System.out.println("#####################################################");

            if (contador % 2 == 0){
                System.out.println("############  Tablero 1  ############");
            }else {
                System.out.println("############  Tablero 2  ############");
            }
            System.out.println("######  Ingresa el Movimiento  ######");
            String desplazamiento = leer.nextLine();

            char direccion = 0;
            int pasos = 0;

            if (desplazamiento.length() < 2) {
                System.out.println("TONTICO QUE TE FALTA ALGO");
            }else {
                direccion = desplazamiento.charAt(0);
                String pasosStr = desplazamiento.substring(1);
                pasos = Integer.parseInt(pasosStr);
            }

            int cordenada = 0;

            for (int i = 0; i < letras.length; i++) {
                if (letras[i] == direccion) {
                    cordenada = i;
                    break;
                }
            }

            if (contador % 2 == 0){

                int filaCheck = filaYoda + (movimientos[cordenada][0]*pasos);
                if (filaCheck < 0) {
                    filaCheck = FILA + filaCheck; // Envolver hacia abajo
                } else if (filaCheck >= FILA) {
                    filaCheck = filaCheck - FILA; // Envolver hacia arriba
                }

                int columnaCheck = columnaYoda + (movimientos[cordenada][1]*pasos);
                if (columnaCheck < 0){
                    columnaCheck = COLUMNA + columnaCheck;
                }else if (columnaCheck >= COLUMNA){
                    columnaCheck = columnaCheck - COLUMNA;
                }

                switch (tab1[filaCheck][columnaCheck]){
                    case LIBRE:
                        tab1[filaYoda][columnaYoda] = LIBRE;
                        tab1[filaCheck][columnaCheck] = YODA;

                        filaYoda = filaCheck;
                        columnaYoda = columnaCheck;

                        break;
                    case DARTH_MAUL:
                        tab1[filaYoda][columnaYoda] = LIBRE;
                        tab1[filaCheck][columnaCheck] = YODA;

                        filaYoda = filaCheck;
                        columnaYoda = columnaCheck;

                        vidasTablero1--;
                        break;
                    case MURO:
                        System.out.println("#######################");
                        System.out.println("AQUI HA UN MURO TONTICO");
                        System.out.println("#######################");
                        break;
                    case FINAL:
                        tab1[filaYoda][columnaYoda] = LIBRE;
                        tab1[filaCheck][columnaCheck] = YODA;

                        filaYoda = filaCheck;
                        columnaYoda = columnaCheck;

                        vidasTablero1 = - 10000000;
                        isFinalizado = true;
                        break;
                }
            }else {

                int filaCheck = filaVader + (movimientos[cordenada][0] * pasos);
                if (filaCheck < 0) {
                    filaCheck = FILA + filaCheck; // Envolver hacia abajo
                } else if (filaCheck >= FILA) {
                    filaCheck = filaCheck - FILA; // Envolver hacia arriba
                }

                int columnaCheck = columnaVader + (movimientos[cordenada][1] * pasos);
                if (columnaCheck < 0) {
                    columnaCheck = COLUMNA + columnaCheck;
                } else if (columnaCheck >= COLUMNA) {
                    columnaCheck = columnaCheck - COLUMNA;
                }

                switch (tab2[filaCheck][columnaCheck]) {
                    case LIBRE:
                        tab2[filaVader][columnaVader] = LIBRE;
                        tab2[filaCheck][columnaCheck] = DARTH_VADER;

                        filaVader = filaCheck;
                        columnaVader = columnaCheck;

                        break;
                    case DARTH_MAUL:
                        tab2[filaVader][columnaVader] = LIBRE;
                        tab2[filaCheck][columnaCheck] = DARTH_VADER;

                        filaVader = filaCheck;
                        columnaVader = columnaCheck;

                        vidasTablero2--;
                        break;
                    case MURO:
                        System.out.println("#######################");
                        System.out.println("AQUI HA UN MURO TONTICO");
                        System.out.println("#######################");
                        break;
                    case FINAL:
                        tab2[filaVader][columnaVader] = LIBRE;
                        tab2[filaCheck][columnaCheck] = DARTH_VADER;

                        filaVader = filaCheck;
                        columnaVader = columnaCheck;

                        vidasTablero2 = -10000000;
                        isFinalizado = true;
                        break;
                }
            }
            if (vidasTablero1 < 0 || vidasTablero2 < 0){
                isFinalizado = true;
            }
            contador++;
        }

    }
}