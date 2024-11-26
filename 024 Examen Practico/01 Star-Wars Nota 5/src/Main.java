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

        int movimientos[][] = new int[8][2];

        // W: Arriba
        movimientos[0][0] = -1;
        movimientos[0][1] = 0;

        // A: Izquierda
        movimientos[1][0] = 0;
        movimientos[1][1] = -1;

        // S: Abajo
        movimientos[2][0] = 1;
        movimientos[2][1] = 0;

        // D: Derecha
        movimientos[3][0] = 0;
        movimientos[3][1] = 1;

        // Q: Diagonal arriba-izquierda
        movimientos[4][0] = -1;
        movimientos[4][1] = -1;

        // E: Diagonal arriba-derecha
        movimientos[5][0] = -1;
        movimientos[5][1] = 1;

        // R: Diagonal abajo-izquierda
        movimientos[6][0] = 1;
        movimientos[6][1] = -1;

        // T: Diagonal abajo-derecha
        movimientos[7][0] = 1;
        movimientos[7][1] = 1;

        char[] letras = {'W', 'A', 'S', 'D', 'Q', 'E', 'R', 'T'};

        boolean isFinalizado = true;

        int contador = 0;

        while (isFinalizado && (vidasTablero1 >= 0 || vidasTablero2 >= 0)){

            System.out.println("Dime el movimiento:");
            char direccion = leer.next().charAt(0);  //S

            System.out.println("Dime el número de casillas:");
            int casillas = leer.nextInt();  //6

            int coordenada = -1;
            for (int i = 0; i < letras.length; i++) {  //S esta en la celda 2 del array por lo que cordenada sera 2
                if (letras[i] == direccion) {
                    coordenada = i;
                    break;
                }
            }


            if (contador % 2 == 0){

                // Calcular nueva fila
                int filaCheck = filaYoda + (movimientos[coordenada][0] * casillas);  // cogemos y buscamos el valor corespondiente a la celda [2][0] en este caso = 1 y multiplicamos el mov
                if (filaCheck < 0) {
                    filaCheck = FILA + filaCheck; // Envolver hacia abajo
                } else if (filaCheck >= FILA) {
                    filaCheck = filaCheck - FILA; // Envolver hacia arriba
                }

                // Calcular nueva columna
                int columnaCheck = columnaYoda + (movimientos[coordenada][1] * casillas);
                if (columnaCheck < 0) {
                    columnaCheck = COLUMNA + columnaCheck; // Envolver hacia la derecha
                } else if (columnaCheck >= COLUMNA) {
                    columnaCheck = columnaCheck - COLUMNA; // Envolver hacia la izquierda
                }

                switch (tab1[filaCheck][columnaCheck]){
                    case LIBRE:
                        // Actualizar tablero
                        tab1[filaYoda][columnaYoda] = 'L';
                        tab1[filaCheck][columnaCheck] = 'Y';

                        // Actualizar posición del personaje
                        filaYoda = filaCheck;
                        columnaYoda = columnaCheck;
                        break;
                    case DARTH_MAUL:
                        // Actualizar tablero
                        tab1[filaYoda][columnaYoda] = 'L';
                        tab1[filaCheck][columnaCheck] = 'Y';

                        // Actualizar posición del personaje
                        filaYoda = filaCheck;
                        columnaYoda = columnaCheck;

                        vidasTablero1--;

                    case MURO:
                        System.out.println("No puedes Desplazarte a la posicion " + filaCheck + columnaCheck + " Hay un Muro");
                        break;
                    case FINAL:
                        tab1[filaYoda][columnaYoda] = 'L';
                        tab1[filaCheck][columnaCheck] = 'W';

                        filaYoda = filaCheck;
                        columnaYoda = columnaCheck;

                        System.out.println("HAS GANADO");
                        vidasTablero1 = -10;
                        isFinalizado = false;
                        break;
                }
                imprimirTab1();
            }else {

                // Calcular nueva fila
                int filaCheck = filaVader + (movimientos[coordenada][0] * casillas);  // cogemos y buscamos el valor corespondiente a la celda [2][0] en este caso = 1 y multiplicamos el mov
                if (filaCheck < 0) {
                    filaCheck = FILA + filaCheck; // Envolver hacia abajo
                } else if (filaCheck >= FILA) {
                    filaCheck = filaCheck - FILA; // Envolver hacia arriba
                }

                // Calcular nueva columna
                int columnaCheck = columnaVader + (movimientos[coordenada][1] * casillas);
                if (columnaCheck < 0) {
                    columnaCheck = COLUMNA + columnaCheck; // Envolver hacia la derecha
                } else if (columnaCheck >= COLUMNA) {
                    columnaCheck = columnaCheck - COLUMNA; // Envolver hacia la izquierda
                }

                switch (tab2[filaCheck][columnaCheck]){
                    case LIBRE:
                        // Actualizar tablero
                        tab2[filaVader][columnaVader] = 'L';
                        tab2[filaCheck][columnaCheck] = 'V';

                        // Actualizar posición del personaje
                        filaVader = filaCheck;
                        columnaVader = columnaCheck;
                        break;
                    case DARTH_MAUL:
                        // Actualizar tablero
                        tab2[filaVader][columnaVader] = 'L';
                        tab2[filaCheck][columnaCheck] = 'V';

                        // Actualizar posición del personaje
                        filaVader = filaCheck;
                        columnaVader = columnaCheck;

                        vidasTablero2--;

                    case MURO:
                        System.out.println("No puedes Desplazarte a la posicion " + filaCheck + columnaCheck + " Hay un Muro");
                        break;
                    case FINAL:
                        tab2[filaVader][columnaVader] = 'L';
                        tab2[filaCheck][columnaCheck] = 'W';

                        filaVader = filaCheck;
                        columnaVader = columnaCheck;

                        System.out.println("HAS GANADO");
                        vidasTablero2 = -10;
                        isFinalizado = false;
                        break;
                }
                imprimirTab2();
            }
            contador++;
        }
    }
}