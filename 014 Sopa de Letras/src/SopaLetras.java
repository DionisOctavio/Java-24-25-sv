import java.util.Random;

public class SopaLetras {

    public static Random random = new Random();

    private static char[] abecedario = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private static String[] palabras = {"SOPA","COCO","SAPO","CIELO","ARBOL"};

    private static final int FILA = 10;
    private static final int COLUMNA = 10;

    private static char[][] tablero = new char[COLUMNA][FILA];



    // Rellenamos el tablero de letras aleatoriamente del abecedario
    private static void rellenarTablero() {
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                int aleatorio = random.nextInt(26);
                tablero[i][j] = abecedario[aleatorio];
            }
        }
    }


    // Simplemente imrime el tablero
    private static void imprimirTablero() {
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        rellenarTablero();
        imprimirTablero();

        // Rellenamos el tablero con las palabras que hemos añaido
        int contador = palabras.length;

        while (contador >= 0) {
            contador--;

            // Array palabras generamos un aleatorio de el numero de longitu el array y lo guaramos en palabra
            String palabra = palabras[random.nextInt(palabras.length)];

            int direccion = random.nextInt(3);
            int fila = 0;
            int columna = 0;

            // Utilizo unsuitch que dependiendo el numero lo posicionara en una orientacion.
            switch (direccion){
                case 0:// Horizontal
                    fila = random.nextInt(FILA); // Selecciona una fila aleatoria del 0 al 9
                    columna = random.nextInt(COLUMNA - palabra.length()); // selecionamos uns fila para que la palabra comienze

                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila][columna + i] = palabra.charAt(i); // inserto el primer caracter de la cadena
                    }
                    break;
                case 1:// Vertical
                    fila = random.nextInt(FILA - palabra.length());
                    columna = random.nextInt(COLUMNA);

                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila + i][columna] = palabra.charAt(i);
                    }
                    break;
                case 2:// Diagonal
                    fila = random.nextInt(FILA - palabra.length());
                    columna = random.nextInt(COLUMNA - palabra.length());

                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila + i][columna + i] = palabra.charAt(i);
                    }
                    break;
            }
        }
        System.out.println();
        imprimirTablero();
    }
}