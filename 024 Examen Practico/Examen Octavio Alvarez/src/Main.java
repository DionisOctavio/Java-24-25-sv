import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Random aleatorio = new Random();
    private static Scanner leer = new Scanner(System.in);
    private static final int FILA = 10;
    private static final int COLUMNA = 10;

    private static char[][] tab1 = new char[FILA][COLUMNA];
    private static char[][] tab2 = new char[FILA][COLUMNA];

    // Matriz Movimientos
    private static int[][] movimientos = new int[8][2];
    private static char[] letras = {'W','S','A','D','Q','E','Z','X'};

    // VIDAS
    private static int vidasTab1 = 10;
    private static int vidasTab2 = 10;


    private static int usoPoder1 = 1;
    private static int usoPoder2 = 1;



    // ATRIBUTOS TABLAS

    //TAB1
    private static char YODA = 'Y';
    private static char DARTH_MAUL = 'D';

    //TAB2
    private static char DARTH_VADER = 'V';
    private static char R2D2 = 'R';

    //OTROS
    private static char LIBRE = 'L';
    private static char FINAL = 'F';

    // Posicion de YODA
    private static int filaYoda = 0;
    private static int columnaYoda = 0;

    // Posicion de VADER
    private static int filaVader = 0;
    private static int columnaVader = 0;

    // Posiciones Trampas y el auxiliar
    private static int[] posicionTrampaTab1X = new int[5];
    private static int[] posicionTrampaTab1Y = new int[5];

    private static int[] posicionTrampaTab2X = new int[5];
    private static int[] posicionTrampaTab2Y = new int[5];

    private static int[] posicionXTrampasAux = new int[5];
    private static int[] posicionYTrampasAux = new int[5];

    private static void rellenarTab1() {
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                tab1[i][j] = LIBRE;
            }
        }
    }

    private static void rellenarTab2() {
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                tab2[i][j] = LIBRE;
            }
        }
    }

    private static void asignarPersonajeTab1() {

        filaYoda = aleatorio.nextInt(FILA);
        columnaYoda = aleatorio.nextInt(COLUMNA);

        tab1[filaYoda][columnaYoda] = YODA;

    }

    private static void asignarPersonajeTab2() {

        filaVader = aleatorio.nextInt(FILA);
        columnaVader = aleatorio.nextInt(COLUMNA);

        tab2[filaVader][columnaVader] = DARTH_VADER;

    }

    private static void asignarObjetoTab1(char objeto, int numRepeticiones){

        int filaAleatoria = 0;
        int columnaAleatoria = 0;

        for (int i = 0; i < numRepeticiones; i++) {
            do{

                filaAleatoria = aleatorio.nextInt(FILA);
                columnaAleatoria = aleatorio.nextInt(COLUMNA);

            }while (tab1[filaAleatoria][columnaAleatoria] != LIBRE);
            tab1[filaAleatoria][columnaAleatoria] = objeto;
        }
    }

    private static void asignarObjetoTab2(char objeto, int numRepeticiones){
        int filaAleatoria = 0;
        int columnaAleatoria = 0;

        for (int i = 0; i < numRepeticiones; i++) {
            do{

                filaAleatoria = aleatorio.nextInt(FILA);
                columnaAleatoria = aleatorio.nextInt(COLUMNA);

            }while (tab2[filaAleatoria][columnaAleatoria] != LIBRE);
            tab2[filaAleatoria][columnaAleatoria] = objeto;
        }
    }


    // TRAMPAS INVISIBLES
    private static void asignarTrampaTab1(){
        int filaAleatoria = 0;
        int columnaAleatoria = 0;

        for (int i = 0; i < 5; i++) {
            do{

                filaAleatoria = aleatorio.nextInt(FILA);
                columnaAleatoria = aleatorio.nextInt(COLUMNA);

            }while (tab1[filaAleatoria][columnaAleatoria] != LIBRE);

            posicionTrampaTab1X[i] = filaAleatoria;
            posicionTrampaTab1Y[i] = columnaAleatoria;
        }
    }

    private static void asignarTrampaTab2(){
        int filaAleatoria = 0;
        int columnaAleatoria = 0;

        for (int i = 0; i < 5; i++) {
            do{

                filaAleatoria = aleatorio.nextInt(FILA);
                columnaAleatoria = aleatorio.nextInt(COLUMNA);

            }while (tab2[filaAleatoria][columnaAleatoria] != LIBRE);

            posicionTrampaTab2X[i] = filaAleatoria;
            posicionTrampaTab2Y[i] = columnaAleatoria;
        }
    }

    // FUNCION QUE CAMBIA POS TRAMPAS

    private static void menearTrampasTab1() {

        posicionYTrampasAux = posicionTrampaTab1X;
        posicionYTrampasAux = posicionTrampaTab1Y;

        int filaAleatoria = 0;
        int columnaAleatoria = 0;

        for (int i = 0; i < 5; i++) {
            do{

                filaAleatoria = aleatorio.nextInt(FILA);
                columnaAleatoria = aleatorio.nextInt(COLUMNA);

            }while (tab1[filaAleatoria][columnaAleatoria] != LIBRE);

            posicionXTrampasAux[i] = filaAleatoria;
            posicionYTrampasAux[i] = columnaAleatoria;

            while (posicionTrampaTab1X[i] != posicionXTrampasAux[i] && posicionTrampaTab1Y[i] != posicionYTrampasAux[i]){
                posicionTrampaTab1X = posicionXTrampasAux;
                posicionTrampaTab1Y = posicionXTrampasAux;
            }
        }

    }

    private static void menearTrampasTab2() {

        posicionYTrampasAux = posicionTrampaTab2X;
        posicionYTrampasAux = posicionTrampaTab2Y;

        int filaAleatoria = 0;
        int columnaAleatoria = 0;

        for (int i = 0; i < 5; i++) {
            do{

                filaAleatoria = aleatorio.nextInt(FILA);
                columnaAleatoria = aleatorio.nextInt(COLUMNA);

            }while (tab1[filaAleatoria][columnaAleatoria] != LIBRE);

            posicionXTrampasAux[i] = filaAleatoria;
            posicionYTrampasAux[i] = columnaAleatoria;

            while (posicionTrampaTab2X[i] != posicionXTrampasAux[i] && posicionTrampaTab2Y[i] != posicionYTrampasAux[i]){
                posicionTrampaTab2X = posicionXTrampasAux;
                posicionTrampaTab2Y = posicionXTrampasAux;
            }
        }

    }

    private static void imprimirTab1() {
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                System.out.print(tab1[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void imprimirTab2() {
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                System.out.print(tab2[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void imprimirTrampasTab1(){
        for (int i = 0; i < 5; i++) {
            System.out.println("X" + posicionTrampaTab1X[i]);
            System.out.println("Y" + posicionTrampaTab1Y[i]);
        }
    }

    private static void imprimirTrampasTab2(){
        for (int i = 0; i < 5; i++) {
            System.out.println("X" + posicionTrampaTab2X[i]);
            System.out.println("Y" + posicionTrampaTab2Y[i]);
        }
    }

    public static void main(String[] args) {

        rellenarTab1();
        asignarPersonajeTab1();
        asignarObjetoTab1(DARTH_MAUL, 5);
        asignarTrampaTab1();
        tab1[9][9] = FINAL;

        rellenarTab2();
        asignarPersonajeTab2();
        asignarObjetoTab2(R2D2, 5);
        asignarTrampaTab2();
        tab2[9][9] = FINAL;


        imprimirTrampasTab1();
        imprimirTrampasTab2();

        // Declaro todos los Movimientos que voy a hacer
        // ARRIBA W
        movimientos[0][0] = -1;
        movimientos[0][1] = 0;

        // ABAJO S
        movimientos[1][0] = 1;
        movimientos[1][1] = 0;

        // IZQUIERDA A
        movimientos[2][0] = 0;
        movimientos[2][1] = -1;

        // DERECHA D
        movimientos[3][0] = 0;
        movimientos[3][1] = 1;

        // MOVIMIENTOS DIAGONALES

        // ARRIBA IZQUIERDA Q
        movimientos[4][0] = -1;
        movimientos[4][1] = -1;

        // ARRIBA DERECHA E
        movimientos[5][0] = -1;
        movimientos[5][1] = 1;

        // ABAJO IZQUIERDA Z
        movimientos[6][0] = 1;
        movimientos[6][1] = -1;

        // ABAJO DERECHA X
        movimientos[7][0] = 1;
        movimientos[7][1] = 1;

        int contador = 0;

        while (vidasTab1 > 0 && vidasTab2 > 0){

            System.out.println("##############################");
            System.out.println("VIDAS TAB1: [" + vidasTab1 +"]");
            imprimirTab1();
            System.out.println("##############################");
            System.out.println("VIDAS TAB2: [" + vidasTab2 +"]");
            imprimirTab2();

            if (contador % 2 == 0){
                System.out.println("####   TABLERO 1   ####");

                System.out.println("QUIERES ACTIVAR PODER? PARA ACTIVA PULSA 'P' / SI NO PULSA ''N");
                String poder = leer.nextLine();



                if (poder.charAt(0) == 'P' && usoPoder1 > 0){
                    System.out.println("Dime la cordenada X a la que quieres ir");
                    String X = leer.nextLine();
                    System.out.println("Dime la cordenada Y a la que quieres ir");
                    String Y = leer.nextLine();

                    int x = Integer.parseInt(X.substring(0));
                    int y = Integer.parseInt(Y.substring(0));

                    filaYoda = x;
                    columnaYoda = y;

                    System.out.println("##############################");
                    System.out.println("VIDAS TAB1: [" + vidasTab1 +"]");
                    imprimirTab1();
                    System.out.println("##############################");
                    System.out.println("VIDAS TAB2: [" + vidasTab2 +"]");
                    imprimirTab2();

                    usoPoder1 = 0;

                }else {
                    System.out.println("PODER NO ACTIVADO");
                }
            }else {
                System.out.println("####   TABLERO 2   ####");

                System.out.println("QUIERES ACTIVAR PODER? PARA ACTIVA PULSA 'P' / SI NO PULSA ''N");
                String poder = leer.nextLine();

                if (poder.charAt(0) == 'P' && usoPoder2 > 0){
                    System.out.println("Dime la cordenada X a la que quieres ir");
                    String X = leer.nextLine();
                    System.out.println("Dime la cordenada Y a la que quieres ir");
                    String Y = leer.nextLine();

                    int x = Integer.parseInt(X.substring(0));
                    int y = Integer.parseInt(Y.substring(0));

                    filaVader = x;
                    columnaVader = y;

                    System.out.println("##############################");
                    System.out.println("VIDAS TAB1: [" + vidasTab1 +"]");
                    imprimirTab1();
                    System.out.println("##############################");
                    System.out.println("VIDAS TAB2: [" + vidasTab2 +"]");
                    imprimirTab2();

                    usoPoder2 = 0;

                }else {
                    System.out.println("PODER NO ACTIVADO");
                }
            }
            System.out.println("Dame la direcion seguida de su movimiento [EJ: W1]:");
            String desplazamiento = leer.nextLine();

            char direccion = 'o';
            int pasos = 0;

            if (desplazamiento.length() > 2 ){
                System.out.println("MAS GRANDE TONTICO");
            } else {
                direccion = desplazamiento.charAt(0);
                String pasoStr = desplazamiento.substring(1);
                pasos = Integer.parseInt(pasoStr);
            }

            int cordenada = -1;

            for (int i = 0; i < letras.length; i++) {
                if (letras[i] == direccion){
                    cordenada = i;
                    break;
                }
            }

            if (contador % 2 == 0){

                int filaCheck = filaYoda + (movimientos[cordenada][0]*pasos);
                if (filaCheck < 0){
                    filaCheck = FILA + filaCheck;
                } else if (filaCheck > FILA) {
                filaCheck = filaCheck - FILA;
                }

                int columnaCheck = columnaYoda + (movimientos[cordenada][1]*pasos);
                if (columnaCheck < 0){
                    columnaCheck = COLUMNA + columnaCheck;
                } else if (columnaCheck > COLUMNA) {
                    columnaCheck = columnaCheck - COLUMNA;
                }

                switch (tab1[filaCheck][columnaCheck]){
                    case 'L':

                        boolean isTrampa = false;

                        for (int i = 0; i < 5; i++) {
                            if (filaCheck == posicionTrampaTab1X[i] && columnaCheck == posicionTrampaTab1Y[i]){
                                System.out.println("HAS CAIDO EN UNA TRAMPA - PIERDES UNA VIDA" + filaCheck + columnaCheck +" "+ posicionTrampaTab1X[i] + posicionTrampaTab1Y[i]);
                                vidasTab1--;
                                i = 6;
                                isTrampa = true;
                            }else {
                                continue;
                            }
                        }

                        if(isTrampa == true){
                            System.out.println("No te puedes mover a esta posicion Hay una trampa");
                        }else{
                            tab1[filaYoda][columnaYoda] = LIBRE;
                            tab1[filaCheck][columnaCheck] = YODA;

                            filaYoda = filaCheck;
                            columnaYoda = columnaCheck;

                            break;
                        }
                    case 'D':

                        tab1[filaYoda][columnaYoda] = LIBRE;
                        tab1[filaCheck][columnaCheck] = YODA;

                        filaYoda = filaCheck;
                        columnaYoda = columnaCheck;

                        vidasTab1--;
                        System.out.println("=============");
                        System.out.println("HAS PERDIDO UNA VIDA");
                        System.out.println("=============");
                        break;
                    case 'F':
                        tab1[filaYoda][columnaYoda] = LIBRE;
                        tab1[filaCheck][columnaCheck] = YODA;

                        filaYoda = filaCheck;
                        columnaYoda = columnaCheck;

                        vidasTab1 = -12;
                        break;
                }
                menearTrampasTab1();
            }else {

                int filaCheck = filaVader + (movimientos[cordenada][0]*pasos);
                if (filaCheck < 0){
                    filaCheck = FILA + filaCheck;
                } else if (filaCheck > FILA) {
                    filaCheck = filaCheck - FILA;
                }

                int columnaCheck = columnaVader + (movimientos[cordenada][1]*pasos);
                if (columnaCheck < 0){
                    columnaCheck = COLUMNA + columnaCheck;
                } else if (columnaCheck > COLUMNA) {
                    columnaCheck = columnaCheck - COLUMNA;
                }

                switch (tab2[filaCheck][columnaCheck]){
                    case 'L':

                        boolean isTrampa = false;

                        for (int i = 0; i < 5; i++) {
                            if (filaCheck == posicionTrampaTab2X[i] && columnaCheck == posicionTrampaTab2Y[i]){
                                System.out.println("HAS CAIDO EN UNA TRAMPA - PIERDES UNA VIDA" + filaCheck + columnaCheck +" "+ posicionTrampaTab2X[i] + posicionTrampaTab2Y[i]);
                                vidasTab2--;
                                i = 6;
                                isTrampa = true;
                            }else {
                                continue;
                            }
                        }

                        if(isTrampa == true){
                            System.out.println("No te puedes mover a esta posicion Hay una trampa");
                        }else{
                            tab2[filaVader][columnaVader] = LIBRE;
                            tab2[filaCheck][columnaCheck] = DARTH_VADER;

                            filaVader = filaCheck;
                            columnaVader = columnaCheck;

                            break;
                        }
                    case 'R':

                        tab2[filaVader][columnaVader] = LIBRE;
                        tab2[filaCheck][columnaCheck] = DARTH_VADER;

                        filaVader = filaCheck;
                        columnaVader = columnaCheck;

                        vidasTab2--;
                        System.out.println("=============");
                        System.out.println("HAS PERDIDO UNA VIDA");
                        System.out.println("=============");
                        break;
                    case 'F':

                        tab2[filaVader][columnaVader] = LIBRE;
                        tab2[filaCheck][columnaCheck] = DARTH_VADER;

                        filaVader = filaCheck;
                        columnaVader = columnaCheck;

                        vidasTab1 = -12;
                        break;
                }

            }
            contador++;
            imprimirTrampasTab1();
            imprimirTrampasTab2();

        }


    }
}